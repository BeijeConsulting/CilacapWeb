<%@page import="it.beije.cilacap.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" href="2097_pop/css/tooplate-style.css" rel="alternate"></link>
<link type="text/css" href="2097_pop/css/bootstrap.min.css.css" rel="alternate"></link>
<style type="text/css"></style>
<title>Login page</title>
</head>
<body>

<%! String name = "es. Gabriele";%>
<%! String cognome = "es. Capobianco"; %>
<%! String telefono = "es. 327 5833 761"; %>
<%! String email = "es. gabriele@mail.it"; %>

<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />

<h1>LOGIN PAGE</h1>
<h4>ID SESSIONE: <%= session.getId() %></h4>

<p>Inserire nuovo contatto </p>

<%

if (contatto.getNome()!=null){
	out.print("Modifica i vecchi dati:<br>");
}
%>

<form action="auth.jsp" method="POST">

  Nome: <input type="text" name="nome" value="<%=contatto.getNome()!=null ? contatto.getNome() :""  %>" placeholder="<%=name %>"><br><br>
  Cognome: <input type="text" name="cognome" value="<%=contatto.getCognome()!=null ? contatto.getCognome() :"" %>" placeholder="<%=cognome %>"><br><br>
  Telefono: <input type="text" name="telefono" value="<%=contatto.getTelefono()!=null ? contatto.getTelefono() :"" %>" placeholder="<%=telefono %>"><br><br>
  Email: <input type="text" name="email" value="<%=contatto.getEmail()!=null ? contatto.getEmail() :"" %>" placeholder="<%= email %>"><br><br>
  <input type="submit" value="CONFERMA">
  
</form>

</body>
</html>