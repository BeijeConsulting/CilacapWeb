package it.beije.cilacap.web;


import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.web.rubrica.Contatto;
import it.beije.cilacap.web.rubrica.MyRubricaCSV_XML_General;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/rubrica/csv_io")
public class CSVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contatto> listaContatti = MyRubricaCSV_XML_General.caricaContattiDaCSV("C:\\Users\\Padawan13\\git\\CilacapWeb\\WebContent\\WEB-INF\\csv\\rubrica1.csv");
		LocalTime now = LocalTime.now();
		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CilcapaWeb Gabriele</title></head>");
		builder.append("<body style=\"text-align:center; background-color:#3b5998\"><b>").append("<h1 style=\"background-color:#c93c20;\">");
		builder.append(message).append("</h1>");
		builder.append("<hr>");
		stampaContatti(builder, listaContatti);
		builder.append("<hr>");
		builder.append("<h1 style=\"background-color:#c93c20;\">");
		builder.append(" CILACAP").append("</b></body></html>");
		builder.append("</h1>");
		builder.append("<hr>");
		builder.append("<hr>");
		builder.append("<img src=\"C:\\Users\\Padawan13\\git\\CilacapWeb\\WebContent\\WEB-INF\\WIN_20200129_15_08_11_Pro.jpg\">");
		System.out.println("success ! !");
		
		//response.setContentType("text/html");
		response.getWriter().append(builder.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void stampaContatti(StringBuilder a, List<Contatto> listaContatti) {
		for(Contatto c : listaContatti) {
			a.append(c.toStringHTML());
		}
		
	}

}
