package it.beije.cilacap.myWeb;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import it.beije.cilacap.myWeb.util.ContattoWeb;
import it.beije.cilacap.myWeb.util.ReadFromFile;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/rubricaXML")
public class RubricaXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder html = new StringBuilder();
		html.append("<html>\r\n" + 
				"<head>\r\n" + 
				"	<title>My Rubrica</title>\r\n" + 
				"</head>\r" + 
				"<body>\r\n" + 
				"	<div style=\"padding: 10px; background: grey; color: white;\">\r\n" + 
				"		My Rubrica\r\n" + 
				"	</div>\r\n" + 
				"	<div style=\"padding: 10px; borde: 1px solid grey;\">");
		
		// legge da CSV
		//List<ContattoWeb> listaContatti = MyRubrica.caricaArrayListDiContattiFromCSV("C:\\Users\\Padawan04\\Desktop\\newRubrica.csv");
		
		// legge da XML
		List<ContattoWeb> listaContatti = null;
		try {
			listaContatti = ReadFromFile.caricaArrayListDiContattiFromXML("C:\\Users\\Padawan04\\Desktop\\newRubrica.xml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// stampa contatti in pagina html
		for(ContattoWeb c : listaContatti) {
			html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
					"Nome: " + 
					"		</div>\r\n" + 
					"		<div>\r\n" + 
					c.getCognome() + 
					"		</div>\r\n" + 
					"		");
			
			html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
					"Cognome: " + 
					"		</div>\r\n" + 
					"		<div>\r\n" + 
					c.getNome() + 
					"		</div>\r\n" + 
					"		");
			
			html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
					"Telefono: " + 
					"		</div>\r\n" + 
					"		<div>\r\n" + 
					c.getTelefono() + 
					"		</div>\r\n" + 
					"		");
			
			html.append("<div style=\"font-weight: bold; width: 180px; float: left;\">\r\n" + 
					"Email: " + 
					"		</div>\r\n" + 
					"		<div>\r\n" + 
					c.getEmail() + 
					"		</div>\r\n" + 
					"		");
			
			html.append("<br><div style=\"height: 1px; border-top: 1px solid grey;\"></div><br>");
			
		}
		
		html.append("</body></html>");
		
		
//		LocalTime now = LocalTime.now();
//		String message = now.isBefore(LocalTime.of(16, 00)) ? "BUONGIORNO" : "BUONASERA";
//		System.out.println("sono un output");
//		
//		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
//		builder.append("<body><b>").append(message).append(" CILACAP").append("</b></body></html>");
		
		//response.setContentType("application/xml");
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
