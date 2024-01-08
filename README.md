# Premier League Manager App

## Overview
This project is a Premier League Manager application implemented in Java using the Play Framework for the backend and Angular for the frontend. It allows the management of football clubs, with features for adding, deleting, and viewing club statistics. The app also includes a graphical user interface (GUI) for enhanced interaction.

## Project Structure
### 1. UML Diagrams
- Class Diagrams: Illustrates the relationships between classes, including SportsClub, FootballClub, UniversityFootballClub, SchoolFootballClub, PremierLeagueManager, and the LeagueManager interface.
- Use Case Diagrams: Highlights use cases for both Console and GUI interactions.

### 2. Functionalities
- **Console Menu (PremierLeagueManager):**
  - Create, delete, and display statistics for football clubs.
  - Display the Premier League Table.
  - Add played matches, update statistics, and save information to a file.
  - Resume previous state on application restart.

- **Graphical User Interface (GUI):**
  - Display a table of teams and their statistics in descending order of points.
  - Allow sorting based on goals scored and number of wins.
  - Generate random played matches with a button.
  - Display all played matches, sorted by date.
  - Search for matches played on a given date.

### 3. Implementation Details
- **Object-Oriented Principles:**
  - Inheritance: Utilizes SportsClub superclass and subclasses for various types of football clubs.
  - Encapsulation: Ensures appropriate encapsulation and information hiding.
  
- **File Handling:**
  - Save and resume the state using file-based storage.

- **Graphical User Interface:**
  - Angular framework used for GUI development.

### 4. Testing and Validation
- Design a comprehensive test plan for different scenarios.
- Implement automated testing using relevant tools or scripts.
- Ensure robustness through error handling and input validation.

## Usage
- Access the console menu for football club management.
- Explore the GUI for an interactive experience with team statistics and match information.

## Contributing
Feel free to contribute to the development of this project by submitting issues or pull requests.

## Report 
For a detailed discussion of the project, please refer to the [Report](Report.pdf) included in the repository. For detailed information about the coursework requirements, please refer to the [Coursework Specification](5COSC007C_Assignment.pdf) document. 

Enjoy using the Premier League Manager App! If you have any questions or encounter issues, feel free to reach out.
