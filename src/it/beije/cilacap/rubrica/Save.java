package it.beije.cilacap.rubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Salva
 */
@WebServlet("/salva")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SALVO CONTATTO?");
		
		MioContatto contatto = (MioContatto)request.getSession().getAttribute("MioContatto");
		if (contatto != null) {
			System.out.println("procedo con salvataggio...");
			
			response.sendRedirect("./rubrica/SalvataggioConfermato.jsp");
		} else {
			response.sendRedirect("./rubrica/DatiRubrica.jsp");
		}
	}

}
