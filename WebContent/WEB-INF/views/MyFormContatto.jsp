<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Decisione" method="post">
		NOME: <input type="text" value="${session.nome}" name="nome"><br>
		COGNOME: <input type="text" value="${session.cognome}" name="cognome"><br>
		TELEFONO: <input type="text" value="${session.telefono}" name="telefono"><br>
		EMAIL: <input type="text" value="${session.email}" name="email"><br><br>
		
		Contatto: ${session} <br><br>
		
		<input type="submit" value="INVIA">
	</form>
</body>
</html>