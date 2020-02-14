<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FORM CONTATTO</title>
	</head>
	<body>
	
		<h1>FORM CONTATTO</h1>
		
		<form action="Confirmation_Page.jsp" method="POST">
		  NOME: <input type="text" name="nome"><br><br>
		  COGNOME: <input type="text" name="cognome"><br><br>
		  TELEFONO: <input type="text" name="telefono"><br><br>
		  EMAIL: <input type="email" name="email"><br><br>
		  <input type="submit" value="CONTINUA">
		</form>
	
	</body>
</html>