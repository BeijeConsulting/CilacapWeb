<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>INSERIMENTO NUOVO CONTATTO</h1>
	<h3>Inserisci i dati del nuovo contatto</h3>
	<%!String nome = "nome";%>
	<%!String cognome = "cognome";%>
	<%!String telefono = "telefono";%>
	<%!String email = "email";%>


	<form action="InsertServlet" method="POST">
		Nome:<input type="text" name="nome" placeholder="<%=nome%>"><br>
		<br> Cognome: <input type="text" name="cognome"  placeholder="<%=cognome%>"><br>
		<br> Telefono: <input type="text" name="telefono"  placeholder="<%=telefono%>"><br>
		<br> Email: <input type="text" name="email"  placeholder="<%=email%>"><br>
		<br> <input type="submit" value="Salva">
	</form>
	
	<form action="DatabaseServlet" method="POST">
		
		<br> <input type="submit" value="Visualizza contatti presenti dal database">
	</form>

</body>
</html>