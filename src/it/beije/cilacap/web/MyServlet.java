package it.beije.cilacap.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.web.Contatto;
import it.beije.cilacap.rubrica.web.ConversionFromCSV;
import it.beije.cilacap.rubrica.web.TextFileManager;

@WebServlet("/testM")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// TextFileManager t = new TextFileManager();
	// ConversionFromCSV c = new ConversionFromCSV();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Contatto contatto = new Contatto();
		// LocalTime now = LocalTime.now();
		// String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" :
		// "BUONASERA";

		// response.getWriter().append(builder.toString());
		// StringBuilder builder = new StringBuilder("<!DOCTYPE
		// html><html><head><title>CILACAP</title></head>");
		// builder.append("<body><b>").append(message).append("
		// CILACAP").append("</b></body></html>");

		// response.setContentType("text/html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");

		System.out.println("username : " + username);
		System.out.println("password : " + password);

		response.setContentType("text/html");
		response.getWriter().append("username : ").append(username).append("<br>").append("password : ")
				.append(password).append("<br>").append("telefono : ")
				.append(telefono).append("<br>").append("email : ")
				.append(email).append("<br>");
	}

}
