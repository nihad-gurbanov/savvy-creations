# Savvy Creations

Savvy Creations is a platform designed to connect entry-level professionals and recent graduates with small to medium-sized businesses (SMBs) that have limited budgets. The platform facilitates the development of Minimum Viable Products (MVPs) by matching SMBs' project needs with suitable candidates.

## Features

- **Project Posting**: SMBs can post projects specifying their requirements, objectives, and constraints.

- **Candidate Applications**: Entry-level professionals and graduates can browse available projects and submit requests to participate.

- **Role Definitions**: Each project includes predefined roles such as frontend developer, backend developer, mobile developer, etc., allowing candidates to apply for positions that align with their skills.

- **Approval Process**: SMBs review candidate applications and approve suitable individuals to collaborate on building the MVP.

## Project Structure

The repository is organized as follows:

- **`front/`**: Contains the frontend codebase, including user interfaces and client-side logic.

- **`src/main/`**: Holds the backend codebase, managing server-side operations and database interactions.

- **`UX_UI/`**: Includes design assets, wireframes, and user experience documentation.

- **`gradle/`**: Contains Gradle wrapper files for build automation.

- **Root Files**:
  - `build.gradle`: Build configuration file.
  - `settings.gradle`: Settings for the Gradle build.
  - `gradlew` and `gradlew.bat`: Scripts to run the Gradle wrapper on Unix and Windows systems, respectively.
  - `.gitignore`: Specifies files and directories to be ignored by Git.

## Technologies Used

- **Java**: Primary language for backend development (46.2% of the codebase).

- **JavaScript**: Used for frontend development and client-side interactions (45.8% of the codebase).

- **CSS**: Stylesheets for designing and customizing the user interface (7.5% of the codebase).

- **HTML**: Markup language for structuring web pages (0.5% of the codebase).

## Screenshots

To provide a visual overview of the platform, here are some screenshots illustrating key features:

1. **Homepage**: Displays the platform's mission and recent projects.

   ![Homepage Screenshot](https://github.com/nihad-gurbanov/savvy-creations/blob/main/UX_UI/UIs/index.png)

2. **Project Listing**: Shows available projects with details and required roles.

   ![Project Listing Screenshot](https://github.com/nihad-gurbanov/savvy-creations/blob/main/UX_UI/UIs/projects.png)

3. **Project Details**: Provides in-depth information about a specific project, including objectives and required skills.

   ![Project Details Screenshot](https://github.com/nihad-gurbanov/savvy-creations/blob/main/UX_UI/UIs/project%20details%20signed%20in.png

4. **Candidate Dashboard**: Allows candidates to manage their applications and view project statuses.

   ![Candidate Dashboard Screenshot](https://github.com/nihad-gurbanov/savvy-creations/blob/main/UX_UI/UIs/developer%20profile%20private.png

*Note: The above links assume that the images are stored in the `UX_UI` directory of the repository. Please ensure the paths are correct based on your repository structure.*

## Getting Started

To set up the project locally:

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/nihad-gurbanov/savvy-creations.git
   ```

2. **Navigate to the Project Directory**:

   ```bash
   cd savvy-creations
   ```

3. **Build the Project**:

   - Ensure you have [Gradle](https://gradle.org/) installed.

   - Run the build script:

     ```bash
     ./gradlew build
     ```

4. **Run the Application**:

   - Execute the following command:

     ```bash
     ./gradlew bootRun
     ```

   - Access the application at `http://localhost:8080` in your web browser.

## Contributing

We welcome contributions to enhance the platform. To contribute:

1. **Fork the Repository**: Click on the 'Fork' button at the top right corner of this page.

2. **Create a New Branch**: Use a descriptive name for your branch.

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Changes**: Implement your feature or fix.

4. **Commit Changes**: Provide a clear and concise commit message.

   ```bash
   git commit -m "Add feature: your feature name"
   ```

5. **Push to Your Fork**:

   ```bash
   git push origin feature/your-feature-name
   ```

6. **Submit a Pull Request**: Navigate to the original repository and click on 'New Pull Request'.


