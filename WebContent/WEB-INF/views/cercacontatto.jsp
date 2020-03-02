<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CERCA CONTATTO</title>
</head>
<body>
	<h1>CERCA CONTATTO</h1>
	<c:if test="${not empty errorMessage}">
		<h3 style="color:red">${errorMessage}</h3>
	</c:if>
	<form action="vedicontatto" method="post">
		ID: <input type="text" name="id"><br>
		<input type="submit" value="CERCA">
	</form>
</body>
</html>