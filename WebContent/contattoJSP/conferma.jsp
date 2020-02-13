<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.beije.cilacap.esercizi.myRubrica.JpaRubricaUtils"%>
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
	color: green;
}
</style>
</head>
<body>
	<h1 class="green">Utente inserito correttamente!</h1>
	<jsp:useBean id="contattoBean" class="it.beije.cilacap.esercizi.myRubrica.Contatto2" scope="session" />
	<p>E' stato inserito il seguante contatto!</p>
	Nome: <jsp:getProperty name="contattoBean" property="nome"/><br>
	Cognome: <jsp:getProperty name="contattoBean" property="cognome"/><br>
	Telefono: <jsp:getProperty name="contattoBean" property="telefono"/><br>
	Email: <jsp:getProperty name="contattoBean" property="email"/>
	<%
	Contatto2 c = new Contatto2();
	c.setNome(contattoBean.getNome());
	c.setCognome(contattoBean.getCognome());
	c.setTelefono(contattoBean.getTelefono());
	c.setEmail(contattoBean.getEmail());
	
	// Hibernate
	//HibernateRubricaUtil.writeSingleContactOnDB(c);
	
	// JPA
	List<Contatto2> lista = new ArrayList<Contatto2>();
	lista.add(c);
	
	JpaRubricaUtils.writeJPAListOfContactsIntoDB(lista);	
	
	if (contattoBean != null) {
		request.getSession().removeAttribute("contattoBean");
	}
	
	%>
	<br><br>
	<a href="formContatto.jsp">Inserisci un nuovo contatto!</a>
</body>
</html>