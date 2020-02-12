package it.beije.cilacap.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.utils.Contatto;

/**
 * Servlet implementation class Salva
 */
@WebServlet("/salva")
public class Salva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SALVO CONTATTO?");
		
		Contatto contatto = (Contatto)request.getSession().getAttribute("userBean");
		if (contatto != null) {
			System.out.println("procedo con salvataggio...");
			
			response.sendRedirect("conferma.jsp");
		} else {
			response.sendRedirect("form.jsp");
		}
	}

}
