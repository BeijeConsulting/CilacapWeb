<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String a="Pluto";
%>
<%                                                             //le angolari sono sullo stesso livello, non sono uno scope.            

{
String b="Pippo";
out.print(b);      //stampa il valore in pagina, sull'html.E' come se avessi fatto l'append di un contenuto sulla servlet
}
System.out.println(a);      //stampa il valore su console.
%>

<%= a!=null ? a: "ciao" %>      //è come fare l'out.print.
</body>
</html>