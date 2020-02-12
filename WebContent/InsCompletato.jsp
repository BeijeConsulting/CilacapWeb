<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="it.beije.cilacap.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operazione eseguita</title>
</head>
<body>
<%
   String nome=request.getParameter("nome");
   String cognome=request.getParameter("cognome");
   String telefono=request.getParameter("telefono");
   String email=request.getParameter("email");
   
   Contatto c = new Contatto();
   c.setNome(nome);
   c.setCognome(cognome);
   c.setTelefono(telefono);
   c.setEmail(email);
   List<Contatto> lista=new ArrayList<Contatto>();
   lista.add(c);
   
   
   
   
   %>

</body>
</html>