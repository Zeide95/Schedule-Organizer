# Schedule Organizer

## Description
Schedule Organizer is a Java-based command-line application designed to help students manage their exam schedules. The application allows users to create, view, update, and delete exam records. It supports persistent storage via CSV file, and also logs user activities and operations for reporting purposes.

---

## Objectives
- Implement CRUD (Create, Read, Update, Delete) operations.
- Provide an intuitive Command Line Interface (CLI).
- Ensure data persistence through file storage.
- Allow importing/exporting data in CSV format.
- Enable user activity tracking and reporting.

---

## Features
- **Add Exam**: Add a new exam with subject, date, time, and location.
- **Update Exam**: Modify details of an existing exam.
- **Delete Exam**: Remove an exam from the schedule.
- **View Exams**: List all exams.
- **Export/Import**: Save and load data from CSV.
- **Operation Logging**: Track all operations and print usage reports.

---

## Data Structures & Algorithms
- `Exam Class`: A simple data model class to represent exam records with four fields: subject, date, time, location.
- `ArrayList<Exam>`: Stores all exam records in memory.
- `HashMap<OperationType, Integer>`: Tracks the frequency of operations.
- `ArrayList<String>`: Stores user activity logs.

---

## Modular Design
- `Main.java`: Handles the user interface and input.
- `Exam.java`: Data model.
- `ExamService.java`: Business logic for managing exams.
- `FileHandler.java`: Manages CSV file operations.
- `LoggerService.java`: Logs actions and summarizes reports.

---

## Challenges Faced
- Managing correct deserialization of CSV into custom objects.
- Handling incorrect or empty user input gracefully.
- Ensuring consistent saving of user operations and activities for later reporting.

---

## How to Run
1. Compile all `.java` files in the `org.example` package.
2. Run `Main.java`.
3. Follow the prompts to perform exam schedule operations.

---

## Note
Make sure the `src/main/resources/` directory exist for saving and loading data.

---

## Screenshots
![1](https://github.com/user-attachments/assets/79505e2d-a351-4daf-b3ab-1141ee8974e1)
![2](https://github.com/user-attachments/assets/4f04fc87-19d4-41a0-8615-85003eba6a1d)
![3](https://github.com/user-attachments/assets/0120fe4a-9e68-40e0-a918-f1664fcc6232)
![4](https://github.com/user-attachments/assets/6df66fe3-f528-4fc3-87f5-42e8d76bc3ee)

---

## Presentation
[link](https://docs.google.com/presentation/d/1srh5xfF3ZVKh25p9XK7dvoXAiVEg5-AUYrcCtJ6V0CE/edit?usp=sharing)