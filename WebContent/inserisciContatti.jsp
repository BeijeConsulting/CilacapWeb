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
<title>Gabriele's Rubrica insertContact</title>

</head>
<body>


	<header class="header clearfix">
		<a href="index.html" class="header__logo"></a> <a href=""
			class="header__icon-bar"> <span></span> <span></span> <span></span>
		</a>
		<ul class="header__menu">
			<li class="header__menu__item"><a href="index.html">Home</a></li>

		</ul>
	</header>
	<jsp:useBean id="contatto" class="it.beije.cilacap.rubrica.Contatto"
		scope="session" />
	<jsp:getProperty name="contatto" property="nome" />
	<jsp:getProperty name="contatto" property="cognome" />
	<jsp:getProperty name="contatto" property="telefono" />
	<jsp:getProperty name="contatto" property="email" />

	<form action="confermaContatto.jsp" method="POST" class="form__insert">

		<h1>Inserisci Contatto</h1>
		<hr class="hr__styled">
		<div>
			nome: <input type="text" name="nome"
				value="<%=contatto.getNome() != null ? contatto.getNome() : ""%>"><br>
			<br> cognome: <input type="text" name="cognome"
				value="<%=contatto.getCognome() != null ? contatto.getCognome() : ""%>"><br>
			<br> telefono: <input type="text" name="telefono"
				value="<%=contatto.getTelefono() != null ? contatto.getTelefono() : ""%>"><br>
			<br> email: <input type="text" name="email"
				value="<%=contatto.getEmail() != null ? contatto.getEmail() : ""%>"><br>
			<br> <input type="submit" value="Inserisci">
		</div>
	</form>


	<footer class="footer">
		<p>Copyright - 2020 GabrieleDesign</p>
	</footer>
</body>
</html>