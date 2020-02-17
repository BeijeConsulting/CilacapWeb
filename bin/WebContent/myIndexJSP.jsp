

<%@page import="it.beije.cilacap.myWeb.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	StringBuilder html = new StringBuilder();
	html.append("<div style=\"padding: 10px; background: grey; color: white;\">\r\n" + 
		"		My Rubrica\r\n" + 
		"	</div>\r\n" + 
		"	<div style=\"padding: 10px; borde: 1px solid grey;\">");
	for(ContattoWeb c : ReadFromFile.caricaArrayListDiContattiFromCSV("C:\\Users\\Padawan04\\Desktop\\newRubrica.csv")){
		html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
				"Nome: " + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				c.getCognome() + 
				"		</div>\r\n" + 
				"		");
		
		html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
				"Cognome: " + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				c.getNome() + 
				"		</div>\r\n" + 
				"		");
		
		html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
				"Telefono: " + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				c.getTelefono() + 
				"		</div>\r\n" + 
				"		");
		
		html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
				"Email: " + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				c.getEmail() + 
				"		</div>\r\n" + 
				"		");
		
		html.append("<br><div style=\"height: 1px; border-top: 1px solid grey;\"></div><br>");
	}
	out.println(html.toString() + "</div>");
	int a = 22;
%>
<%= a %>
</body>
</html>