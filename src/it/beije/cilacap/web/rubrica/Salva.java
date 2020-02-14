package it.beije.cilacap.web.rubrica;

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
public class Salva extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SALVO CONTATTO?");
		
		Contatto contatto = (Contatto)request.getSession().getAttribute("contatto");
		if (contatto != null) {
			System.out.println("procedo con salvataggio...");
			
			response.sendRedirect("./rubrica/conferma.jsp");
		} else {
			response.sendRedirect("./rubrica/formcontatto.jsp");
		}
	}

}
