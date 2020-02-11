 package it.beije.cilacap.web;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.web.Contatto;
import it.beije.cilacap.rubrica.web.ConversionFromCSV;
import it.beije.cilacap.rubrica.web.TextFileManager;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TextFileManager t = new TextFileManager();
	ConversionFromCSV c = new ConversionFromCSV();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> list = t.readFileRows("C:\\Users\\Padawan02\\git\\CilacapWeb\\WebContent\\csvWeb\\rubrica1.csv");
		List<Contatto> contatti = c.convertiInOggetto(list);

		Contatto contatto = new Contatto();
		// LocalTime now = LocalTime.now();
		// String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" :
		// "BUONASERA";

		StringBuilder builder = new StringBuilder();
		for (Contatto c : contatti) {
			builder.append("nome: " + c.getNome()).append(" cognome: " + c.getCognome()).append(" telefono: " +c.getTelefono()).append(" email: " +c.getEmail()).append("</br>");
			
		}
		//StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		//builder.append("<body><b>").append(message).append(" CILACAP").append("</b></body></html>");

		// response.setContentType("text/html");
		response.getWriter().append(builder.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
