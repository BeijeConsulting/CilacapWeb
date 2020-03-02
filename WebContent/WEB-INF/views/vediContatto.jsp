<html>
   <head>
      <title>Vedi dati del contatto</title>
   </head>

   <body>
   
   <form action="formcontatto" method="POST">
      NOME: ${contatto.nome}<br>
      COGNOME: ${contatto.cognome}<br>
      TELEFONO: ${contatto.telefono}<br>
      EMAIL: ${contatto.email}<br>
      
      <p>Premi il pulsante sottostante per inserire un nuovo contatto.</p>
      <input type="submit" value="NUOVO CONTATTO">
      </form>
   </body>
</html> 