package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExamService service = new ExamService();

        // load from json and add to list
        service.getAllExams().addAll(FileHandler.readJSON("exam.json"));

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Add an exam");
            System.out.println("2. Show all exams");
            System.out.println("3. Update the exam");
            System.out.println("4. Delete the exam");
            System.out.println("5. Save and exit");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    String subject = promptNonEmpty("Subject: ");
                    String date = promptMatching("Date (DD-MM-YYYY): ", "\\d{2}-\\d{2}-\\d{4}");
                    String time = promptMatching("Time (HH:MM): ", "\\d{2}:\\d{2}");
                    String location = promptNonEmpty("Location: ");
                    service.addExam(new Exam(subject, date, time, location));
                    LoggerService.log(LoggerService.OperationType.ADD, "Added exam: " + subject);
                    System.out.println("Exam added.");
                    break;
                case "2":
                    for (Exam e : service.getAllExams()) {
                        System.out.println(e);
                    }
                    LoggerService.log(LoggerService.OperationType.VIEW, "Viewed exam list");
                    break;
                case "3":
                    System.out.print("Enter the subject to update: ");
                    String subjToUpdate = scanner.nextLine();
                    Exam found = service.findBySubject(subjToUpdate);
                    if (found != null) {
                        String newSubject = promptNonEmpty("New subject: ");
                        String newDate = promptMatching("New date (DD-MM-YYYY): ", "\\d{2}-\\d{2}-\\d{4}");
                        String newTime = promptMatching("New time (HH:MM): ", "\\d{2}:\\d{2}");
                        String newLocation = promptNonEmpty("New location: ");
                        service.updateExam(subjToUpdate, new Exam(newSubject, newDate, newTime, newLocation));
                        LoggerService.log(LoggerService.OperationType.UPDATE, "Updated exam: " + subjToUpdate);
                    } else {
                        System.out.println("Exam not found.");
                    }
                    break;
                case "4":
                    System.out.print("Enter the subject to delete: ");
                    String subjToDelete = scanner.nextLine();
                    if (service.deleteExam(subjToDelete)) {
                        System.out.println("Deleted.");
                        LoggerService.log(LoggerService.OperationType.DELETE, "Deleted exam: " + subjToDelete);
                    } else {
                        System.out.println("Exam not found.");
                    }
                    break;
                case "5":
                    LoggerService.printSummary();
                    FileHandler.saveToCSV("exams.csv", service.getAllExams());
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Incorrect input.");
            }
        }
    }

    private static String promptNonEmpty(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) System.out.println("Incorrect input.");
        } while (input.isEmpty());
        return input;
    }

    private static String promptMatching(String prompt, String regex) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.matches(regex)) {
                System.out.println("Incorrect input.");
                input = "";
            }
        } while (input.isEmpty());
        return input;
    }

}
