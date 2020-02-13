package it.beije.cilacap.rubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;

/**
 * Servlet implementation class Salva
 */
@WebServlet("/save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SALVO CONTATTO?");
		
		Contatto contatto = (Contatto)request.getSession().getAttribute("Contatto");
		if (contatto != null) {
			System.out.println("procedo con salvataggio...");
			
			response.sendRedirect("./WEB-INF/SalvataggioConfermato.jsp");
		} else {
			response.sendRedirect("./WEB-INF/DatiRubrica.jsp");
		}
	}

}
