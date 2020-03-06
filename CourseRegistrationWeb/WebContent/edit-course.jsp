<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
</head>
<body>

<form action= "editCourseServlet" method="post">
	Course Name: <input type = "text" name = "courseName" value= "${courseToEdit.courseName}">
	Course Description: <input type = "text" name = "courseDescription" value ="${courseToEdit.courseDescription}">
	<label>Start date:</label>
		<input type="text" name="month" placeholder="mm" size="4"> <input
			type="text" name="day" placeholder="dd" size="4">, <input
			type="text" name="year" placeholder="yyyy" size="4">
	<input type = "hidden" name ="id" value= "${courseToEdit.id}">
	<input type ="submit" value="Save Edited Course">
</form>

</body>
</html>