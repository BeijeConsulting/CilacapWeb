<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERIMENTO NUOVO CONTATTO</title>
</head>
<body>

<p>INSERISCI IL CONTATTO </p>

<form action="addContatto" method="post">
Nome: <input type= "text" name="nome" placeholder="es. Niccolò">
Cognome: <input type= "text" name="cognome" placeholder="es. Farinella">
Telefono: <input type= "text" name="telefono" placeholder="es. 3422554525">
Email: <input type= "text" name="email" placeholder="es. nichi@gggg.com">
<input type="submit" value="CONFERMA">

</form>

</body>
</html>