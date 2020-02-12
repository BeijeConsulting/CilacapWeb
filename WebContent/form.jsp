<%@page import="it.beije.cilacap.utils.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form utente</title>
</head>
<body>
<jsp:useBean id="userBean" class="it.beije.cilacap.utils.Contatto" scope="session" />
<jsp:setProperty name="userBean" property="nome" />
<jsp:setProperty name="userBean" property="cognome"/>
<jsp:setProperty name="userBean" property="email"/>
<jsp:setProperty name="userBean" property="telefono"/>

<form action="auth.jsp" method="POST">
  Nome: <input type="text" name="nome" value='<jsp:getProperty property="nome" name="userBean"/>'><br><br>
  Cognome: <input type="text" name="cognome" value='<jsp:getProperty property="cognome" name="userBean"/>'><br><br>
  Email: <input type="text" name="email" value='<jsp:getProperty property="email" name="userBean"/>'><br><br>
  Telefono: <input type="text" name="telefono" value='<jsp:getProperty property="telefono" name="userBean"/>'><br><br>
  <input type="submit" value="Salva">
</form>

</body>
</html>