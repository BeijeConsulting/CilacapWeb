package it.beije.cilacap.restcontroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.cilacap.web.ParserCSV;
import it.beije.cilacap.web.rubrica.JpaMethods;
import it.beije.cilacap.web.rubrica.model.Contatto;

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
	
	@RequestMapping(value="/rubricaCSV/{file}", method=RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubricaCSV(@PathVariable String file) throws IOException{
		File file1=new File("C:\\Users\\Padawan14\\git\\CilacapWeb\\csv\\"+file+".csv");
		List<Contatto> contatti= ParserCSV.loadContactListFromCSV(file1);
		
		
		
		
		return contatti;
	}
	
	@RequestMapping (value="/rubricaDB", method=RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubricaDB(){
		List <Contatto> listaContatti= JpaMethods.leggiContatti();
		return listaContatti;
		
	}
	
	@RequestMapping(value="/rubricaDB/{id}", method=RequestMethod.GET)
	public @ResponseBody Contatto getContattoDaDB(@PathVariable int id, HttpServletResponse response) {
		
		Contatto c =  JpaMethods.getContatto(id);
		if(c==null) 
			response.setStatus(204);	
		
		return (Contatto) c;
		
	}
	
	
// fatto da ivo:
//	@RequestMapping(value = "/rubrica/{id}", method = RequestMethod.GET)
//	public @ResponseBody Contatto getContatto(@PathVariable Integer id, HttpServletResponse response) {
//		
//		if (id > 10) {
//			response.setStatus(204);
//			return null;
//		}
//
//		Contatto contatto = new Contatto();
//		contatto.setId(id);
//		contatto.setNome("Mario");
//		contatto.setCognome("Rossi");
//		contatto.setTelefono("001202022");
//		contatto.setNome("m.rossi@beije.it");
//		
//		return contatto;
//	}
//	
	@RequestMapping(value = "/rubrica", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contatto createContatto(@RequestBody Contatto contatto, HttpServletResponse response) {
		//inserisco contatto in DB, XML, CSV...
		
		
		Integer  id= JpaMethods.insertContatto(contatto);
//		contatto.setId(10);
		contatto.setId(id);
		return contatto;
	}


}
