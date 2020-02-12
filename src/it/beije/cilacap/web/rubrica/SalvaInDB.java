package it.beije.cilacap.web.rubrica;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.ParserJPDB;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/salvaInDB")
public class SalvaInDB extends HttpServlet {
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
		System.out.println("provo a salvare in db");
		try {
			Contatto con = (Contatto) request.getSession().getAttribute("contatto");
			
			System.out.println("----------\n"+con+"\n----ricevuto---");
			
			ArrayList<Contatto> lista = new ArrayList<Contatto>();
			lista.add(con);
			
			System.out.println("aggiunto in lista");
			
			ParserJPDB.writeContattiInJPDB(lista);
		}catch(Exception e){
			response.getWriter().append("Errore durante il salvataggio");
			System.out.println("errore");
			e.printStackTrace();
		}
		response.setContentType("text/html");
		response.sendRedirect("salvatoInDB.jsp");
		
	}

}