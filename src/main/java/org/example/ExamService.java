package org.example;

import java.util.ArrayList;

public class ExamService {
    private ArrayList<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public ArrayList<Exam> getAllExams() {
        return exams;
    }

    public Exam findBySubject(String subject) {
        for (Exam e : exams) {
            if (e.getSubject().equalsIgnoreCase(subject)) return e;
        }
        return null;
    }

    public void updateExam(String subject, Exam updated) {
        Exam old = findBySubject(subject);
        if (old != null) {
            exams.remove(old);
            exams.add(updated);
        }
    }

    public boolean deleteExam(String subject) {
        Exam e = findBySubject(subject);
        return e != null && exams.remove(e);
    }

}