package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.GPACalculator;


/**
 * Servlet implementation class GPACalculatorServlet
 */
@SuppressWarnings("serial")
@WebServlet("/GPACalculatorServlet")
public class GPACalculatorServlet extends HttpServlet {
       

    public GPACalculatorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// show input form
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        	int numCourses = Integer.parseInt(request.getParameter("numCourses"));
        	List<Course> courses = new ArrayList<>();
        
        	//Collect course data from 
        	for(int i = 1; i <= numCourses; i++ ) {
        		String name = request.getParameter("courseName" + i);
        		int credits = Integer.parseInt(request.getParameter("credits" + i));
        		int marks = Integer.parseInt(request.getParameter("marks" + i));
        	    
        		//validate input
        		if(marks < 0 || marks >100) {
        			request.setAttribute("error", "Marks must be berween 0-100" + i);
        			request.getRequestDispatcher("index.jsp").forward(request, response);
        			return;
        		}
        		
        		if(credits <= 0 ) {
        			request.setAttribute("error", "Credits must be positive for" + name );
        			request.getRequestDispatcher("index.jsp").forward(request, response);
        			return;
        		}
        		
        		courses.add(new Course(name, credits, marks));
        	}
        	
        	//Calculate results
        	double overallGPA = GPACalculator.calculateOverallGPA(courses);
        	String gradeDescription = GPACalculator.getGradeDescription(overallGPA);
        	
        	//set attributes for JSP
        	request.setAttribute("courses", courses);
        	request.setAttribute("overallGPA", overallGPA);
        	request.setAttribute("gradeDescription", gradeDescription);
        	request.setAttribute("totalCourses", courses.size());
        	
        	//Forward to result page
        	request.getRequestDispatcher("Result.jsp").forward(request, response);
        	
        }catch(NumberFormatException e) {
        	request.setAttribute("error", "Please enter valid numbers for credits and marks");
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
	
	}

}
