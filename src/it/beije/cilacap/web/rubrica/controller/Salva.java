package it.beije.cilacap.web.rubrica.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.cilacap.web.rubrica.JpaMethods;
import it.beije.cilacap.web.rubrica.model.Contatto;

/**
 * Servlet implementation class Salva
 */
@WebServlet("/Salva")
public class Salva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SALVO CONTATTO?");

		Contatto contatto = (Contatto)request.getSession().getAttribute("contatto");
		List<Contatto> listaContatti=new ArrayList<Contatto>();
		listaContatti.add(contatto);
		try {
			JpaMethods.inserisciContatti(listaContatti);
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if (contatto != null) {
			System.out.println("procedo con salvataggio...");

			response.sendRedirect("./rubrica/conferma.jsp");
		} else {
			response.sendRedirect("./rubrica/");
		}
	}

}
