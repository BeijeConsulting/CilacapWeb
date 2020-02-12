package it.beije.cilacap.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.DBtools;

/**
 * Servlet implementation class addContatto
 */
@WebServlet("/addContatto")
public class addContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addContatto() {
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
		// TODO Auto-generated method stub
		Contatto contatto = new Contatto();
		
		contatto.setNome(request.getParameter("nome"));
		contatto.setCognome(request.getParameter("cognome"));
		contatto.setTelefono(request.getParameter("telefono"));
		contatto.setEmail(request.getParameter("email"));
		
		System.out.println(contatto.getNome());
		
		try {
			DBtools.insertContattoJPA(contatto);
		}catch(Exception e) {}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<a href= login.jsp target= _blank>Torna alla HomePage</a><br>");
		
		response.getWriter().append("<!DOCTYPE html><html><head><title>CILACAP</title></head>")
			.append("<p>Contatto salvato con successo</p><br>")
			.append("<body><b>")
			.append(DBtools.printRubricaHTML(contatto))
			.append("<body><b><br>")
			.append(sb.toString());
	}

}
