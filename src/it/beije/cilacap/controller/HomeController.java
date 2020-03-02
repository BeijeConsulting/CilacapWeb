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

import it.beije.cilacap.web.rubrica.Contatto;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		//System.out.println("index Page Requested : " + request.getRequestURI());
		return "formcontatto";
	}

	@RequestMapping(value = "/conferma", method = RequestMethod.GET)
	public String conferma(Model model, HttpSession session, HttpServletRequest request) {
		return "conferma";
	}

	@RequestMapping(value = "/verifica", method = RequestMethod.POST)
	public String vedi(Model model, HttpSession session, HttpServletRequest request, @Validated Contatto contatto) {
		System.out.println("nome : " + contatto.getNome());
		System.out.println("cognome : " + contatto.getCognome());
		System.out.println("telefono : " + contatto.getTelefono());
		System.out.println("email : " + contatto.getEmail());
		
		session.setAttribute("contatto", contatto);
		model.addAttribute("contatto", contatto);

		return "verifica";
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
