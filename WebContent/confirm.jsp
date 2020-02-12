<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFIRMATION PAGE</title>
</head>
<body>

<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session"/>

<jsp:setProperty property="nome" name="contatto" param="nome"/>
<jsp:setProperty property="cognome" name="contatto" param="cognome"/>
<jsp:setProperty property="telefono" name="contatto" param="telefono"/>
<jsp:setProperty property="email" name="contatto" param="email" />



<p>CONFEMRI IL CONTATTO? </p>

NOME: <jsp:getProperty property="nome" name="contatto"/><br>
COGNOME: <jsp:getProperty property="cognome" name="contatto"/><br>
TELEFONO: <jsp:getProperty property="telefono" name="contatto"/><br>
EMAIL: <jsp:getProperty property="email" name="contatto"/><br>

<a href="index_delloste.jsp">MODIFICA</a><BR><a href="addContatto">CONFERMA</a>
</body>
</html>