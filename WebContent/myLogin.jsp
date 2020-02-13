<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form utente</title>
</head>
<body>

<%
	String nome = "";
	String cognome = "";
	String username = "";
	if(session.getAttribute("nome") != null) {
		nome = (String)session.getAttribute("nome");
	}
	if(session.getAttribute("cognome") != null) {
		cognome = (String)session.getAttribute("cognome");
	}
	if(session.getAttribute("username") != null) {
		username = (String)session.getAttribute("username");
	}
%>

<form action="myAuth.jsp" method="POST">
  Nome: <input type="text" name="param_nome" value="<%= nome %>"><br><br>
  Cognome: <input type="text" name="param_cognome" value="<%= cognome %>"><br><br>
  Username: <input type="text" name="username" value="<%= username %>"><br><br>
  <input type="submit" value="INVIA">
</form>

</body>
</html>