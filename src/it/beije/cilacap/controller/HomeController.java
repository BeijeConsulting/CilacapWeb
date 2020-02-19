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
import org.springframework.web.bind.annotation.RequestPart;

import it.beije.cilacap.web.rubrica.Contatto;


@Controller
public class HomeController {
	Contatto contatto = new Contatto();
/*	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "index";
	}*/

/*	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index() {

		return "index";
	}*/
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) // index è una parola chiave prende quello che indichi nel name="prefix" value="/WEB-INF/views/"
	public String index(HttpServletRequest request,Model model,@Validated Contatto contatto) {
		
		model.addAttribute("contatto",contatto);
		return "formcontatto";
	}


	@RequestMapping(value = "/anto", method = RequestMethod.POST)
	public String homepage(Model model, HttpServletRequest request, HttpServletResponse response,@Validated Contatto contatto) {

		
		this.contatto=contatto;
		System.out.println(this.contatto.getNome());
		
		return "visualizza";
	}
	
	@RequestMapping(value = "/riconferma", method = RequestMethod.GET)
	public String riconferma(Model model, HttpServletRequest request, HttpServletResponse response, @Validated Contatto contatto) {

		
		
		return "riconferma";
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
