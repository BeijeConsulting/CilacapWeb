package it.beije.cilacap.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.DBtools;

/**
 * Servlet implementation class addContatto
 */
@WebServlet("/addContatto")
public class addContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contatto contatto =(Contatto) request.getSession().getAttribute("contatto");
		
		
//		String nome = (String) request.getSession().getAttribute("nome");
//		String cognome = (String) request.getSession().getAttribute("cognome");
//		String telefono = (String) request.getSession().getAttribute("telefono");
//		String email = (String) request.getSession().getAttribute("email");
		
//		contatto.setNome(nome);
//		contatto.setCognome(cognome);
//		contatto.setTelefono(telefono);
//		contatto.setEmail(email);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<a href= newContatto.jsp>Torna alla HomePage</a><br>");
		
		request.getSession().setAttribute("contatto", new Contatto());
		
		response.getWriter().append("<!DOCTYPE html><html><head><title>CILACAP</title></head>")
			.append("<p>Contatto salvato con successo</p><br>")
			.append("<body><b>")
			.append(DBtools.printRubricaHTML(contatto))
			.append("<body><b><br>")
			.append(sb.toString());
		
		if (contatto.getNome()!=null) {
			try {
				DBtools.insertContattoJPA(contatto);
			}catch(Exception e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		
//		contatto.setNome(request.getParameter("nome"));
//		contatto.setCognome(request.getParameter("cognome"));
//		contatto.setTelefono(request.getParameter("telefono"));
//		contatto.setEmail(request.getParameter("email"));
//		
//		System.out.println(contatto.getNome());
//		
		
		
	}

}
