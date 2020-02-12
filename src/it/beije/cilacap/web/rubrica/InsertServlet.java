package it.beije.cilacap.web.rubrica;

import java.io.File;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.web.rubrica.Contatto;

/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto nuovoContatto=new Contatto();
		nuovoContatto.setNome(request.getParameter("nome"));
		nuovoContatto.setCognome(request.getParameter("cognome"));		
		nuovoContatto.setTelefono(request.getParameter("telefono"));		
		nuovoContatto.setEmail(request.getParameter("email"));		
		
		
		List <Contatto> listaContatti= new ArrayList<Contatto> ();
		listaContatti.add(nuovoContatto);
		File f1=new File ("\\Users\\Padawan14\\git\\CilacapWeb\\csv\\rubricaWeb.csv");
		ParserCSV.writeInFileCSV(listaContatti, f1);
		
		System.out.println(nuovoContatto.toString());

		try {
			JpaMethods.inserisciContatti(listaContatti);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body>").append("Il contatto: <br>").append(nuovoContatto.toString()).append("<br> <b> è stato aggiunto </b> <br> <a href=\"rubrica.jsp\"> Clicca qui per aggiungere nuovo contatto </a>").append("</body></html>");
		
		
		response.setContentType("text/html");
		response.getWriter().append(builder.toString());
	}

}
