<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA INSERIMENTO DATI</title>
</head>
<body>

<!--<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />-->

<h1>HO SALVATO IL SEGUENTE CONTATTO:</h1>
NOME : ${contatto.nome}<!--<jsp:getProperty name="contatto" property="nome"/>--><br>
COGNOME : ${contatto.cognome}<br>
TELEFONO : ${contatto.telefono}<br>
EMAIL : ${contatto.email}<br>
<br>
<% session.removeAttribute("contatto"); %>
<a href="index">INSERISCI NUOVI DATI</a>

</body>
</html>