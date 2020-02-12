<%@page import="src.it.beije.cilacap.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>

<jsp:useBean id="user" class="src.it.beije.cilacap.web.User" scope="session" />

<%
//	User user = (User) session.getAttribute("user");
// 	String name = user != null ? user.getFirstName() : "SCONOSCIUTO";

	String name = user.getFirstName() != null ? user.getFirstName() : "SCONOSCIUTO";
%>

CIAO <%= name %>

</body>
</html>