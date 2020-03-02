  
<%@page import="it.beije.cilacap.web.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungere contatto a rubrica</title>
<h1>Rubrica </h1>

<h5> Inserisci i tuoi dati personali:</h5>


<!-- jsp:useBean id="Miocontatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" /-->

 
 <form action="see" method="POST">
<p> Nome: <input type="text" name="nome" value='${contatto.nome}'<%-- if(Miocontatto.getNome()!=null) out.print(Miocontatto.getNome()); --%>><br>
<p> Cognome: <input type="text" name="cognome" value='${contatto.cognome}'<%-- if(Miocontatto.getCognome()!=null) out.print(Miocontatto.getCognome()); --%>'><br>
<p> Telefono: <input type="text" name="telefono" value='${contatto.telefono}'<%-- if(Miocontatto.getTelefono()!=null) out.print(Miocontatto.getTelefono()); --%>'><br>
<p> Email: <input type="text" name="email" value='${contatto.email}'<%-- if(Miocontatto.getEmail()!=null) out.print(Miocontatto.getEmail()); --%>'><br><br><br>



<input type="submit" value="SALVA I DATI">

</form>
</head>
<body>

</body>
</html>