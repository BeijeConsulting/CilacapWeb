package it.beije.cilacap.rubrica;


import java.awt.List;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/testrubrica")
public class MiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder html=new StringBuilder("<!DOCTYPE html><html><head><title>MiaRubrica</title></head>");
		html.append("<body><h1>RUBRICA</h1>");
     	
     	ContattoWeb c=new ContattoWeb();
     	ArrayList<ContattoWeb> lista=new ArrayList<ContattoWeb>();
     	
//     	c2.settoFile(lista,"C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
     	
//     	for(ContattoWeb c:lista) {
     		c.setCognome("Pino");
     		c.setNome("Gang");
     		c.setTelefono("3397225004");
     		c.setEmail("ciaociao@aaa.com");
     		html.append("<p>COGNOME:"
     				+ c.getCognome()+
     				
     				"</p>");
     		html.append("<p> Nome:"
     				+c.getNome()+
     				
     				"</p>");
     		html.append("<p>TELEFONO:"
     				+c.getTelefono()+
     				
     				"</p>");
     		html.append("<p>EMAIL:"
     				+c.getEmail()+
     				
     				"</p>");
     	
    
     	html.append("</body></html>");
     	
     	System.out.println("Il server funge");
     	
     	
//		LocalTime now = LocalTime.now();
//		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
//		System.out.println("sono un output");
//		
//		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
//		builder.append("<body><b>").append(message).append(" CILACAP").append("</b></body></html>");
		
		response.setContentType("text/html");
		response.getWriter().append(html.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}