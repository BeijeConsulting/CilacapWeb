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

import it.beije.cilacap.ParserJPDB;
import it.beije.cilacap.ParserXML;
import it.beije.cilacap.web.rubrica.Contatto;

@RestController
public class RubricaRestController {
	
	public static final String PATH = "C:\\Users\\Padawan09\\git\\CilacapWeb\\src\\it\\beije\\cilacap\\Rubrica.xml";

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubrica() {
		List<Contatto> contatti = new ArrayList<Contatto>();
		try {
			contatti.addAll(ParserXML.getContattiFromFile(PATH));
//			contatti.addAll(ParserJPDB.getContattiFromJPDB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		List<Contatto> c = new ArrayList<Contatto>();
		c.add(contatto);
		try {
			ParserXML.writeContattiInFile(c, PATH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contatto;
	}

}
