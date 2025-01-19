document.addEventListener("DOMContentLoaded", () => {
    const dbName = "FaceCertDB";
    const storeName = "FaceCertStore";

    // Open the IndexedDB database
    const openDB = indexedDB.open(dbName, 1);

    openDB.onupgradeneeded = (event) => {
        const db = event.target.result;

        // Create an object store if it doesn't exist
        if (!db.objectStoreNames.contains(storeName)) {
            db.createObjectStore(storeName, { keyPath: "id", autoIncrement: true });
        }
        console.log("Database and object store created successfully.");
    };

    openDB.onsuccess = (event) => {
        console.log("Database opened successfully.");
    };

    openDB.onerror = (event) => {
        console.error("Error opening database:", event.target.error);
    };

    // Function to save data to IndexedDB
    const saveToIndexedDB = (data) => {
        const db = openDB.result;
        const transaction = db.transaction(storeName, "readwrite");
        const store = transaction.objectStore(storeName);

        const request = store.add(data);

        request.onsuccess = () => {
            console.log("Data saved successfully:", data);
            alert("File data saved successfully!");
        };

        request.onerror = (event) => {
            console.error("Error saving data:", event.target.error);
            alert("Failed to save file data. See console for details.");
        };

        transaction.onerror = (event) => {
            console.error("Transaction error:", event.target.error);
        };
    };

    // Function to fetch and log all stored data
    const fetchAllFromIndexedDB = () => {
        const db = openDB.result;
        const transaction = db.transaction(storeName, "readonly");
        const store = transaction.objectStore(storeName);

        const getAllRequest = store.getAll();

        getAllRequest.onsuccess = (event) => {
            console.log("All stored data:", event.target.result);
        };

        getAllRequest.onerror = (event) => {
            console.error("Error fetching data:", event.target.error);
        };
    };

    // Attach event listener to the form or upload button
    const form = document.getElementById("face-upload-form"); // Ensure your form has this ID
    if (form) {
        form.addEventListener("submit", (event) => {
            event.preventDefault();

            // Extract file info
            const fileInput = document.getElementById("faceImage"); // Ensure your file input has this ID
            const file = fileInput.files[0];

            if (!file) {
                alert("No file selected.");
                return;
            }

            // Use FileReader to read the file content
            const reader = new FileReader();

            reader.onload = () => {
                const fileData = {
                    name: file.name,
                    size: file.size,
                    type: file.type,
                    content: reader.result, // Base64 string of the file
                    date: new Date(),
                };
                saveToIndexedDB(fileData);
                fetchAllFromIndexedDB(); // Debugging: Fetch all data after saving
            };

            reader.onerror = (error) => {
                console.error("Error reading file:", error);
                alert("Failed to read the file. See console for details.");
            };

            reader.readAsDataURL(file); // Converts file to Base64 string
        });
    }
});
