<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, demo2.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MvcDemo Servelet2</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Fist Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="tempStudent" items="${Student_list}">
			<tr>
				<td>${tempStudent.ho}</td>
				<td>${tempStudent.ten}</td>
				<td>${tempStudent.email}</td>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>