<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM CONTATTO</title>
</head>
<body>

<p>INSERISCI IL CONTATTO </p>

<form action="/CilacapWeb/confirm" method="post">
Nome: <input type= "text" name="nome" value="${contatto.nome}"placeholder="es. Stefano"><br>
Cognome: <input type= "text" name="cognome" value="${contatto.cognome}" placeholder="es. Brunato"><br>
Telefono: <input type= "text" name="telefono" value="${contatto.telefono}"placeholder="es. 3422554525"><br>
Email: <input type= "text" name="email" value="${contatto.email}"placeholder="es. stebru@gmail.com"><br>
<br>
<input type="submit" value="CONTINUA">
</form>
<p>CANCELLA CONTATTO</p>
<form action="/CilacapWeb/delete" method ="post">
ID:<input type="text" name="id" placeholder="es.4"><br><br>
<input type="submit" value="CONTINUA">
</form>

</body>
</html>