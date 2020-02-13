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

<jsp:useBean id="userBean" class="it.beije.cilacap.web.User" scope="session" />
<jsp:setProperty name="userBean" property="firstName" param="param_nome"/>
<jsp:setProperty name="userBean" property="lastName" param="param_cognome"/>
<jsp:setProperty name="userBean" property="username"/>


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

<p>Conferma i dati che hai inserito:</p><br>
Nome: <jsp:getProperty name="userBean" property="firstName"/><br>
Cognome: <jsp:getProperty name="userBean" property="lastName"/><br>
Username: <jsp:getProperty name="userBean" property="username"/>
<br><br>
<a href="myLogin.jsp">MODIFICA</a> <a href="conferma.jsp">CONFERMA</a>

<%
	session.setAttribute("nome", userBean.getFirstName());
	session.setAttribute("cognome", userBean.getLastName());
	session.setAttribute("username", userBean.getUsername());
%>

</body>
</html>