<%@page import="it.beije.cilacap.esercizi.myRubrica.JpaRubricaUtils"%>
<%@page import="java.util.*"%>
<%@page import="it.beije.cilacap.esercizi.myRubrica.Contatto2"%>
<%@page import="it.beije.cilacap.myWeb.util.ContattoWeb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esito inserimento</title>
</head>
<body>
	<%
		String nome = request.getParameter("name");
		String cognome = request.getParameter("surname");
		String telefono = request.getParameter("tel");
		String email = request.getParameter("mail");
		
		Contatto2 contatto = new Contatto2();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		
		List<Contatto2> lista = new ArrayList<Contatto2>();
		lista.add(contatto);
		
		JpaRubricaUtils.writeJPAListOfContactsIntoDB(lista);
		
	%>
	<div style="border: 4px solid green; padding: 15px; color: green; font-size: large;">Inserimento avvenuto con successo!!!</div>
	<br><br>
	<a href="AddNewContatto.jsp">Torna alla pagina inserimento contatti >>></a>
</body>
</html>