<%@page import="it.beije.cilacap.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BEAN</title>
</head>
<body>

<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />
<jsp:setProperty name="contatto" property="nome" param="nome"/>
<jsp:setProperty name="contatto" property="cognome" param="cognome"/>
<jsp:setProperty name="contatto" property="telefono" param="telefono"/>
<jsp:setProperty name="contatto" property="email" param="email"/>

<%
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
<h1>VERIFICA DEI DATI</h1><br>
NOME: &nbsp;&nbsp;<jsp:getProperty name="contatto" property="nome"/><br>
COGNOME: &nbsp;&nbsp;<jsp:getProperty name="contatto" property="cognome"/><br>
TELEFONO: &nbsp;&nbsp; <jsp:getProperty name="contatto" property="telefono"/><br>
EMAIL: &nbsp;&nbsp;<jsp:getProperty name="contatto" property="email"/><br>

<a href="newContatto.jsp">MODIFICA</a>&nbsp;<a href="addContatto">CONFERMA</a>


</body>
</html>