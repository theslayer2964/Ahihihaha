<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<style type="text/css">
.container {
	padding: 10px 10px 10px 10px;
}
tbody tr:nth-child(even) {background: #FFFFFF}
tbody tr:nth-child(odd) {background: #BBBBBB}	
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2 style="margin-top: 0px">FooBar University</h2>
		</div>
	</div>
	<div class="container">
		<div class="content">
			<input type="button" value="Add Student"
				onclick="window.location.href='add-student-form.jsp';return false;"
				class="add-student-button" />

			<table class="table">
				<thead
					style="background-color: rgb(24, 111, 226); color: white; font-size: 18px;">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempStudent" items="${STUDENT_LIST}">
						<!-- tag: tạo ra 2 url: temp vf delete chứa tên biến và value, 
                	-> bên trong là 2 tham số đi kèm vs url  -->
						<c:url var="tempLink" value="StudentControllerServlet">
							<c:param name="command" value="LOAD"></c:param>
							<c:param name="studentId" value="${tempStudent.id}"></c:param>
						</c:url>
						<!-- set up link to delete -->
						<c:url var="deleteLink" value="StudentControllerServlet">
							<c:param name="command" value="DELETE"></c:param>
							<c:param name="studentId" value="${tempStudent.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempStudent.firstName}</td>
							<td>${tempStudent.lastName}</td>
							<td>${tempStudent.email}</td>
							<td style="text-align: center;">
								<!-- tạo ra 2 url tham chiếu đến 2 cái link tempLink, deleteLink, tạo sẵn ở trên, gọi đến
                			 Sau khi click dô cái này -> gọi đến serlet z``, có tham số z`` đc gửi đi -->
								<a href="${tempLink}">Update</a> | <a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this student'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</div>
	</div>
</body>
</html>