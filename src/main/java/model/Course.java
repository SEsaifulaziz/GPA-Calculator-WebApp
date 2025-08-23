package model;

public class Course {
    private String name;
    private int credits;
    private int marks;
    private double gpa;
    
    public Course() {}
    
    public Course(String name, int credits, int marks) {
        this.name = name;
        this.credits = credits;
        this.marks = marks;
        this.gpa = calculateGPAFromMarks(marks);
    }
    
    private double calculateGPAFromMarks(int marks) {
        if (marks >= 80 && marks <= 100) return 4.0;
        else if (marks >= 70 && marks <= 79) return 3.0 + (marks - 70) * 0.1;
        else if (marks >= 60 && marks <= 69) return 2.0 + (marks - 60) * 0.1;
        else if (marks >= 50 && marks <= 59) return 1.0 + (marks - 50) * 0.1;
        else return 0.0;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getCredits() { return credits; }
    public void setCredits(int credits) { 
        this.credits = credits; 
    }
    
    public int getMarks() { return marks; }
    public void setMarks(int marks) { 
        this.marks = marks;
        this.gpa = calculateGPAFromMarks(marks);
    }
    
    public double getGPA() { return gpa; }
    public double getGradePoints() { return gpa * credits; }
}