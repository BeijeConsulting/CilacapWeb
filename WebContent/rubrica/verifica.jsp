<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VEDI DATI INSERITI</title>
</head>
<body>

<!--
<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
<jsp:setProperty name="contatto" property="nome"/>
<jsp:setProperty name="contatto" property="cognome"/>
<jsp:setProperty name="contatto" property="telefono"/>
<jsp:setProperty name="contatto" property="email"/>
-->
<% //System.out.println("vedi :\n" + contatto); %>

<h1>VERIFICA I DATI INSERITI</h1>
NOME : ${contatto.nome}<!--jsp:getProperty name="contatto" property="nome"/--><br>
COGNOME : ${contatto.cognome}<br>
TELEFONO : ${contatto.telefono}<br>
EMAIL : ${contatto.email}<br>
<br>
<a href="index">MODIFICA</a>&nbsp;<a href="conferma">CONFERMA</a>

</body>
</html>