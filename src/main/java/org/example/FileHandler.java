package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileHandler {

    public static ArrayList<Exam> readJSON(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Exam> exams = new ArrayList<>();
        try {
            Exam[] examsArray = objectMapper.readValue(new File("src/main/resources/" + filename), Exam[].class);
            Collections.addAll(exams, examsArray);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return exams;
    }

        public static void saveToCSV(String filename, ArrayList<Exam> exams) {
            try {
                FileWriter writer = new FileWriter("src/main/data/" + filename);
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
