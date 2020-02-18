<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VEDI DATI INSERITI</title>
</head>
<body>

<jsp:useBean id="contattob" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
<jsp:setProperty name="contattob" property="nome"/>
<jsp:setProperty name="contattob" property="cognome"/>
<jsp:setProperty name="contattob" property="telefono"/>
<jsp:setProperty name="contattob" property="email"/>
<% System.out.println("vedi :\n" + contattob); %>

<h1>VERIFICA I DATI INSERITI</h1>
NOME : <jsp:getProperty name="contattob" property="nome"/><br>
COGNOME : <jsp:getProperty name="contattob" property="cognome"/><br>
TELEFONO : <jsp:getProperty name="contattob" property="telefono"/><br>
EMAIL : <jsp:getProperty name="contattob" property="email"/><br>
<br>
<a href="formcontatto.jsp">MODIFICA</a>&nbsp;<a href="conferma.jsp">CONFERMA</a>

</body>
</html>