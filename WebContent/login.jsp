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
<h6>SESSION ID : <%= session.getId() %></h6>

<p>inserisci di seguito i tuoi dati</p>

<form action="login" method="POST">
  Username: <input type="text" name="username"><br><br>
  Password: <input type="password" name="password"><br><br>
  <input type="submit" value="INVIA">
</form>

</body>
</html>