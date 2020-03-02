package it.beije.cilacap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.cilacap.service.RubricaService;
import it.beije.cilacap.web.rubrica.Contatto;


@Controller
public class RubricaController {
	
	@Autowired
	private RubricaService rubricaService;
	

	@RequestMapping(value = "/cercacontatto", method = RequestMethod.GET)
	public String cercacontatto() {

		return "cercacontatto";
	}

	@RequestMapping(value = "/vedicontatto", method = RequestMethod.POST)
	public String cercacontatto(@RequestParam(name="id", required = false) Long id, Model model) {
		System.out.println("id: " + id);
		
		if (id == null) {
			model.addAttribute("errorMessage", "E' OBBLIGATORIO INSERIRE UN ID CONTATTO");
			return "cercacontatto";
		}

		Contatto contatto = rubricaService.findContatto(id);
		
		model.addAttribute("contatto", contatto);

		return "vedicontatto";
	}


}
