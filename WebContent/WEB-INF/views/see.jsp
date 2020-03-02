<html>
   <head>
      <title>Vedi dati del form</title>
   </head>

   <body>
   
<form action="formcontatto" method="POST">
      NOME: ${contatto.nome}<br><br>
      COGNOME: ${contatto.cognome}<br><br>
      TELEFONO: ${contatto.telefono}<br><br>
      EMAIL:${contatto.email}<br><br>
      
      
      <input type="submit" value="MODIFICA CONTATTO"&nbsp;&nbsp;>
      <input type="submit" onclick="location.href='vediContatto'" value="SALVA CONTATTO">
      
      </form>
   </body>
   
   
</html> 