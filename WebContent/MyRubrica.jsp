<%-- Questo è il mio form.jsp, di conseguenza, qui farò partire il server e metterò il form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MyRubrica</title>
	</head>
	<body>
		<form action="authMyRubrica.jsp" method="POST">
			<p>Form MyRubrica</p>
			Nome:<input type="text" name="param_nome" placeholder="Inserisci nome"><br>
			Cognome:<input type="text" name="param_cognome"><br>
			Telefono:<input type="text" name="param_telefono"><br>
			Email:<input type="text" name="param_email"><br><br>
			<input type="submit" value="INVIA">
		</form>

	</body>
</html>