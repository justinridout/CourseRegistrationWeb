<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Location</title>
</head>
<body>
<form action= "editLocationServlet" method="post">

<label style="margin-right: 40px;">Location Name:</label><input type = "text" name = "locationName" value= "${toEdit.locationName}"></br>
	<label style="margin-right: 40px;">Location city:</label><input type = "text" name = "locationCity" value= "${toEdit.city}"></br>
	<label style="margin-right: 40px;">Location state:</label><input type = "text" name = "locationState" value= "${toEdit.state}"></br>
	Available Courses:<br />
		<select name="allCoursesToAdd" multiple size="6">
			<c:forEach
				items="${requestScope.allCourses}" var="currentcourse">
				<option value="${currentcourse.id}">${currentcourse.courseName}|
					${currentcourse.courseDescription} | ${currentcourse.startDate}</option>
			</c:forEach></select><br />
	
	<a href="index.html">Go add new courses instead.</a>
	<input type = "hidden" name ="id" value= "${toEdit.id}">
	
	<input type ="submit" value="Save Edited Location">
</form>


</body>
</html>