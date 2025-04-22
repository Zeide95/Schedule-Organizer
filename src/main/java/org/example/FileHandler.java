package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public static ArrayList<Exam> readData(String filename) {
        ArrayList<Exam> exams = new ArrayList<>();

        try {
            File file = new File("src/main/resources/" + filename);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String subject = data[0];
                String date = data[1];
                String time = data[2];
                String location = data[3];
                Exam exam = new Exam(subject, date, time, location);
                exams.add(exam);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
        return exams;
    }

        public static void saveToCSV(String filename, ArrayList<Exam> exams) {
            try {
                FileWriter writer = new FileWriter("src/main/resources/" + filename);
                writer.write("Subject,Date,Time,Location\n");
                for (Exam e : exams) {
                    writer.write(e.toCSV() + '\n');
                }
                writer.close();
                System.out.println("\nData written successfully.");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

}
