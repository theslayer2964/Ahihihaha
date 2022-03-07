<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
String[] cities = { "VN", "HCM" };
pageContext.setAttribute("myCity", cities);
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello World</h2>
	<c:forEach var="tempStudent" items="${s_l}">
		${tempStudent } <br>
	</c:forEach>
	<c:forEach var="temp" items="${myCity }">
		${temp } <br>
	</c:forEach>
</body>
</html>