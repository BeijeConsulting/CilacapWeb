<%@page import="src.it.beije.cilacap.web.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BEAN</title>
</head>
<body>

<jsp:useBean id="userBean" class="src.it.beije.cilacap.web.User" scope="session" />
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

<%= userBean.getFirstName() %> <%= userBean.getLastName() %><br><br>
<jsp:getProperty name="userBean" property="firstName"/><br>
<jsp:getProperty name="userBean" property="lastName"/><br>
<jsp:getProperty name="userBean" property="username"/>
<br><br>
<a href="form.jsp">MODIFICA</a>

</body>
</html>