package it.beije.cilacap.web.rubrica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.MyRubricaCSV_XML_DB_JPA;


@WebServlet("/addContact")
public class MyRubricaInserisciContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyRubricaInserisciContatto() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		Contatto contatto = new Contatto();
		response.getWriter().append("<p>Campi del Contatto Inseriti Nel DB:</p>");
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		MyRubricaCSV_XML_DB_JPA.insertContact(contatto);
		System.out.println("contatto inserito nel db con successo");
		StringBuilder a = new StringBuilder();
		a.append("<a href=\"index.html\">return</a>");
		response.getWriter().append(contatto.toStringHTML()).append("<br>").append(a.toString());
		
		
	}

}
