package it.beije.cilacap.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.cilacap.web.rubrica.Contatto;

@Controller
public class RubricaController {
		
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		return "index";
	}

	@RequestMapping(value = "/formcontatto", method = RequestMethod.GET)
	public String form(Model model, HttpServletRequest request, Contatto c) {
		c = (Contatto)request.getSession().getAttribute("contatto");
		if(c!=null) {
        model.addAttribute(c);
		}
		return "formcontatto";
		
	}
	
	@RequestMapping(value = "/formcontatto", method = RequestMethod.POST)
	public String formpost(Model model, HttpServletRequest request, Contatto c  ) {
		
		c = (Contatto)request.getSession().getAttribute("contatto");
		if(c!=null) {
        model.addAttribute(c);
		}
//		if (Miocontatto.getNome() != null) {
//			model.addAttribute("Nome", Miocontatto.getNome())
		
		
	//}

		return "formcontatto";
	}

	@RequestMapping(value = "/see", method = RequestMethod.POST)
	public String vedi(Model model, HttpServletRequest request, @RequestParam(name = "nome", required = false) String nome,@Validated Contatto contatto) {
		contatto=(Contatto)request.getSession().getAttribute("contatto");
		

		
//		System.out.println("nome : " + contatto.getNome());
//		System.out.println("cognome : " + contatto.getCognome());
//		System.out.println("telefono : " + contatto.getTelefono());
//		System.out.println("email : " + contatto.getEmail());


		//....

		model.addAttribute("Contatto", contatto);


		return "see";
	}

	@RequestMapping(value = "/vediContatto", method = RequestMethod.GET )
	public String vedi(Model model, HttpServletRequest request, HttpServletResponse response, @Validated Contatto contatto) throws IOException {

		
		
		contatto = (Contatto)request.getSession().getAttribute("contatto");
		
		if (contatto != null) {
			System.out.println("procedo con salvataggio...");
			
//			response.sendRedirect("./rubrica/conferma.jsp");
//		} else {
//			response.sendRedirect("./rubrica/formcontatto.jsp");
//		}
		
	}
		return "vediContatto";
	}
	
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Home Page Requested, country = " + locale.getCountry());
		System.out.println("Home Page Requested, language = " + locale.getLanguage());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String dataFormattato = dateFormat.format(date);
		model.addAttribute("locale", locale);
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("language", locale.getLanguage());
		model.addAttribute("serverTime", dataFormattato);
		return "home";
	}
	@RequestMapping(value = "/txt", method = RequestMethod.GET)
	public void returnTXT(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.getWriter().append("CIAO");
	}
}
