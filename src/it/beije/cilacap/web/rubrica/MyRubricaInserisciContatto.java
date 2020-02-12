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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("SALVO CONTATTO?");

		Contatto contatto = (Contatto) request.getSession().getAttribute("contatto"); //prendo il contatto dalla session.
		
		if (contatto != null) {
			
			System.out.println("procedo con salvataggio...");

			MyRubricaCSV_XML_DB_JPA.insertContact(contatto);
			request.getSession().setAttribute("contatto", new Contatto());

		} else {
			
			response.sendRedirect("inserisciContatti.jsp");
			
		}
		response.getWriter().append("<a href=\"index.html\"><strong>return home</strong></a>");
	}

}
