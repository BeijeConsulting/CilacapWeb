<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM CONTATTO</title>
</head>
<body>
<h1>FORM CONTATTO</h1>

<form action="verifica.jsp" method="POST">
<jsp:useBean id="contattob" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
 NOME: <input type="text" name="nome" value= "<%if(contattob.getNome()!=null) out.print(contattob.getNome()); %>"><br><br>
 COGNOME: <input type="text" name="cognome"value="<%if(contattob.getCognome()!=null) out.print(contattob.getCognome()); %>"><br><br>
 TELEFONO: <input type="text" name="telefono"value="<%if(contattob.getTelefono()!=null) out.print(contattob.getTelefono()); %>"><br><br>
 EMAIL: <input type="text" name="email"value="<%if(contattob.getEmail()!=null) out.print(contattob.getEmail());%>"><br><br>
  <input type="submit" value="CONTINUA">
</form>

</body>
</html>