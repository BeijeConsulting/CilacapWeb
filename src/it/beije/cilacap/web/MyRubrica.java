package it.beije.cilacap.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.cilacap.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyRubrica")
public class MyRubrica extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	

    public MyRubrica() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//doGet(request, response);
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		Contatto contatto = new Contatto();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		
		request.getSession().setAttribute("contacts", contatto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/beanData.jsp");
        rd.forward(request, response);
		
		
	}
}
