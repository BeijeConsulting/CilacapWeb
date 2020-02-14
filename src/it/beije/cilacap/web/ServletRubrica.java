package it.beije.cilacap.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.util.Contatto;
import it.beije.cilacap.util.DBtools;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/rubrica")
public class ServletRubrica extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body><b>").append(" CILACAP").append("</b></body></html>");
		
		//response.setContentType("text/html");
		response.getWriter().append(builder.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		List<Contatto> contacts = new ArrayList<Contatto>();
		Contatto contatto = new Contatto();
    	contatto.setNome(username);
    	contatto.setCognome(cognome);
    	contatto.setTelefono(telefono);
    	contatto.setEmail(email);
    	contacts.add(contatto);
    	
		System.out.println("username : " + username);
		System.out.println("cognome : " + cognome);
		System.out.println("telefono : " + telefono);
		System.out.println("email : " + email);
		
		response.setContentType("text/html");
		response.getWriter().append("username : ").append(username).append("<br>")
			.append("cognome : ").append(cognome).append("<br>").append("telefono: ")
			.append(telefono).append("<br>").append("email: ").append(email).append("<br>");
		
		
		try {
			
			DBtools.insertContatto(contacts);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
	}

}
