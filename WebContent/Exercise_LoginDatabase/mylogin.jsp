<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login page</title>
	</head>
	<body>
	
		
		<%//Next line defines the use of the Bean contatto for the entire session %>
		<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
	
		<%  //Creation of strings that will be used as placeholders
			String nome = "es. Gabriele";
			String cognome = "es. Capobianco";
			String telefono = "es. 00000000";
			String email = "es. Gabriele@beije.com";
		%>
		
		<%  //Creation of empty strings that are going to be set as the values previously obtained from contatto 
			String newNome = "";
			String newCognome = "";
			String newTelefono = "";
			String newEmail = "";
		
			if (contatto.getNome() != null) {
				newNome = contatto.getNome();
			}
			if (contatto.getCognome() != null) {
				newCognome = contatto.getCognome();
			}
			if (contatto.getTelefono() != null) {
				newTelefono = contatto.getTelefono();
			}
			if (contatto.getEmail() != null) {
				newEmail = contatto.getEmail();
			}
		%>
		
		<h1>LOGIN PAGE</h1>
		
		<h6>SESSION ID : <%= session.getId() %></h6>
		
		<p>Inserisci di seguito i tuoi dati</p>
		
		
		<%// Form that will redirect this information to the verification page %>
		<form action="myverification.jsp" method="POST">
		
			 Nome: <input type="text" name="nome" value= "<%= newNome %>" placeholder="<%= nome %>"><br><br>
			 Cognome: <input type="text" name="cognome" value= "<%= newCognome %>" placeholder="<%= cognome %>"><br><br>
			 Telefono: <input type="text" name="telefono" value= "<%= newTelefono %>" placeholder="<%= telefono %>"><br><br>
			 Email: <input type="email" name="email" value= "<%= newEmail %>" placeholder="<%= email %>"><br><br>
			 
		  	<input type="submit" value="INVIA">
		</form>
	
	</body>
</html>