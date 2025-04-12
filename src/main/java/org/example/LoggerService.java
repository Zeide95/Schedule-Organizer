package org.example;

import java.util.HashMap;
import java.util.ArrayList;

public class LoggerService {
    private static final HashMap<OperationType, Integer> operationCount = new HashMap<>();
    private static final ArrayList<String> logs = new ArrayList<>();

    public static void log(OperationType type, String message) {
        operationCount.put(type, operationCount.getOrDefault(type, 0) + 1);

        String timestamp = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        String logEntry = "[" + timestamp + "] " + message;
        logs.add(logEntry);
    }

    public static void printSummary() {
        System.out.println("\n Operation statistics:");
        for (var entry : operationCount.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\n Last actions:");
        logs.stream()
                .skip(Math.max(0, logs.size() - 5))
                .forEach(System.out::println);
    }

    public enum OperationType {
        ADD, DELETE, UPDATE, VIEW
    }
}
