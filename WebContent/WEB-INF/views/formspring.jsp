
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form utente</title>
</head>
<body>


<form action="vedicontatto" method="POST" >
  Nome: <input type="text" name="nome" value='${contatto.nome }'><br><br>
  Cognome: <input type="text" name="cognome" value='${contatto.cognome }'><br><br>
  Email: <input type="text" name="email" value='${contatto.email }'><br><br>
  Telefono: <input type="text" name="telefono" value='${contatto.telefono }'><br><br>
  <input type="submit" value="Salva">
</form>

</body>
</html>