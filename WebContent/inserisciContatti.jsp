<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css">
<link rel="stylesheet" href="styleIndex.css">
<title>Gabriele's Rubrica insertContact</title>
</head>
<body>
<%! String nome = "es. pippo"; %>
<%! String cognome = "es. rossi"; %>
<%! String telefono = "es. 3456833596"; %>
<%! String email = "es pippo.rossi@gmail.com"; %>
<header class="header clearfix">
		<a href="" class="header__logo"></a> 
</header>

<form action="confermaContatto.jsp" method="POST" class="form__insert">

  <h1>Inserisci Contatto</h1>
  <hr class ="hr__styled">
  <dev class="form__aligned">
  nome: <input type="text" name="nome" placeholder="<%= nome %>"><br><br>
  cognome: <input type="text" name="cognome" placeholder="<%= cognome%>"><br><br>
  telefono: <input type="text" name="telefono" placeholder="<%=telefono%>"><br><br>
  email: <input type="text" name="email" placeholder="<%=email%>"><br><br>
  <input type="submit" value="Inserisci">
  </dev>
</form>
</body>
</html>