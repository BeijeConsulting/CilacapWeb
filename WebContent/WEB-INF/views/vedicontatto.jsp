<html>
   <head>
      <title>Vedi dati del contatto</title>
   </head>
   <body>
      NOME: ${contatto.nome}<br>
      COGNOME: ${contatto.cognome}<br>
      TELEFONO: ${contatto.telefono}<br>
      EMAIL: ${contatto.email}<br>
      <form action="form" method="get">
		<input type="submit" value="MODIFICA">
		</form>
		<form action="salvato" method="get">
		<input type="submit" value="PROCEDI">
		</form>
   </body>
</html>