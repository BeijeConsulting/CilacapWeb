<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione Contatto</title>
</head>
<body>
<%! String nome = "es. Mario";
	String cognome = "es. Rossi";
	String email = "es. MarioRossi@email.com";
%>
<h1>Registrazione Contatto</h1>

<p>Inserisci i le credenziali del contatto: </p>

<form action="rubrica" method="POST">
  Nome:		&emsp; <input type="text" name="nome" placeholder="<%= nome %>"><br>
  Cognome: 	&emsp; <input type="text" name="cognome" placeholder="<%= cognome %>"><br>
  Telefono: &emsp; <input type="text" name="telefono"><br>
  Email: 	&emsp; <input type="text" name="email" placeholder="<%= email %>"><br><br>
  <input type="submit" value="Salva">
</form>
</body>
</html>