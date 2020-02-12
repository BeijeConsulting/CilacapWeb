<%@page import="it.beije.cilacap.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>

<%
	Contatto con = (Contatto) session.getAttribute("contatto");
	String nome = con.getNome();
	String cognome = con.getCognome();
	String telefono = con.getTelefono();
	String email = con.getEmail();
%>

  Nome: <%= nome %>
  Cognome: <%= cognome %>
  Telefono: <%= telefono %>
  Email: <%= email %>

<form action="addContatto.jsp" method="POST">
  <input type="submit" value="MODIFICA">
</form>

<form action="salvaInDB" method="POST">
  <input type="submit" value="PROCEDI">
</form>

</body>
</html>