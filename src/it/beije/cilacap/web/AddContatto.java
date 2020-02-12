package it.beije.cilacap.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.ParserJPDB;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/addContatto")
public class AddContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		Contatto con = new Contatto();
		con.setNome(nome);
		con.setCognome(cognome);
		con.setTelefono(telefono);
		con.setEmail(email);
		ArrayList<Contatto> lista = new ArrayList<Contatto>();
		lista.add(con);
		System.out.println(con);
		ParserJPDB.writeContattiInJPDB(lista);
		System.out.println("ho inserito");
		response.setContentType("text/html");
		response.getWriter().append("Hai salvato i dati di ").append(nome+ " ").append(cognome);
	}

}
