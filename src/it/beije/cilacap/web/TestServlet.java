package it.beije.cilacap.web;


import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.provaRubrica.Contatto;
import it.beije.cilacap.provaRubrica.DBtools;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Contatto> ListaContattiCaricati = new ArrayList<Contatto>();
		List <Contatto> ListaContattiCaricati2 = new ArrayList<Contatto>();
		//ListaContattiCaricati=DBtools.CaricareContattiCSV();
		try {
			ListaContattiCaricati2 = DBtools.CaricaContattiXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Contatto c:ListaContattiCaricati2) {
			response.getWriter().append(c.toString());
		}

		LocalTime now = LocalTime.now();
		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
		System.out.println("sono un output");

		
		//response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		response.setContentType("text/html");
		response.getWriter().append("username : ").append(username).append("<br>")
			.append("password : ").append(password);
	}

}
