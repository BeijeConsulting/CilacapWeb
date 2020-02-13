<%@page import="it.beije.cilacap.utils.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BEAN</title>
</head>
<body>

<jsp:useBean id="userBean" class="it.beije.cilacap.utils.Contatto" scope="session" />
<jsp:setProperty name="userBean" property="nome"/>
<jsp:setProperty name="userBean" property="cognome"/>
<jsp:setProperty name="userBean" property="email"/>
<jsp:setProperty name="userBean" property="telefono"/>

<%  System.out.println("vedi :\n" + userBean); 
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
<h1>
<%= userBean.getNome() %> <%= userBean.getCognome() %><br><br></h1>
<h2>NOME: <jsp:getProperty name="userBean" property="nome"/><br>
COGNOME: <jsp:getProperty name="userBean" property="cognome"/><br>
EMAIL: <jsp:getProperty name="userBean" property="email"/><br>
TELEFONO: <jsp:getProperty name="userBean" property="telefono"/>
</h2><br>
<br><br>

 <a href="form.jsp">MODIFICA </a><br>
 <a href="conferma.jsp">CONFERMA </a>
 

</body>
</html>