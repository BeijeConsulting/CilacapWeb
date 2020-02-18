package it.beije.cilacap.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		System.out.println("index Page Requested : " + request.getRequestURI());

		return "index";
	}

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Home Page Requested, country = " + locale.getCountry());
		System.out.println("Home Page Requested, language = " + locale.getLanguage());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String dataFormattato = dateFormat.format(date);

		model.addAttribute("serverTime", dataFormattato); //Attributo aggiunto. D'ora in poi potrò usare questa variabile nel jsp
		model.addAttribute("locale", locale);
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("language", locale.getLanguage());
		model.addAttribute("serverTime", dataFormattato);

		return "home";
	}

	@RequestMapping(value = "/txt", method = RequestMethod.GET)
	public void returnTXT(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.getWriter().append("Cyka Blyat");
	}

}
