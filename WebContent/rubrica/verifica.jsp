<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VEDI DATI INSERITI</title>
</head>
<body>

	<jsp:useBean id="contatto" class="it.beije.cilacap.web.Contatto"
		scope="session" />
	<jsp:setProperty name="contatto" property="nome" />
	<jsp:setProperty name="contatto" property="cognome" />
	<jsp:setProperty name="contatto" property="telefono" />
	<jsp:setProperty name="contatto" property="email" />
	<%
		System.out.println("vedi :\n" + contatto);
	%>

	<h1>VERIFICA I DATI INSERITI</h1>
	NOME :
	<jsp:getProperty name="contatto" property="nome" /><br> COGNOME :
	<jsp:getProperty name="contatto" property="cognome" /><br>
	TELEFONO :
	<jsp:getProperty name="contatto" property="telefono" /><br> EMAIL
	:
	<jsp:getProperty name="contatto" property="email" /><br>
	<br>
	<a href="../Salva">Conferma</a>



	<form action="formcontatto.jsp" type="POST">
		<input type="submit" value="Modifica">
	</form>


</body>
</html>