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

<form action="verifica" method="POST">
  NOME: <input type="text" value="${contatto.nome}" name="nome"><br><br>
  COGNOME: <input type="text" value="${contatto.cognome}" name="cognome"><br><br>
  TELEFONO: <input type="text" value="${contatto.telefono}" name="telefono"><br><br>
  EMAIL: <input type="text" value="${contatto.email}" name="email"><br><br>
  <input type="submit" value="CONTINUA">
</form>

</body>
</html>