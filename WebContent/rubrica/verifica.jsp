<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VEDI DATI INSERITI</title>
         <link href="styleRubrica.css" type="text/css" rel="stylesheet" />

</head>
<body>


	<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.model.Contatto"
		scope="session" />
	<jsp:setProperty name="contatto" property="nome" />
	<jsp:setProperty name="contatto" property="cognome" />
	<jsp:setProperty name="contatto" property="telefono" />
	<jsp:setProperty name="contatto" property="email" />
	<%
		System.out.println("vedi :\n" + contatto);
	%>

	<h1>VERIFICA I DATI INSERITI</h1>
	<div class="dive-textcolor">
	NOME :
	<jsp:getProperty name="contatto" property="nome" /><br> COGNOME :
	<jsp:getProperty name="contatto" property="cognome" /><br>
	TELEFONO :
	<jsp:getProperty name="contatto" property="telefono" /><br> EMAIL
	:
	<jsp:getProperty name="contatto" property="email" /><br>
	<br>
	<a href="../Salva" color: "white">Conferma</a>



	<form action="formcontatto.jsp" type="POST">
		<input type="submit" value="Modifica">
	</form>
</div>

</body>
</html>