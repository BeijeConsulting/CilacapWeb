<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA INSERIMENTO DATI</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.cilacap.utils.Contatto" scope="session" />

<h1>HO SALVATO I SEGUENTI DATI:</h1>
NOME : <jsp:getProperty name="userBean" property="nome"/><br>
COGNOME : <jsp:getProperty name="userBean" property="cognome"/><br>
TELEFONO : <jsp:getProperty name="userBean" property="telefono"/><br>
EMAIL : <jsp:getProperty name="userBean" property="email"/><br>
<br>

<%
  session.removeAttribute("userBean");
%>
<a href="form.jsp">INSERISCI NUOVI DATI</a>

</body>
</html>