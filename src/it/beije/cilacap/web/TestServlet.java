package it.beije.cilacap.web;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.beije.cilacap.util.*;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Contatto contatto = new Contatto();
		LocalTime now = LocalTime.now();
		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		//builder.append("<body><b>").append(message).append(" CILACAP").append("</b></body></html>");
		
		public static void main(String[] args) throws IOException
		{
			StringBuilder s = new StringBuilder(); //creo la struttura iniziale
			String append = new String(); //stringa di supporto per fare append
			{
				List<String> righe = new ArrayList<String>(); //struttura iniziale per lettura
				File f = new File("csv\\MyRubrica.csv"); //importazione file
				righe = readContent(f); //lettura e memorizzazione in ArrayList
				setStringBuilder (s, righe);//metodo per fare append nello StringBuilder con i valori dell'ArrayList.
				
			}
			
			public static List<String> readContent(File file) throws IOException
			{
				List<String> rows = new ArrayList<String>(); //ciascuna riga viene memorizzata in una stringa dell'ArrayList
				FileReader fileReader = new FileReader(file);
				BufferedReader reader = new BufferedReader(fileReader);
				
				String row = reader.readLine();
				while (row != null)
				{
					rows.add(row);
					row = reader.readLine();
				}
				
				reader.close();
				
				return rows;
			}
			
			public static void setStringBuilder (StringBuilder sb, List<String> lista)
			{
				for(int i=0; i<lista.size(); i++)
				{
					setNewValue(sb, lista.get(i));
				}
			}
			
			public static void setNewValue(StringBuilder sb, String valore)
			{
				sb.append(valore);
				sb.append("\n");
			}
			
		}
		
//		builder.append(
//				"<body>"
//				+ ""
//				+ "</body></html>");
		
		
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
