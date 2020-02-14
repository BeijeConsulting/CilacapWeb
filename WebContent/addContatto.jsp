<%@page import="it.beije.cilacap.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi contatto</title>
</head>
<body>

<h1>Aggiungi un nuovo contatto</h1>
<h6>Cilacap</h6>

<p>inserisci di seguito i tuoi dati</p>

<%
	String nome = "";
	String cognome = ""; 
	String telefono = ""; 
	String email = "";
	Contatto con = (Contatto) session.getAttribute("contatto");
	if(con != null){
		nome = con.getNome();
		cognome = con.getCognome();
		telefono = con.getTelefono();
		email = con.getEmail();
	}
%>

<form action="addContatto" method="POST">
  Nome: <input type="text" name="nome" value=<%=nome%>><br><br>
  Cognome: <input type="text" name="cognome" value=<%=cognome%>><br><br>
  Telefono: <input type="text" name="telefono" value=<%=telefono%>><br><br>
  Email: <input type="text" name="email" value=<%=email%>><br><br>
  <input type="submit" value="SALVA">
</form>

</body>
</html>