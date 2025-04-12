package org.example;

public class Exam {
    private String subject, date, time, location;

    public Exam() { }

    public Exam(String subject, String date, String time, String location) {
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getSubject() { return subject; }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() { return time; }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return subject + " | " + date + " | " + time + " | " + location;
    }

    public String toCSV() {
        return subject + "," + date + "," + time + "," + location;
    }

}

