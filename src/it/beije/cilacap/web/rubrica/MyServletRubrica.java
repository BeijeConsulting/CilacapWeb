package it.beije.cilacap.web.rubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.web.rubrica.Contatto;
import it.beije.cilacap.util.JPDBtools;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/Exercise_LoginDatabase/servlet_rubrica")
public class MyServletRubrica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Creation of a new contatto that gets the attributes previously set
		Contatto contatto = (Contatto) request.getSession().getAttribute("contatto");
		if (contatto == null) {
			contatto = new Contatto();
			request.getSession().setAttribute("contatto", contatto);
		}
		
		//Creation of strings with the properties from contatto
		String nome = contatto.getNome();
		String cognome = contatto.getCognome();
		String telefono = contatto.getTelefono();
		String email = contatto.getEmail();
	
		System.out.println("nome : " + nome);
		System.out.println("cognome : " + cognome);
		System.out.println("telefono : " + telefono);
		System.out.println("email : " + email);
		
		//EntityManager creation
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapWeb");
				EntityManager em = factory.createEntityManager();
				
				//Transaction initiation
				em.getTransaction().begin();
				
				//Insert
				contatto.setNome(nome);
				contatto.setCognome(cognome);
				contatto.setEmail(email);
				contatto.setTelefono(telefono);
				em.persist(contatto);
					
				//Confirmation of command on DB 
				em.getTransaction().commit();

				//Entity manager close
				em.close();
				
		//Redirect information to confirmation page		
		response.sendRedirect("Confirmation_Page.jsp");
			
		}
	
	}


