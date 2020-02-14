<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Contatto</title>
         <link href="styleRubrica.css" type="text/css" rel="stylesheet" />

</head>


<body>
<div class="div-textcolor">
	<%!String nome = "es. Mario";%>
	<%!String cognome = "es. Rossi";%>
	<%!String telefono = "es. 3588469850";%>
	<%!String email = "es. mrossi@gmail.com";%>



	<jsp:useBean id="contatto" class="it.beije.cilacap.web.Contatto"
		scope="session" />
	<jsp:setProperty property="nome" name="contatto" />
	<jsp:setProperty property="cognome" name="contatto" />
	<jsp:setProperty property="telefono" name="contatto" />
	<jsp:setProperty property="email" name="contatto" />

	<form action="verifica.jsp" method="POST">

		<h1>Inserisci i nuovi dati</h1>

		Nome:<input type="text" name="nome" placeholder="<%=nome%>"
			value=<%=contatto.getNome() != null ? contatto.getNome() : ""%>><br>
		<br> Cognome: <input type="text" name="cognome"
			placeholder="<%=cognome%>"
			value=<%=contatto.getCognome() != null ? contatto.getCognome() : ""%>><br>
		<br> Telefono: <input type="text" name="telefono"
			placeholder="<%=telefono%>"
			value=<%=contatto.getTelefono() != null ? contatto.getTelefono() : ""%>><br>
		<br> Email: <input type="text" name="email"
			placeholder="<%=email%>"
			value=<%=contatto.getEmail() != null ? contatto.getEmail() : ""%>><br>
		<br> <input type="submit" value="Salva">
	</form>
</div>

</body>
</html>