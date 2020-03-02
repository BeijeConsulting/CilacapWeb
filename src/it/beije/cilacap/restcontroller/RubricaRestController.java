package it.beije.cilacap.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.cilacap.web.rubrica.Contatto;

@RestController
public class RubricaRestController {

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubrica() {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Contatto contatto1 = new Contatto();
		//contatto1.setId(1);
		contatto1.setNome("Mario");
		contatto1.setCognome("Rossi");
		contatto1.setTelefono("001202022");
		contatto1.setNome("m.rossi@beije.it");
		
		Contatto contatto2 = new Contatto();
		//contatto1.setId(2);
		contatto2.setNome("Carlo");
		contatto2.setCognome("Bianchi");
		contatto2.setTelefono("421412412");
		contatto2.setNome("c.bianchi@beije.it");
		
		contatti.add(contatto1);
		contatti.add(contatto2);
		
		return contatti;
	}
	
	@RequestMapping(value = "/rubrica/{id}", method = RequestMethod.GET)
	public @ResponseBody Contatto getContatto(@PathVariable Integer id, HttpServletResponse response) {
		
		if (id > 10) {
			response.setStatus(204);
			return null;
		}

		Contatto contatto = new Contatto();
		contatto.setId(id);
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("001202022");
		contatto.setNome("m.rossi@beije.it");
		
		return contatto;
	}
	
	@RequestMapping(value = "/rubrica", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contatto createContatto(@RequestBody Contatto contatto, HttpServletResponse response) {
		//inserisco contatto in DB, XML, CSV...
		
		contatto.setId(10);
		
		return contatto;
	}

}
