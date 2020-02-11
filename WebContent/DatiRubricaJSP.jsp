<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungere contatto a rubrica</title>
<h1>Rubrica </h1>
<h5> Inserisci i tuoi dati personali:</h5>

<%! String nome = "es. Riccardo"; %>
<%! String cognome = "es. Baioni"; %>
<%! String email = "es. riccardobaioni@hotmail.com"; %>

<form action="test" method="POST">

<p> Nome: <input type="text" name="nome" placeholder="<%= nome %>"><br>
<p> Cognome: <input type="text" name="cognome" placeholder="<%= cognome %>"><br>
<p> Telefono: <input type="text" name="telefono"><br>
<p> Email: <input type="text" name="email" placeholder="<%= email %>"><br><br><br>

<input type="submit" value="SALVA CONTATTO IN RUBRICA">

</head>
<body>

</body>
</html>