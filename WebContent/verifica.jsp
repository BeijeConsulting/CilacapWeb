
<html>
<head>
<meta charset="ISO-8859-1">
<title>VEDI DATI INSERITI</title>
</head>
<body>

<jsp:useBean id="contatto" class="it.beije.cilacap.web.rubrica.Contatto" scope="session" />
<jsp:setProperty name="contatto" property="nome"/>
<jsp:setProperty name="contatto" property="cognome"/>
<jsp:setProperty name="contatto" property="telefono"/>
<jsp:setProperty name="contatto" property="email"/>
<% System.out.println("vedi :\n" + contatto); %>

<h1>VERIFICA I DATI INSERITI</h1>
NOME : <jsp:getProperty name="contatto" property="nome"/><br>
COGNOME : <jsp:getProperty name="contatto" property="cognome"/><br>
TELEFONO : <jsp:getProperty name="contatto" property="telefono"/><br>
EMAIL : <jsp:getProperty name="contatto" property="email"/><br>
<br>
<a href="formcontatto.jsp">MODIFICA</a>&nbsp;<a href="../salva">CONFERMA</a>

</body>
</html>