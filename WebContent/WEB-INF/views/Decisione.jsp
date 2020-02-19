<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

      NOME: ${contatto.nome}<br>
      COGNOME: ${contatto.cognome}<br>
      TELEFONO: ${contatto.telefono}<br>
      EMAIL: ${contatto.email}<br>

<form action="MyFormContatto" method="POST">
<input type="submit" value="Modifica">
</form>
<br>

<form action="" method="POST">
<input type="submit" value="Conferma Modifiche" >
</form>
</body>
</html>