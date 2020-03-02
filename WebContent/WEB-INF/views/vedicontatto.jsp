
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vedi contatti</title>
</head>
<body>
<form action="formspring" method="GET">
  Nome: ${contatto.nome }<br><br>
  Cognome: ${contatto.cognome }<br><br>
  Email: ${contatto.email }<br><br>
  Telefono: ${contatto.telefono }<br><br>
 <input type="submit" value="modifica">
</form>
</body>

</html>