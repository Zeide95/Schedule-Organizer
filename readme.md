# Schedule Organizer

**Student**: Mamyraimova Zeide  
**Group**: EEAIR-24

---

## Description
Schedule Organizer is a Java-based command-line application designed to help students manage their exam schedules. The application allows users to create, view, update, and delete exam records. It supports persistent storage via CSV and JSON files, and also logs user activities and operations for reporting purposes.

---

## Objectives
- Implement CRUD (Create, Read, Update, Delete) operations.
- Provide an intuitive Command Line Interface (CLI).
- Ensure data persistence through file storage.
- Allow importing/exporting data in CSV and JSON formats.
- Enable user activity tracking and reporting.

---

## Features
- **Add Exam**: Add a new exam with subject, date, time, and location.
- **Update Exam**: Modify details of an existing exam.
- **Delete Exam**: Remove an exam from the schedule.
- **View Exams**: List all exams.
- **Export/Import**: Save to CSV and load data from JSON.
- **Operation Logging**: Track all operations and print usage reports.

---

## Data Structures & Algorithms
- **Exam Class**: A simple data model class to represent exam records with four fields: subject, date, time, location.
- **List<Exam>**: Stores all exam records in memory.
- **HashMap<OperationType, Integer>**: Tracks the frequency of operations.
- **ArrayList<String>**: Stores user activity logs.
- **ObjectMapper (Jackson)**: Used for reading/writing JSON.

---

## Modular Design
- `Main.java`: Handles the user interface and input.
- `Exam.java`: Data model.
- `ExamService.java`: Business logic for managing exams.
- `FileHandler.java`: Manages CSV/JSON file operations.
- `LoggerService.java`: Logs actions and summarizes reports.

---

## Challenges Faced
- Managing correct deserialization of JSON into custom objects.
- Handling incorrect or empty user input gracefully.
- Ensuring consistent saving of user operations and activities for later reporting.

---

## How to Run
1. Compile all `.java` files in the `org.example` package.
2. Run `Main.java`.
3. Follow the prompts to perform exam schedule operations.

---

## Note
Make sure the `src/main/resources/` and `src/main/data/` directories exist for saving data and logs.
