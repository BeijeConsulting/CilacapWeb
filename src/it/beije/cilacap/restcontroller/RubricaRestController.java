package it.beije.cilacap.restcontroller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import it.beije.cilacap.utils.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import static it.beije.cilacap.utils.ParserXML.*;
import static it.beije.cilacap.utils.Metodi.*;

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
	
	@RequestMapping(value = "/rubricamia", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubricamia() throws Exception {
		List<Contatto> contatti = new ArrayList<Contatto>();
		List<Contatto> contatti2 = new ArrayList<Contatto>();
		List<Contatto> listcontatti = new ArrayList<Contatto>();
		File f = new File("C:/Work/prova.csv");
		File f2 = new File("C:/Work/prova.xml");
		contatti=getContattiFromFile(f2);
		contatti2=generaLista(f);
		listcontatti.addAll(contatti);
		listcontatti.addAll(contatti2);
		
		return listcontatti;
	}
	
}
