package it.beije.cilacap.web.ivo;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Downloader
 */
@WebServlet("/downloader")
public class Downloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File file = new File("C:\\temp\\im_going_to_ignore_you.png");
//		File file = new File("C:\\javalib\\mysql-connector-java-8.0.15.jar");
		byte[] fileContent = Files.readAllBytes(file.toPath());
		
//		response.setContentType("image/png");
		response.setContentType("application/zip");
		response.setContentLength(fileContent.length);
		OutputStream os = response.getOutputStream();

		try {
		   os.write(fileContent , 0, fileContent.length);
		} catch (Exception excp) {
		   //handle error
		} finally {
		    os.close();
		}		
	}

}
