<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VEDI DATI INSERITI</title>
</head>
<body>

<h1>VERIFICA I DATI INSERITI</h1>
NOME : ${contatto.nome}<br>
COGNOME : ${contatto.cognome}<br>
TELEFONO : ${contatto.telefono}<br>
EMAIL :${contatto.email}<br>
<br>
<form action="/CilacapWeb/form" method="post">
<input type="submit" value="MODIFICA">
</form>
<form action="/CilacapWeb/salva" method="get">
<input type="submit" value="CONFERMA">
</form>

</body>
</html>