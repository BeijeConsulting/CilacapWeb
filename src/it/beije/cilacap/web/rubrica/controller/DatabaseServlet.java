package it.beije.cilacap.web.rubrica.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.web.rubrica.JpaMethods;
import it.beije.cilacap.web.rubrica.model.Contatto;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> listaContatti= JpaMethods.leggiContatti();
		StringBuilder contatti= new StringBuilder();
		for(Contatto c: listaContatti)
			contatti.append(c.toString()).append("<hr><hr>");
		
		response.getWriter().append("<!DOCTYPE html><html><head><title>CILACAP</title></head><body>").append(contatti.toString()).append("<a href=\"rubrica.jsp\">Clicca qui per aggiungere un nuovo contatto</a>").append("</body></html>");
	}

}
