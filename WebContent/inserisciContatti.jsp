<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gabriele's Rubrica</title>
</head>
<body>
<%! String nome = "es. pippo"; %>
<%! String cognome = "es. rossi"; %>
<%! String telefono = "es. 3456833596"; %>
<%! String email = "es pippo.rossi@gmail.com"; %>

<form action="addContact" method="POST">

  <h1 style=\"background-color:#c93c20;\">Inserisci Contatto</h1>
  <hr width=\"50%\">
  nome: <input type="text" name="nome" placeholder="<%= nome %>"><br><br>
  cognome: <input type="text" name="cognome" placeholder="<%= cognome%>"><br><br>
  telefono: <input type="text" name="telefono" placeholder="<%=telefono%>"><br><br>
  email: <input type="text" name="email" placeholder="<%=email%>"><br><br>
  <input type="submit" value="Inserisci">
</form>
</body>
</html>