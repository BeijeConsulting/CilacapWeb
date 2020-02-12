package it.beije.cilacap.web;

import static it.beije.cilacap.utils.MetodiHTML.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.beije.cilacap.utils.*;


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
		
		File f = new File("C:/work/prova.csv");
		StringBuilder builderino = new StringBuilder();
		Contatto contatto = new Contatto();
		int i=0;
		do {
				
				builderino.append((generaLista(f).get(i).toString()));
				i++;
			}
		while(i<generaLista(f).size());
		
		LocalTime now = LocalTime.now();
		
		String message = contatto.toString();
		System.out.println("sono un output");
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body><b>").append(builderino).append("</b></body></html>");
		
		response.setContentType("text/html");
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
