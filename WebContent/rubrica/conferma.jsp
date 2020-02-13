<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONFERMA INSERIMENTO DATI</title>
</head>
<body>

	<jsp:useBean id="contatto" class="it.beije.cilacap.web.Contatto"
		scope="session" />

	<h1>HO SALVATO I SEGUENTI DATI:</h1>
	NOME :
	<jsp:getProperty name="contatto" property="nome" /><br> COGNOME :
	<jsp:getProperty name="contatto" property="cognome" /><br>
	TELEFONO :
	<jsp:getProperty name="contatto" property="telefono" /><br> EMAIL
	:
	<jsp:getProperty name="contatto" property="email" /><br>
	<br>

	<%
		contatto = null;
		request.getSession().setAttribute("contatto", contatto);
		System.out.println(contatto);
	%>

	<a href="formcontatto.jsp">INSERISCI NUOVI DATI</a>

</body>
</html>