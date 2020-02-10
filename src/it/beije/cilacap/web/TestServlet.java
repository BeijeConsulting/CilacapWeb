package it.beije.cilacap.web;


import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contatto contatto = new Contatto();
		LocalTime now = LocalTime.now();
		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
		System.out.println("sono un output");
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body><b>").append(message).append(" CILACAP").append("</b></body></html>");
		
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