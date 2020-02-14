package it.beije.cilacap.web.myrubrica.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.esercizi.myRubrica.Contatto2;
import it.beije.cilacap.esercizi.myRubrica.JpaRubricaUtils;

/**
 * Servlet implementation class SaveInDb
 */
@WebServlet("/SaveInDb")
public class SaveInDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveInDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		Contatto2 contatto = (Contatto2)request.getSession().getAttribute("contattoBean");
		if(contatto != null) {
			List<Contatto2> lista = new ArrayList<Contatto2>();
			lista.add(contatto);
			JpaRubricaUtils.writeJPAListOfContactsIntoDB(lista);
			response.sendRedirect("contattoJSP/conferma.jsp");
		} else {
			response.sendRedirect("contattoJSP/conferma.jsp");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		Contatto2 contatto = (Contatto2)request.getSession().getAttribute("contattoBean");
		if(contatto != null) {
			List<Contatto2> lista = new ArrayList<Contatto2>();
			lista.add(contatto);
			JpaRubricaUtils.writeJPAListOfContactsIntoDB(lista);
			response.sendRedirect("formContatto.jsp");
		}
		//doGet(request, response);
	}

}
