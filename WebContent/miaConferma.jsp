<%@page import="it.beije.cilacap.rubrica.MioContatto"%>
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

<jsp:useBean id="MioContatto" class="it.beije.cilacap.rubrica.MioContatto" scope="session" />
<jsp:setProperty name="MioContatto" property="nome"  />
<jsp:setProperty name="MioContatto" property="cognome" />
<jsp:setProperty name="MioContatto" property="telefono" />
<jsp:setProperty name="MioContatto" property="email"/>

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

Nome: <jsp:getProperty name="MioContatto" property="name"/><br>
Cognome: <jsp:getProperty name="MioContatto" property="surnome"/><br>
Telefono: <jsp:getProperty name="MioContatto" property="telephone"/><br>
Email: <jsp:getProperty name="MioContatto" property="e-mail"/>
<br><br>

<input type="submit" onclick="location.href='DatiRubricaJSP.jsp'" value="MODIFICA">


<input type="submit" onclick="location.href='SalvataggioConfermato.jsp'" value="CONFERMA">

</body>
</html>