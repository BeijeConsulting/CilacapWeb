package it.beije.cilacap.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("nome");
		String surname = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		System.out.println("Nome : " + name);
		System.out.println("Cognome : " + surname);
		System.out.println("Telefono: " +telefono);
		System.out.println("Email: " +email);
		
//		if (name != null && name.equals(name)
//			&& surname != null && surname.equals(surname)) { //FAKE LOGIN
//			User user = new User();
//			user.setUsername(name);
//			user.setFirstName("Pippo");
//			user.setLastName("Fox");
//			user.setId(1);
//
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
//		}
		
		response.sendRedirect("miaConferma.jsp");
	}

}
