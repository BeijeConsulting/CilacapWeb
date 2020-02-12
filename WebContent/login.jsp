<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<%! String nome = "es. Gabriele";%>
<%! String cognome = "es. Capobianco"; %>
<%! String telefono = "es. 327 5833 761"; %>
<%! String email = "es. gabriele@mail.it"; %>

<h1>LOGIN PAGE</h1>
<h6>Cilacap</h6>

<p>inserisci di seguito i tuoi dati</p>

<form action="addContatto" method="POST">

  Nome: <input type="text" name="nome" placeholder="<%= nome %>"><br><br>
  Cognome: <input type="text" name="cognome" placeholder="<%= cognome %>"><br><br>
  Telefono: <input type="text" name="telefono"placeholder="<%= telefono %>"><br><br>
  Email: <input type="text" name="email" placeholder="<%= email %>"><br><br>
  <input type="submit" value="CONFERMA">
  
</form>

</body>
</html>