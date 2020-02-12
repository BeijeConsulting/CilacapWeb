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
<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />
<jsp:getProperty name="contatto" property="nome"/>
<jsp:getProperty name="contatto" property="cognome"/>
<jsp:getProperty name="contatto" property="telefono"/>
<jsp:getProperty name="contatto" property="email"/>

<form action="confermaContatto.jsp" method="POST" class="form__insert">

  <h1>Inserisci Contatto</h1>
  <hr class ="hr__styled">
  <dev class="form__aligned">
  nome: <input type="text" name="nome" placeholder="<%= contatto.getNome()!=null ? contatto.getNome() : nome %>"><br><br>
  cognome: <input type="text" name="cognome" placeholder="<%= contatto.getCognome()!=null ? contatto.getCognome() : cognome%>"><br><br>
  telefono: <input type="text" name="telefono" placeholder="<%=contatto.getTelefono()!=null ? contatto.getTelefono() : telefono%>"><br><br>
  email: <input type="text" name="email" placeholder="<%=contatto.getEmail()!=null ? contatto.getEmail() : email%>"><br><br>
  <input type="submit" value="Inserisci">
  </dev>
</form>
</body>
</html>