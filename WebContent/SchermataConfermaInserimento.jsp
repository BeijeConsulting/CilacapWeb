<%@page import="it.beije.cilacap.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma Inserimento</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.cilacap.web.User" scope="session" />

<h1>Hai salvato il seguente contatto</h1>

Nome :<jsp:getProperty name="userBean" property="nome"/><br>
Cognome : <jsp:getProperty name="userBean" property="cognome"/><br>
Telefono: <jsp:getProperty name="userBean" property="telefono"/><br>
Email: <jsp:getProperty name="userBean" property="email"/><br>
<br>

<% userBean = null;
request.getSession().setAttribute("userBean", userBean);
System.out.println(userBean); %>

<form action="SchermataInserimentoCredenziali.jsp" method="POST">
<input type="submit" value="Insrisci Nuovo Contatto">
</form>
<br>

</body>
</html>