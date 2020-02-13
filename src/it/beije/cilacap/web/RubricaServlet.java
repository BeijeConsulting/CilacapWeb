package it.beije.cilacap.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.tools.*;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/rubrica")
public class RubricaServlet extends HttpServlet{

	 
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
			
			CreaContatto cont = new CreaContatto();
			
			User userBean = (User) request.getSession().getAttribute("userBean");
			if (userBean == null) {
				userBean = new User();
				request.getSession().setAttribute("user", userBean);
			}
			
			String nome = userBean.getNome();
			String cognome = userBean.getCognome();
			String telefono = userBean.getTelefono();
			String email = userBean.getEmail();
			
			Contatto contatto = cont.CreazioneContatto(nome,cognome,telefono,email);
			
			System.out.println(contatto);	
			
			try {
				DBtools.insertContatto(contatto);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			userBean = null;
			request.getSession().setAttribute("userBean", userBean);
			System.out.println(userBean);
			
			
			response.sendRedirect("SchermataInserimentoCredenziali.jsp");
			
		}
}
