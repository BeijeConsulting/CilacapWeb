package it.beije.cilacap.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.Utils;

@WebServlet("/addContatto")
public class addContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contatto c = new Contatto();
		
		c.setNome(request.getParameter("nome"));
		c.setCognome(request.getParameter("cognome"));
		c.setTelefono(request.getParameter("telefono"));
		c.setEmail(request.getParameter("email"));
		
		Utils.insertContattoJpa(c);
		
		
	}

}
