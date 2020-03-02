package it.beije.cilacap.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.beije.cilacap.web.rubrica.Contatto;
import it.beije.cilacap.web.rubrica.Utils;
@Controller
public class RubricaController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		Contatto contatto= (Contatto)session.getAttribute("contatto");
		model.addAttribute("contatto",contatto);
		return "index_delloste";
	}
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String verifica(Model model, HttpServletRequest request, @Validated Contatto contatto) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		model.addAttribute("contatto", contatto);
		request.getSession().setAttribute("contatto", contatto);
		return "confirm";
	}
	@RequestMapping(value = "/salva", method = RequestMethod.GET)
	public void salva(HttpServletRequest request, HttpServletResponse response, @Validated Contatto contatto) throws IOException {
		System.out.println("index Page Requested : " + request.getRequestURI());
		System.out.println("SALVO CONTATTO?");
		contatto = (Contatto)request.getSession().getAttribute("contatto");
		if (contatto.getNome()!=""&& contatto.getCognome()!="" && contatto.getNome()!=null && contatto.getCognome()!=null) {
//			Utils.insertContattoJpa(contatto);
			String messaggio= "CONTATTO SALVATO CORRETTAMENTE <br>";
			request.getSession().setAttribute("contatto",new Contatto());
			response.getWriter().append(messaggio + "<a href=\"index\">TORNA ALLA HOMEPAGE</a>");
		} else {
			response.sendRedirect("index\\");
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void cancella(Model model,HttpServletRequest request,@Validated int id, HttpSession session,HttpServletResponse response) throws IOException {
		System.out.println("index Page Requested : " + request.getRequestURI());
//		Utils.deleteContattoJpa(id);
		String messaggio= "CONTATTO ELIMINATO CORRETTAMENTE <br>";
		response.getWriter().append(messaggio + "<a href=\"index\">TORNA ALLA HOMEPAGE</a>");
	}

}
