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

<form action="/CilacapWeb/verifica" method="POST">
  NOME: <input type="text" name="nome" value="${contatto.nome}" placeholder="Es. Niccolò" ><br><br>
  COGNOME: <input type="text" name="cognome" value="${contatto.cognome}" placeholder="Es. Farinella"><br><br>
  TELEFONO: <input type="text" name="telefono" placeholder="Es. +39 327 5833 760" value="${contatto.telefono}"><br><br>
  EMAIL: <input type="text" name="email" placeholder="Es. nicofari@gmail.com" value="${contatto.email}"><br><br>
  <input type="submit" value="CONTINUA">
</form>

</body>
</html>