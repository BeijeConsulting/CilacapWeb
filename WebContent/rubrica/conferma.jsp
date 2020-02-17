<%@page import="it.beije.cilacap.provaRubrica.Contatto"%>
<%@page import="it.beije.cilacap.provaRubrica.DBtools"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA INSERIMENTO DATI</title>
</head>
<body>

<jsp:useBean id="contattob" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
<h1>HO SALVATO I SEGUENTI DATI:</h1>
NOME : <jsp:getProperty name="contattob" property="nome"/><br>
COGNOME : <jsp:getProperty name="contattob" property="cognome"/><br>
TELEFONO : <jsp:getProperty name="contattob" property="telefono"/><br>
EMAIL : <jsp:getProperty name="contattob" property="email"/><br>
<br>
<%
Contatto contatto = new Contatto();
contatto.setNome(contattob.getNome());
contatto.setCognome(contattob.getCognome());
contatto.setTelefono(contattob.getTelefono());
contatto.setEmail(contattob.getEmail());

DBtools.insertContatto(contatto);

request.getSession().removeAttribute("contattob");

%>

<a href="formcontatto.jsp">INSERISCI NUOVI DATI</a>

</body>
</html>