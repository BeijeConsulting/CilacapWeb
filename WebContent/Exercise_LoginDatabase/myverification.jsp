<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>VEDI DATI INSERITI</title>
	</head>
	<body>

		<%//Next line defines the use of the Bean contatto for the entire session %>
		<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
		
		<%//Next line sets the different properties obtained before to contatto %>
		<jsp:setProperty name="contatto" property="nome"/>
		<jsp:setProperty name="contatto" property="cognome"/>
		<jsp:setProperty name="contatto" property="telefono"/>
		<jsp:setProperty name="contatto" property="email"/>
		<% System.out.println("vedi :\n" + contatto); %>
		
		<h1>VERIFICA I DATI INSERITI</h1>
		
		NOME : <jsp:getProperty name="contatto" property="nome"/><br>
		COGNOME : <jsp:getProperty name="contatto" property="cognome"/><br>
		TELEFONO : <jsp:getProperty name="contatto" property="telefono"/><br>
		EMAIL : <jsp:getProperty name="contatto" property="email"/><br>
		<br>
		
		<%// Form that will redirect this information to the initial page %>
		<form action="mylogin.jsp" method="POST">
			<input type="submit" value="MODIFICA">
		</form>
		<br>
		
		<%// Form that will redirect this information to the servlet %>
		<form action="servlet_rubrica" method="POST">
			<input type="submit" value="CONFERMA">
		</form>
	</body>
</html>