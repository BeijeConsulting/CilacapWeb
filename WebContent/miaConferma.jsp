<%@page import="it.beije.cilacap.web.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Richiesta conferma</title>
</head>
<body>
<h1> Conferma O MODIFICA I DATI CHE HAI INSERITO</h1>

<jsp:useBean id="MioContatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
<jsp:setProperty name="Contatto" property="nome"  />
<jsp:setProperty name="Contatto" property="cognome" />
<jsp:setProperty name="Contatto" property="telefono" />
<jsp:setProperty name="Contatto" property="email"/>

<% System.out.println(MioContatto);
/*TRADUZIONE IN JAVA :
User userBean = (User) request.getSession().getAttribute("userBean");
if (userBean == null) {
	userBean = new User();
	request.getSession().setAttribute("user", userBean);
}

userBean.setFirstName(request.getParameter("param_nome"));
userBean.setLastName(request.getParameter("param_cognome"));
userBean.setLastName(request.getParameter("username"));
*/
%>

<%--= mioUtente.getNome() --%> <br>
<%--= mioUtente.getCognome() --%><br>
<%--= mioUtente.getTelefono() --%> <br>
<%--= mioUtente.getEmail() --%><br><br>

Nome: <jsp:getProperty name="Contatto" property="nome"><br>
Cognome: <jsp:getProperty name="Contatto" property="cognome"/><br>
Telefono: <jsp:getProperty name="Contatto" property="telefono"/><br>
Email: <jsp:getProperty name="Contatto" property="email"/>
<br><br>

<input type="submit" onclick="location.href='DatiRubricaJSP.jsp'" value="MODIFICA">
&nbps;
<input type="submit" onclick="location.href='SalvataggioConfermato.jsp'" value="CONFERMA">

</body>
</html>