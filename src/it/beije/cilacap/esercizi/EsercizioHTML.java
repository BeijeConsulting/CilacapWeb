package it.beije.cilacap.esercizi;

import java.io.*;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class EsercizioHTML extends HttpServlet {
	private static final long serialVersionUID = 2L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File file = new File("C:/work/Provaa.txt");
		byte[] fileContent = Files.readAllBytes(file.toPath());
		
//		response.setContentType("application/CSV");
		response.setContentLength(fileContent.length);
		OutputStream os = response.getOutputStream();
		
		try {
			os.write(fileContent, 0, fileContent.length);
		} catch (Exception excp) {
			
		} finally {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

