<%@page import="it.beije.cilacap.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione Contatto</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.cilacap.web.User" scope="session" />

<%  String holderNome = "es. Mario";
	String holderCognome = "es. Rossi";
	String holderTelefono = "es. 332 9318390";
	String holderEmail = "es. MarioRossi@email.com";
	
	String nome = "";
	String cognome = "";
	String telefono = "";
	String email = "";
	  
	   if(userBean.getNome() != null)
	   	nome = userBean.getNome();
	   if(userBean.getCognome() != null)
	   	cognome = userBean.getCognome();
	   if(userBean.getTelefono() != null)
		telefono = userBean.getTelefono();
	   if(userBean.getEmail() != null)
		email = userBean.getEmail();	   
%>

<h1>Registrazione Contatto</h1>

<p>Inserisci le credenziali del contatto: </p>


<form action="SchermataDecisione.jsp" method="POST">

  Nome:		&emsp; <input type="text" name="nome"  value="<%= nome %>" placeholder="<%= holderNome %>"><br>
  Cognome: 	&emsp; <input type="text" name="cognome"  value="<%= cognome %>" placeholder="<%= holderCognome %>"><br>
  Telefono: &emsp; <input type="text" name="telefono"  value="<%= telefono %>" placeholder="<%= holderTelefono %>"><br>
  Email: 	&emsp; <input type="text" name="email" value="<%= email %>" placeholder="<%= holderEmail %>"><br><br>
  <input type="submit" value="Salva">
  
</form>
</body>
</html>