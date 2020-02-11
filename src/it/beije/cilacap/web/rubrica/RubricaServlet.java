package it.beije.cilacap.web.rubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.beije.cilacap.web.Contatto;

/**
 * Servlet implementation class RubricaServlet
 */
@WebServlet("/RubricaServlet")
public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RubricaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		Contatto nuovoContatto=new Contatto();
		nuovoContatto.setNome(request.getParameter("nome"));
		nuovoContatto.setCognome(request.getParameter("cognome"));		
		nuovoContatto.setTelefono(request.getParameter("telefono"));		
		nuovoContatto.setEmail(request.getParameter("email"));		
		
		System.out.println(nuovoContatto.toString());

		StringBuilder builder = new StringBuilder("<!DOCTYPE html><html><head><title>CILACAP</title></head>");
		builder.append("<body>").append("Il contatto: ").append(nuovoContatto.toString(0)).append(" <b> è stato aggiunto </b> <br> <a href=\"rubrica.jsp\"> Clicca qui per aggiungere nuovo contatto </a>").append("</body></html>");
		
		
		response.setContentType("text/html");
		response.getWriter().append(builder.toString());
	}

}
