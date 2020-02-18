<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>CONFERMA INSERIMENTO DATI</title>
	</head>
	<body>
	
		<%//Next line defines the use of the Bean contatto for the entire session %>
		<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
		
		<h1>HO SALVATO I SEGUENTI DATI:</h1>
		
		NOME : <jsp:getProperty name="contatto" property="nome"/><br>
		COGNOME : <jsp:getProperty name="contatto" property="cognome"/><br>
		TELEFONO : <jsp:getProperty name="contatto" property="telefono"/><br>
		EMAIL : <jsp:getProperty name="contatto" property="email"/><br>
		
		<br>
		
		<%//Setting contatto to null so a new value can be obtained
		contatto = null;
		request.getSession().setAttribute("contatto", contatto);
		System.out.println(contatto); %>
				
		<%// Form that will redirect this information back to  to the initial page %>	
		<form action="mylogin.jsp" method="POST">
			<input type="submit" value="INSERISCI NUOVI DATI">
		</form>
		
	</body>
</html>