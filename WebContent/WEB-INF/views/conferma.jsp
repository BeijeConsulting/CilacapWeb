<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA INSERIMENTO DATI</title>
</head>
<body>

<h1>HO SALVATO I SEGUENTI DATI:</h1>
NOME : ${contatto.nome}<br>
COGNOME : ${contatto.cognome}<br>
TELEFONO : ${contatto.telefono}<br>
EMAIL :${contatto.email}<br>
<br>
<a href="/CilacapWeb/">INSERISCI NUOVI DATI</a>

</body>
</html>