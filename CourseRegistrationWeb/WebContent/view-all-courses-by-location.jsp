<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses by Location</title>
</head>
<body>
<form method="post" action="courseNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLocations}" var="currentcourse">
				<tr>
					<td><input type="radio" name="id" value="${currentcourse.id}"></td>
					<td><h2>${currentcourse.locationName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Location City: ${currentcourse.city}</td>
				</tr>
				<tr>
					<td colspan="3">Location State: ${currentcourse.state}</td>
				</tr>
				<c:forEach var="listVal" items="${currentcourse.listOfCourses}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.courseName},${listVal.courseDescription},${listVal.startDate }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToLocation"><input
			type="submit" value="delete" name="doThisToLocation">
	</form>
 	<a href="index.html">Create a new course</a>
		<a href="addCoursesToLocationServlet">Add a new Location</a>
</body>
</html>