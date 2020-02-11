package it.beije.cilacap.web;

import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XMLservlet
 */
@WebServlet("/xmlservlet")
public class XMLservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FileReader reader = new FileReader("C:\\temp\\domande.xml");
		
		int c;
		StringBuilder builder = new StringBuilder();
		while ((c = reader.read()) >= 0) {
			builder.append((char)c);
		}

		response.setContentType("application/xml");
		response.getWriter().append(builder.toString());

	}

}
