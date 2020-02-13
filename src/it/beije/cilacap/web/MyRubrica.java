package it.beije.cilacap.web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.beije.cilacap.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

//Qui farò le elaborazione.
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
		Contatto contatto = (Contatto)request.getSession().getAttribute("contattoBean");
		System.out.println("Procedo con salvataggio...");
		JPDBtools.insertInJPADB(contatto);
		response.sendRedirect("MyRubrica.jsp");
		
	}
}
