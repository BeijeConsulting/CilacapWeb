<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>


<h1>LOGIN PAGE</h1>
<h6>Cilacap</h6>

<p>inserisci di seguito i tuoi dati</p>

<form action="addContatto" method="POST">
  Nome: <input type="text" name="nome"><br><br>
  Cognome: <input type="text" name="cognome"><br><br>
  Telefono: <input type="text" name="telefono"><br><br>
  Email: <input type="text" name="email"><br><br>
  <input type="submit" value="SALVA">
</form>

</body>
</html>