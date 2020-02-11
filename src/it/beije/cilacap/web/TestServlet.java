package it.beije.cilacap.web;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/MyContacts")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		StringBuilder s = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		s.append("<body>");
		
		List<String> righe = new ArrayList<String>(); //struttura iniziale per lettura
		File f = new File("C:\\Users\\Padawan12\\git\\CilacapWeb\\csv\\MyRubrica.csv"); //importazione file
		
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row = reader.readLine();
		while (row != null)
		{
			righe.add(row);
			row = reader.readLine();
		}
		reader.close();
		
		for(int i=0; i<righe.size(); i++)
		{
			s.append(righe);
			s.append("\n");
		}
		
		

		s.append("</body></html>");
		response.getWriter().append(s.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		response.setContentType("text/html");
		response.getWriter().append("username : ").append(username).append("<br>")
			.append("password : ").append(password);
	}
}
