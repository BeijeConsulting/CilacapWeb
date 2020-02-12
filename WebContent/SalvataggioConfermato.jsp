<%@page import="it.beije.cilacap.rubrica.MioContatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma avvenuta</title>
</head>
<body>
<h1>Dati salvati correttamente! </h1>
<jsp:useBean id="mioUtente" class="it.beije.cilacap.rubrica.MioContatto" scope="session" />
<jsp:setProperty name="mioUtente" property="nome" />
<jsp:setProperty name="mioUtente" property="cognome" />
<jsp:setProperty name="mioUtente" property="telefono"/>
<jsp:setProperty name="mioUtente" property="email"/>


<h3><jsp:getProperty name="mioUtente" property="nome"/><br>
<jsp:getProperty name="mioUtente" property="cognome"/><br>
<jsp:getProperty name="mioUtente" property="telefono"/><br>
<jsp:getProperty name="mioUtente" property="email"/><br></h3>

<br>
<br>
<%session.getId(); %>

<input type="submit" onclick="location.href='DatiRubricaJSP.jsp'" value="PREMI PER CREARE UN NUOVO CONTATTO">

</body>
</html>