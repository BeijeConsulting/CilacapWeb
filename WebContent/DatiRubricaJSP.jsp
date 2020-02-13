<%@page import="it.beije.cilacap.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungere contatto a rubrica</title>
<h1>Rubrica </h1>

<h5> Inserisci i tuoi dati personali:</h5>


<jsp:useBean id="Miocontatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />

 
 <form action="miaConferma.jsp" method="POST">
<p> Nome: <input type="text" name="nome" value='<% if(Miocontatto.getNome()!=null) out.print(Miocontatto.getNome()); %>'><br>
<p> Cognome: <input type="text" name="cognome" value='<% if(Miocontatto.getCognome()!=null) out.print(Miocontatto.getCognome()); %>'><br>
<p> Telefono: <input type="text" name="telefono" value='<% if(Miocontatto.getTelefono()!=null) out.print(Miocontatto.getTelefono()); %>'><br>
<p> Email: <input type="text" name="email" value='<% if(Miocontatto.getEmail()!=null) out.print(Miocontatto.getEmail()); %>'><br><br><br>


<input type="submit" value="SALVA I DATI">

</form>
</head>
<body>

</body>
</html>