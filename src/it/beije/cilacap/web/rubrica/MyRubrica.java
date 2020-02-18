package it.beije.cilacap.web.rubrica;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyRubrica {
	
	@RequestMapping(value = "/MyRubrica", method = RequestMethod.POST)
	public String Rubrica(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		String nome = "Pippo";
		
		model.addAttribute("nome", nome);
		model.addAttribute("cognome", nome);
		model.addAttribute("telefono", nome);
		model.addAttribute("email", nome);

		return "MyRubrica";
	}

}
