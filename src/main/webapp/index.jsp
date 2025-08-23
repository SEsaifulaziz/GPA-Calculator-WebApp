<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>GPA Calculator</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <div class="container">
        <h1>GPA Calculator</h1>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"> ${error}</div>
        <% } %>
        
        <form id="courseForm" method="post" action="GPACalculatorServlet">
            <div class="form-group">
                <label for="numCourses">Number of Courses:</label>
                <input type="number" id="numCourses" name="numCourses" min="1" max="20" required 
                       onchange="generateCourseFields()">
            </div>
            
            <div id="courseFields"></div>
            
            <button type="submit" class="btn-calculate">Calculate GPA</button>
        </form>
    </div>
    
    <script src="${pageContext.request.contextPath}/script.js"></script>
</body>
</html>