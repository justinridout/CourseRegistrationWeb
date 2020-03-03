<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Location</title>
</head>
<body>
<form action="createNewLocationServlet" method="post">
		Location Name:<input type="text" name="locationName"><br />Location City:
		<input type="text" name="locationCity">Location State:
		<input type="text" name="locationState"><br />Available
		Courses:<br />
		<select name="allCoursesToAdd" multiple size="6">
			<c:forEach
				items="${requestScope.allCourses}" var="currentcourse">
				<option value="${currentcourse.id}">${currentcourse.courseName}|
					${currentcourse.courseDescription} | ${currentcourse.startDate}</option>
			</c:forEach></select><br />
		<input type="submit" value="Create Location and Add Courses">
	</form>
	<a href="index.html">Go add new courses instead.</a>
</body>
</html>