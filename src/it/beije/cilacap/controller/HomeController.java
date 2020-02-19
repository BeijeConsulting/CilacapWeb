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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.cilacap.web.rubrica.Contatto;


@Controller
public class HomeController {
	
	Contatto contatto = new Contatto();
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		return "index";
	}

	@RequestMapping(value = "/form", method = {RequestMethod.GET, RequestMethod.POST})
	public String form(Model model) {
		model.addAttribute("contatto", contatto);
		return "form";
	}

	@RequestMapping(value = "/vedicontatto", method = {RequestMethod.GET, RequestMethod.POST})
	public String vedi(@Validated Contatto contatto, Model model) {
		this.contatto = contatto;
		return "vedicontatto";
	}
	
	@RequestMapping(value = "/salvato", method = RequestMethod.GET)
	public String salva(@Validated Contatto contatto) {
		//salva il contatto in db (ParserJD.................)
		//contatto = new Contatto();
		return "salvato";
	}

}
