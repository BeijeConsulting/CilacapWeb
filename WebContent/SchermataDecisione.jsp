<%@page import="it.beije.cilacap.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BEAN</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.cilacap.web.User" scope="session" />
<jsp:setProperty name="userBean" property="nome" param="nome"/>
<jsp:setProperty name="userBean" property="cognome" param="cognome"/>
<jsp:setProperty name="userBean" property="telefono" param="telefono"/>
<jsp:setProperty name="userBean" property="email" param="email"/>

<%= userBean.getNome() %> <%= userBean.getCognome() %> <%= userBean.getTelefono() %> <%= userBean.getEmail() %><br><br>
Nome :<jsp:getProperty name="userBean" property="nome"/><br>
Cognome : <jsp:getProperty name="userBean" property="cognome"/><br>
Telefono: <jsp:getProperty name="userBean" property="telefono"/><br>
Email: <jsp:getProperty name="userBean" property="email"/><br>
<br>

<form action="SchermataInserimentoCredenziali.jsp
" method="POST">
<input type="submit" value="Modifica">
</form>
<br>

<form action="rubrica" method="POST">
<input type="submit" value="Conferma Modifiche" >
</form>
</body>
</html>