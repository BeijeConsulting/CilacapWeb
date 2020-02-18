<%-- Questo è il mio form.jsp, di conseguenza, qui farò partire il server e metterò il form --%>
<%@page import="it.beije.cilacap.web.rubrica.MyRubrica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rubrica</title>
	</head>
	<body>
		<form action="authMyRubrica.jsp" method="POST">
			<p>Form MyRubrica</p>
			Nome:<input type="text" name="param_nome" value="${nome}"><br>
			Cognome:<input type="text" name="param_cognome" value="${cognome}"><br>
			Telefono:<input type="text" name="param_telefono" value="${telefono}"><br>
			Email:<input type="text" name="param_email" value="${email}"><br><br>
			<input type="submit" value="INVIA">
		</form>

	</body>
</html>