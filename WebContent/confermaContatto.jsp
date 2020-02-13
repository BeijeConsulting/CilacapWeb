<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css">
<link rel="stylesheet" href="styleIndex.css">
 <link rel="shortcut icon" href="favicon.ico" /> 
<title>Conferma Contatto</title>

</head>
<body>

<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto" scope="session" />
<jsp:setProperty name="contatto" property="nome"/>
<jsp:setProperty name="contatto" property="cognome"/>
<jsp:setProperty name="contatto" property="telefono"/>
<jsp:setProperty name="contatto" property="email"/>

<header class="header clearfix">
		<a href="index.html" class="header__logo"></a> <a href=""
			class="header__icon-bar"> <span></span> <span></span> <span></span>
		</a>
		<ul class="header__menu">
			<li class="header__menu__item"><a href="index.html">Home</a></li>
			
		</ul>
	</header>
		
<h1>VERIFICA I DATI INSERITI</h1>
NOME : <jsp:getProperty name="contatto" property="nome"/><br>
COGNOME : <jsp:getProperty name="contatto" property="cognome"/><br>
TELEFONO : <jsp:getProperty name="contatto" property="telefono"/><br>
EMAIL : <jsp:getProperty name="contatto" property="email"/><br>
<br>
<a href="inserisciContatti.jsp">MODIFICA</a>&nbsp;<a href="addContact">CONFERMA</a>
<footer class="footer">
		<p>Copyright - 2020 GabrieleDesign</p>
	</footer>		

</body>
</html>