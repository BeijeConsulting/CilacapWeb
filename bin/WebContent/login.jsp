<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<% String username = "es. Gabriele"; %>

<h1>LOGIN PAGE</h1>
<h6>Cilacap</h6>

<p>inserisci di seguito i tuoi dati</p>

<form action="test" method="POST">
  Username: <input type="text" name="username" placeholder="<%= username %>"><br><br>
  Password: <input type="password" name="password"><br><br>
  <input type="submit" value="INVIA">
</form>

</body>
</html>