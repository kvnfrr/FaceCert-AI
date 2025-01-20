# FaceCert AI

FaceCert AI is a Java-based web application that leverages Spring Boot to implement AI-driven facial recognition for secure user authentication. The project emphasizes user privacy by ensuring all facial data is stored locally on the user's device.

## Installation

To set up and run FaceCert AI, follow these steps:

### Prerequisites
1. Install Java Development Kit (JDK) version 17 or higher.
2. Ensure you have a build tool like Gradle installed and configured.
3. Set up a Spring Boot development environment.

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

This project is currently in its initial stages. The application runs a basic Spring Boot setup with placeholder functionality. Future updates will include:
- "Create Face ID" functionality for users to register their faces.
- "Sign In" functionality for users to authenticate via facial recognition.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss your proposal.

Please ensure that contributions adhere to best practices for Java, Spring Boot, and Gradle development.

## License

[MIT](https://choosealicense.com/licenses/mit/)
