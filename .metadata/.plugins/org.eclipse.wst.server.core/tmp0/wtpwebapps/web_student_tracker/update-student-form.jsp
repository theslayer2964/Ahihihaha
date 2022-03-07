<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<style type="text/css">
.save {
	font-weight: bold;
	font-size: 18px;
	width: 130px;
	padding: 5px 5px;
	margin-top: 30px;
	background: rgb(73, 131, 207);
	color: yellow;
	border-radius: 3px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2 style="margin-top: 0px">FooBar University</h2>
		</div>
	</div>
	<div class="container">
		<h3>Update student</h3>
		<form action="StudentControllerServlet" method="get">
			<input type="hidden" name="command" value="UPDATE"> <input
				type="hidden" name="studentId" value="${THE_STUDENT.id}">
			<table>
				<tbody>
					<tr>
						<td><label for="firstName">First Name:</label></td>
						<td><input type="text" name="firstName"
							value="${THE_STUDENT.firstName}"></td>
					</tr>
					<tr>
						<td><label for="lastName">Last Name:</label></td>
						<td><input type="text" name="lastName"
							value="${THE_STUDENT.lastName}"></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email"
							value="${THE_STUDENT.email}"></td>
					</tr>
					<tr>
						<td><label for=""></label></td>
						<td><input type="submit" name="Save" class="save"></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="StudentControllerServlet"> Back to list</a>
		</p>
	</div>
</body>
</html>