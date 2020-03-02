package it.beije.cilacap.restcontroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
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
		contatto1.setNome("Mario");
		contatto1.setCognome("Rossi");
		contatto1.setTelefono("001202022");
		contatto1.setNome("m.rossi@beije.it");
		
		Contatto contatto2 = new Contatto();
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
	
}
