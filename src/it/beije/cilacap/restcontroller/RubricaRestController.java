package it.beije.cilacap.restcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import it.beije.cilacap.esercizi.myRubrica.*;

import it.beije.cilacap.web.rubrica.Contatto;

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
	
	/* Read from DB */
	@RequestMapping(value = "/rubricaDB", method = RequestMethod.GET)
	public @ResponseBody List<Contatto2> getRubricaFromDB() throws ClassNotFoundException, SQLException {
		List<Contatto2> contatti = DBtools.leggiContatti();
		return contatti;
	}
	
	
	/* Read from XML */
	@RequestMapping(value = "/rubricaXML", method = RequestMethod.GET)
	public @ResponseBody List<Contatto2> getRubricaFromXML() throws ParserConfigurationException, SAXException, IOException {
		List<Contatto2> contatti = MyRubrica.caricaArrayListDiContattiFromXML("C:\\Users\\Padawan04\\Desktop\\LaMiaRubrica.xml");
		return contatti;
	}

	/* Read from CSV */
	@RequestMapping(value = "/rubricaCSV", method = RequestMethod.GET)
	public @ResponseBody List<Contatto2> getRubricaFromCSV() throws ParserConfigurationException, SAXException, IOException {
		List<Contatto2> contatti = MyRubrica.caricaArrayListDiContattiFromCSV("C:\\Users\\Padawan04\\Desktop\\LaMiaRubrica.csv");
		return contatti;
	}
}
