<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM CONTATTO</title>
</head>
<body>
<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session"/>

<p>INSERISCI IL CONTATTO </p>

<form action="confirm.jsp" method="post">
Nome: <input type= "text" name="nome" value="<%= contatto.getNome()!=null ? contatto.getNome():""%>" placeholder="es. Stefano"><br>
Cognome: <input type= "text" name="cognome" value="<%= contatto.getCognome()!=null ? contatto.getCognome():""%>" placeholder="es. Brunato"><br>
Telefono: <input type= "text" name="telefono" value="<%= contatto.getTelefono()!=null ? contatto.getTelefono():""%>" placeholder="es. 3422554525"><br>
Email: <input type= "text" name="email" value="<%= contatto.getEmail()!=null ? contatto.getEmail():""%>" placeholder="es. stebru@gmail.com"><br>
<br>
<input type="submit" value="CONTINUA">
</form>
<p>CANCELLA CONTATTO</p>
<form action=""></form>
ID:<input type="text" name="id" placeholder="es.4"><br>


</body>
</html>