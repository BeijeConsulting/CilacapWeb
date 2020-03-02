<html>
<head>
<meta charset="ISO-8859-1">
<title>Questo è un form</title>
</head>
<body>
	<form action="vedicontatto" method="get">
		NOME: <input type="text" name="nome" value="${contatto.nome}"><br>
		COGNOME: <input type="text" name="cognome" value="${contatto.cognome}"><br>
		TELEFONO: <input type="text" name="telefono" value="${contatto.telefono}"><br>
		EMAIL: <input type="text" name="email" value="${contatto.email}"><br>
		<input type="submit" value="INVIA">
	</form>
</body>
</html>