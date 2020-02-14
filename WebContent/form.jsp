<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form nuovo contatto</title>
</head>
<body>

<form action="auth.jsp" method="POST">
  Nome: <input type="text" name="param_nome"><br><br>
  Cognome: <input type="text" name="param_cognome"><br><br>
  Telefono: <input type="text" name="param_telefono"><br><br>
  Email: <input type="text" name="param_email"><br><br>
  <input type="submit" value="CONFERMA">
</form>

</body>
</html>