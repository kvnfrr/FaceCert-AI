async function recognizeFace(uploadedImage) {
    const img = await faceapi.bufferToImage(uploadedImage);

    // Detect face and extract descriptor
    const detection = await faceapi.detectSingleFace(img)
        .withFaceLandmarks()
        .withFaceDescriptor();

    if (!detection) {
        alert("No face detected in login image.");
        return false;
    }

    const uploadedDescriptor = detection.descriptor;

    // Retrieve saved descriptors from IndexedDB
    const savedDescriptors = await getFromIndexedDB(); // Implement this function
    let bestMatch = null;
    let lowestDistance = Number.MAX_SAFE_INTEGER;

    savedDescriptors.forEach((data) => {
        const distance = faceapi.euclideanDistance(uploadedDescriptor, data.descriptor);
        if (distance < lowestDistance) {
            lowestDistance = distance;
            bestMatch = data;
        }
    });

    console.log("Best match:", bestMatch, "Distance:", lowestDistance);

    if (lowestDistance < 0.6) { // Threshold for face recognition
        alert(`Welcome back, ${bestMatch.metadata.name}!`);
        return true;
    } else {
        alert("Face not recognized. Please try again.");
        return false;
    }
}

// Attach event listener to the sign-in form
document.getElementById("signin-form").addEventListener("submit", async (event) => {
    event.preventDefault();
    const fileInput = document.getElementById("signinFaceImage");
    const file = fileInput.files[0];

    if (!file) {
        alert("Please upload an image!");
        return;
    }

    await recognizeFace(file);
});
