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
<jsp:useBean id="Contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />
<%
     String nome="",cognome="",telefono="", email="";
    
     if(Contatto.getNome()!=null){
    	nome=Contatto.getNome();
     }
    
     if(Contatto.getCognome()!=null){
    	nome=Contatto.getCognome();
     }
     
     if(Contatto.getTelefono()!=null){
     	nome=Contatto.getTelefono();
     }
     
     if(Contatto.getEmail()!=null){
     	nome=Contatto.getEmail();
     }


%>






 <!--  jsp:setProperty name="MioContatto" property="nome"/> <br>
 <jsp:setProperty name="MioContatto" property="cognome"/> <br>
 <jsp:setProperty name="MioContatto" property="telefono"/> <br>
 <jsp:setProperty name="MioContatto" property="email"/>-->
 
 <form action="miaConferma.jsp" method="POST">
<p> Nome: <input type="text" name="nome"value='<jsp:getProperty property="nome" name="Contatto" />'><br>
<p> Cognome: <input type="text" name="cognome"value='<jsp:getProperty property="cognome" name="Contatto" />'><br>
<p> Telefono: <input type="text" name="telefono"value='<jsp:getProperty  property="telefono"  name="Contatto" />'><br>
<p> Email: <input type="text" name="email"value='<jsp:getProperty  property="email"  name="Contatto" />'><br><br><br>
</form>


<input type="submit" value="SALVA I DATI">

</head>
<body>

</body>
</html>