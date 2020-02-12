package it.beije.cilacap.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.Utils;

@WebServlet("/addContatto")
public class addContatto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Contatto c =(Contatto)request.getSession().getAttribute("contatto");
		
		Utils.insertContattoJpa(c);
		
		request.getSession().setAttribute("contatto",null);
		response.getWriter().append("<a href=\"index_delloste.jsp\">TORNA ALLA HOMEPAGE</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
