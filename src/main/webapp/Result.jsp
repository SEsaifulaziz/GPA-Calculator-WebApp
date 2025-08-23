<%@ page import="model.Course" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
     <title>GPA Results</title>
<link rel="stylesheet" href="style.css" /></head>
<body>
     <div class="container">
     <h1> GPA Results</h1> 
     
     <div class="rseults">
          <h2>Course Details</h2>
          <table>
               <tr>
                   <th>Course Name</th>
                   <th>Marks</th>
                   <th>Credits</th>
                   <th>GPA Points</th>
               </tr>
               <% for (Course course : (List<Course>)request.getAttribute("courses")) { %> 
               <tr> 
                   <td><%= course.getName() %></td>
                   <td><%= course.getMarks() %></td>
                   <td><%= course.getCredits() %></td>
                   <td><%= String.format("%.1f", course.getGPA()) %></td>
                </tr>
                <% } %>
            </table>

            <div class="Summary">
                <h2>Summary</h2>
                <p><strong>Total Courses:</strong> ${totalCourses}</p>
                <p><strong>Overall GPA:</strong> ${String.format("%.2f", overallGPA)}</p>
                <p><strong>Grade:</strong> ${gradeDescription}</p>
       
            </div>
            
            <a href="index.jsp" class="btn-back">Calculate Again</a>
       </div>
    </div>    
</body>
</html>