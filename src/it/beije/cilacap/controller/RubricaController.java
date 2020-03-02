package it.beije.cilacap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.cilacap.web.rubrica.Contatto;

@Controller
@SessionScope
public class RubricaController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ciao(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		return "home";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String form(Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		Contatto contatto = (Contatto)session.getAttribute("contatto");
		
		model.addAttribute("contatto",contatto);
		
		
		return "formcontatto";
	}
	
	@RequestMapping(value = "/verifica", method = RequestMethod.POST)
	public String verifica(Model model, HttpServletRequest request, HttpSession session, @Validated Contatto contatto) {
		System.out.println("index Page Requested : " + request.getRequestURI());
		
		model.addAttribute("contatto",contatto);
		session.setAttribute("contatto", contatto);

		return "verifica";
	}
	

	@RequestMapping(value = "/salva", method = RequestMethod.GET)
	public String salva(Model model, HttpServletRequest request, HttpSession session) {
		
		Contatto contatto = (Contatto)session.getAttribute("contatto");
		model.addAttribute("contatto",contatto);
//		
		session.setAttribute("contatto", new Contatto());
		
		return "conferma";
	}
}
