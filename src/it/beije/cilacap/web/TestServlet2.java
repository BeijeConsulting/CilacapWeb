package it.beije.cilacap.web;


import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//File file = new File();
		
		
		
		
//		Contatto contatto = new Contatto();
		LocalTime now = LocalTime.now();
		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
		System.out.println("sono un output");
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body><b>").append(message).append(" CILACAP").append("</b></body></html>");
		builder.append("<img src=https://htpwj-zone1-rrzzqutxbqkmxn.netdna-ssl.com/wp-content/uploads/2012/09/Java-Podcast.jpg />");  
		//response.setContentType("text/html");
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
