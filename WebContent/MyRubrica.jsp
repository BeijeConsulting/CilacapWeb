<%-- Questo è il mio form.jsp, di conseguenza, qui farò partire il server e metterò il form --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MyRubrica</title>
	</head>
	<body>
	
		<jsp:useBean id="contattoBean" class="it.beije.cilacap.util.Contatto" scope="session" />
		
		<form action="authMyRubrica.jsp" method="POST">
			<p>Form MyRubrica</p>
			Nome:<input type="text" name="param_nome" value="<%= contattoBean.getNome()!=null ? contattoBean.getNome() : "" %>"><br>
			Cognome:<input type="text" name="param_cognome" value="<%= contattoBean.getCognome()!=null ? contattoBean.getCognome() : "" %>"><br>
			Telefono:<input type="text" name="param_telefono" value="<%= contattoBean.getTelefono()!=null ? contattoBean.getTelefono() : "" %>"><br>
			Email:<input type="text" name="param_email" value="<%= contattoBean.getEmail()!=null ? contattoBean.getEmail() : "" %>"><br><br>
			<input type="submit" value="INVIA">
		</form>

	</body>
</html>