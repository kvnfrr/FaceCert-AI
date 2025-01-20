document.addEventListener("DOMContentLoaded", () => {
    const dbName = "FaceCertDB";
    const storeName = "FaceCertStore";

    // Open or create the IndexedDB database
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

    // Save data to IndexedDB
    const saveToIndexedDB = (data) => {
        const db = openDB.result;
        if (!db) {
            console.error("Database is not available.");
            return;
        }

        const transaction = db.transaction(storeName, "readwrite");
        const store = transaction.objectStore(storeName);

        const request = store.add(data);

        request.onsuccess = () => {
            console.log("Data saved successfully:", data);
        };

        request.onerror = (event) => {
            console.error("Error saving data:", event.target.error);
        };

        transaction.onerror = (event) => {
            console.error("Transaction error:", event.target.error);
        };
    };
    window.saveToIndexedDB = saveToIndexedDB; // Expose globally

    // Fetch all data from IndexedDB
    const fetchAllFromIndexedDB = () => {
        const db = openDB.result;
        if (!db) {
            console.error("Database is not available.");
            return;
        }

        const transaction = db.transaction(storeName, "readonly");
        const store = transaction.objectStore(storeName);

        const getAllRequest = store.getAll();

        getAllRequest.onsuccess = (event) => {
            const storedData = event.target.result;
            console.log("All stored data:", storedData);

            storedData.forEach((data) => {
                if (data.content) {
                    console.log("Stored content:", data.content);
                }
            });
        };

        getAllRequest.onerror = (event) => {
            console.error("Error fetching data:", event.target.error);
        };
    };

    // Attach functions to the window object to make them globally accessible
    window.fetchAllFromIndexedDB = fetchAllFromIndexedDB;
});
