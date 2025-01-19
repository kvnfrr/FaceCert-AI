# FaceCert AI

FaceCert AI is a Java-based web application that leverages Spring Boot to implement AI-driven facial recognition for secure user authentication. The project emphasizes user privacy by ensuring all facial data is stored locally on the user's device.

## Installation

To set up and run FaceCert AI, follow these steps:

### Prerequisites
1. Install Java Development Kit (JDK) version 17 or higher.
2. Ensure you have a build tool like Gradle installed and configured.
3. Set up a Spring Boot development environment.
4. The application uses IndexedDB, which is supported in most modern browsers (e.g., Chrome, Edge, Firefox, Safari).

### Steps to Clone and Run

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd facecert-ai
   ```

2. Import the project into your preferred IDE or text editor.

3. Build and run the project:
   - Use Gradle to download dependencies and build the application:
     ```bash
     ./gradlew build
     ```
   - Run the application:
     ```bash
     ./gradlew bootRun
     ```

4. Access the application:
   - Open your browser and navigate to `http://localhost:8080`.

## Usage

This project is currently in its initial stages. The application runs a basic Spring Boot setup for AI-driven facial recognition and now includes the following functionality:

- Create Face ID: Allows users to upload facial images. Uploaded data (e.g., file metadata and Base64-encoded content) is securely stored in the user's browser using IndexedDB, ensuring user privacy. 
- Sign In: Placeholder functionality for authentication, to be expanded in future iterations.

Note: All user data, including uploaded facial images, is stored locally on the user's device in the browser's IndexedDB. The server does not store any sensitive user information or images.

#### How to Use

1. Navigate to the Create Face ID page.
2. Upload an image file (JPEG or PNG, max size 5MB).
3. The uploaded file's metadata and content will be stored locally in the browser.
4. Use the browser's developer tools (Application > IndexedDB) to inspect saved data if needed.

## Planned Features
- AI integration for facial recognition-based authentication.
- Enhanced privacy and security features.
- Additional user-friendly UI components.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss your proposal.

- Ensure code follows Java, Spring Boot, and Gradle best practices.
- Update the README and other relevant documentation when necessary.
- Include unit tests where applicable.

### Key Updates:
1. **Added Current Features**: Detailed features implemented so far.
2. **Planned Features**: Highlighted future functionality to clarify project goals.
3. **Project Structure**: Brief overview of the directory structure.
4. **Updated Prerequisites**: Clarified browser requirement and IDE recommendation.


## License

[MIT](https://choosealicense.com/licenses/mit/)

