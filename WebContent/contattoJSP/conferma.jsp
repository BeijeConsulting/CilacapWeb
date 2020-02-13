<%@page import="it.beije.cilacap.esercizi.myRubrica.Contatto2"%>
<%@page import="it.beije.cilacap.esercizi.myRubrica.HibernateRubricaUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma inserimento user</title>
<style>
.green {
	
}
</style>
</head>
<body>
	<h1 class="green">Utente inserito correttamente!</h1>
	<jsp:useBean id="contattoBean" class="it.beije.cilacap.esercizi.myRubrica.Contatto2" scope="session" />
	<%
	Contatto2 c = new Contatto2();
	c.setNome(contattoBean.getNome());
	c.setCognome(contattoBean.getCognome());
	c.setTelefono(contattoBean.getTelefono());
	c.setEmail(contattoBean.getEmail());
	
	HibernateRubricaUtil.writeSingleContactOnDB(c);
	
	if (contattoBean != null) {
		request.getSession().removeAttribute("contattoBean");
	}
	
	%>
	<a href="formContatto.jsp">Inserisci un nuovo contatto!</a>
</body>
</html>