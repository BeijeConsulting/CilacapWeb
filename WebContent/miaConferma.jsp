<%@page import="it.beije.cilacap.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Richiesta conferma</title>
</head>
<body>
<h1> CONFERMA O MODIFICA I DATI CHE HAI INSERITO</h1>

<jsp:useBean id="Miocontatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />
<jsp:setProperty name="Miocontatto" property="nome"  />
<jsp:setProperty name="Miocontatto" property="cognome" />
<jsp:setProperty name="Miocontatto" property="telefono" />
<jsp:setProperty name="Miocontatto" property="email"/>

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



Nome: <jsp:getProperty name="Miocontatto" property="nome"/><br>
Cognome: <jsp:getProperty name="Miocontatto" property="cognome"/><br>
Telefono: <jsp:getProperty name="Miocontatto" property="telefono"/><br>
Email: <jsp:getProperty name="Miocontatto" property="email"/>
<br><br>

<input type="submit" onclick="location.href='DatiRubricaJSP.jsp'" value="MODIFICA">&nbps;

<input type="submit" onclick="location.href='SalvataggioConfermato.jsp'" value="CONFERMA">

</body>
</html>