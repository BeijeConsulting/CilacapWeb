<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>


<%! String nome = "es. Gabriele";
	String cognome = "es. Capobianco";
	String telefono = "es. 00000000";
	String email = "es. Gabriele@beije.com";
%>

<h1>LOGIN PAGE</h1>
<h6>SESSION ID : <%= session.getId() %></h6>

<p>Inserisci di seguito i tuoi dati</p>


<form action="verifica.jsp" method="POST">
  Nome: <input type="text" name="nome" placeholder="<%= nome %>"><br><br>
  Cognome: <input type="cognome" name="cognome" placeholder="<%= cognome %>"><br><br>
  Telefono: <input type="telefono" name="telefono" placeholder="<%= telefono %>"><br><br>
  Email: <input type="email" name="email" placeholder="<%= email %>"><br><br>

  <input type="submit" value="INVIA">
</form>


</body>
</html>