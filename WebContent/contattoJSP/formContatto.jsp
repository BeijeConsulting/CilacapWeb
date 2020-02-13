<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="insertContatto.jsp" method="POST">
<jsp:useBean id="contattoBean" class="it.beije.cilacap.esercizi.myRubrica.Contatto2" scope="session" />
  Nome: <input type="text" name="param_nome" value="<% if(contattoBean.getNome() != null) out.print(contattoBean.getNome());%>"><br><br>
  Cognome: <input type="text" name="param_cognome" value="<% if(contattoBean.getCognome() != null) out.print(contattoBean.getCognome());%>"><br><br>
  Telefono: <input type="text" name="telefono" value="<% if(contattoBean.getTelefono() != null) out.print(contattoBean.getTelefono());%>"><br><br>
  Email: <input type="text" name="email" value="<% if(contattoBean.getEmail() != null) out.print(contattoBean.getEmail());%>"><br><br>
  <input type="submit" value="INVIA">
</form>

</body>
</html>