<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA INSERIMENTO DATI</title>
</head>
<body>

<jsp:useBean id="Miocontatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />

<h1>HO SALVATO I SEGUENTI DATI:</h1>
NOME : <jsp:getProperty name="Miocontatto" property="nome"/><br>
COGNOME : <jsp:getProperty name="Miocontatto" property="cognome"/><br>
TELEFONO : <jsp:getProperty name="Miocontatto" property="telefono"/><br>
EMAIL : <jsp:getProperty name="Miocontatto" property="email"/><br>
<br>
<input type="submit" onclick="location.href='DatiRubricaJSP.jsp'" value="INSERISCI NUOVI DATI">
<%session.removeAttribute("Miocontatto"); %>
</body>
</html>