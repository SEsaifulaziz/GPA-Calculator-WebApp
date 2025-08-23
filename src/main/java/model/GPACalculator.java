package model;

import java.util.List;

public class GPACalculator {
	public static double calculateOverallGPA(List<Course> courses) {
		double totalGradePoints = 0;
		int totalCredits = 0;
	
	    for (Course course : courses) {
		    totalGradePoints += course.getGradePoints();
		    totalCredits += course.getCredits();
    	}
	
	    return totalCredits > 0 ? totalGradePoints / totalCredits : 0;
   
	 }
	 
	 public static String getGradeDescription(double gpa) {
	   	 if(gpa >= 3.5) return "First Class (Excellent)";
		 else if(gpa >= 3.0) return "Second Class Upper (Very Good!)";
		 else if(gpa >= 2.0) return "Second Class Lower (Good)";
		 else if(gpa >= 1.0) return "Third Class (Pass)";
		 else return "Fail";
	 }
 }


