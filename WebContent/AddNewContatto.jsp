<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Contatto</title>
</head>
<body>
	<div style="width: 100%; padding: 10px; background: grey; color: #fff;">Inserisci un nuovo contatto:</div>
	<br>
	<form method="POST" action="insertContatto.jsp" style="border-bottom: 2px solid grey; padding-left: 10px;">
		<label><b>Nome:&nbsp;</b></label><input name="name" type="text" placeholder="Mario" />
		<br><br>
		<label><b>Cognome:&nbsp;</b></label><input name="surname" type="text" placeholder="Rossi" />
		<br><br>
		<label><b>Telefono:&nbsp;</b></label><input name="tel" type="text" placeholder="" />
		<br><br>
		<label><b>Email:&nbsp;</b></label><input name="mail" type="text" placeholder="mario@rossi.it" />
		<br><br>
		<input type="submit" name="salvaContatto" value="Salva contatto" />
		<br><br>
	</form>
</body>
</html>