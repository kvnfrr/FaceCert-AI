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

1. Home Page: The main landing page of the application.
2. Sign In Page: Allows users to log in with placeholder authentication.
3. Create Face ID: Users can upload a facial image to set up their Face ID. Uploaded images are currently logged for development purposes.

#### Planned Features
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

