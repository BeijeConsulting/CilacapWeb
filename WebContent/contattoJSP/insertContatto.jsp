<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento contatto</title>
</head>
<body>
<jsp:useBean id="contattoBean" class="it.beije.cilacap.esercizi.myRubrica.Contatto2" scope="session" />
<jsp:setProperty name="contattoBean" property="nome" />
<jsp:setProperty name="contattoBean" property="cognome" />
<jsp:setProperty name="contattoBean" property="telefono"/>
<jsp:setProperty name="contattoBean" property="email"/>

<p>Conferma i dati che hai inserito:</p>
Nome: <jsp:getProperty name="contattoBean" property="nome"/><br>
Cognome: <jsp:getProperty name="contattoBean" property="cognome"/><br>
Telefono: <jsp:getProperty name="contattoBean" property="telefono"/><br>
Email: <jsp:getProperty name="contattoBean" property="email"/>
<br><br>
<a href="formContatto.jsp">MODIFICA</a>
<a href="../SaveInDb">CONFERMA</a>

</body>
</html>