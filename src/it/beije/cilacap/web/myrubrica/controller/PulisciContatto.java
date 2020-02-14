package it.beije.cilacap.web.myrubrica.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.esercizi.myRubrica.Contatto2;

/**
 * Servlet implementation class PulisciContatto
 */
@WebServlet("/PulisciContatto")
public class PulisciContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PulisciContatto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto2 contatto = (Contatto2)request.getSession().getAttribute("contattoBean");
		if (contatto != null) {
			request.getSession().removeAttribute("contattoBean");
		}
		response.sendRedirect("contattoJSP/formContatto.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
