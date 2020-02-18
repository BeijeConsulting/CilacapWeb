<%@page import="it.beije.cilacap.web.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Bean</title>
	</head>
	<body>
		<jsp:useBean id="contattoBean" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
		<jsp:setProperty name="contattoBean" property="nome" param="param_nome"/>
		<jsp:setProperty name="contattoBean" property="cognome" param="param_cognome"/>
		<jsp:setProperty name="contattoBean" property="telefono" param="param_telefono"/>
		<jsp:setProperty name="contattoBean" property="email" param="param_email"/>
		
		${nome}
		${cognome}
		${telefono}
		${email} 		
		
		<p>Hai inserito i seguenti dati:</p><br>
		Nome: <jsp:getProperty name="contattoBean" property="nome"/><br>
		Cognome: <jsp:getProperty name="contattoBean" property="cognome"/><br>
		Telefono: <jsp:getProperty name="contattoBean" property="telefono"/><br>
		Email: <jsp:getProperty name="contattoBean" property="email"/><br>
		
		<a href="MyRubrica.jsp">Modifica</a>
		<form action="MyRubrica" method="POST">
		<input type="submit" value="conferma">
		</form>

	</body>
</html>