package it.beije.cilacap.web;


import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/rubrica/csv")
public class TestServletCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Contatto contatto = new Contatto();
		LocalTime now = LocalTime.now();
		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
		
		
		List<Contatto> listContatto=ParserCSV.loadContactListFromCSV(new File("C:\\Users\\Padawan14\\git\\CilacapWeb\\csv\\rubrica3.csv"));
		StringBuilder stringaContatti= new StringBuilder();
		int i=0;
		for(Contatto c: listContatto) {
			i++;
			stringaContatti.append(c.toString(i));
		}
		System.out.println("Export eseguito");
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body style= \"color: white; background-color: blue\">").append(message).append("<hr>").append(stringaContatti).append("<hr></body></html>");
		
//		response.setContentType("text/html");  non lo utilizzo poichè è presente DOCTYPE
		response.getWriter().append(builder.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
