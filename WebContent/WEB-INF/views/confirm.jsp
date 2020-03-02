<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFIRMATION PAGE</title>
</head>
<body>

<p>CONFEMRI IL CONTATTO? </p>

NOME: ${contatto.nome}<br>
COGNOME: ${contatto.cognome}<br>
TELEFONO: ${contatto.telefono}<br>
EMAIL: ${contatto.email}<br>

<a href="/CilacapWeb/index">MODIFICA</a><BR><a href="/CilacapWeb/salva">CONFERMA</a>
</body>
</html>