package it.beije.cilacap.restcontroller.myRestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.cilacap.esercizi.myRubrica.Contatto2;
import it.beije.cilacap.esercizi.myRubrica.HibernateRubricaUtil;
import it.beije.cilacap.web.rubrica.Contatto;

@RestController
public class MyRubricaRestController {

//	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
//	public @ResponseBody List<Contatto> getRubrica() {
//		List<Contatto> contatti = new ArrayList<Contatto>();
//		
//		Contatto contatto1 = new Contatto();
//		contatto1.setNome("Mario");
//		contatto1.setCognome("Rossi");
//		contatto1.setTelefono("001202022");
//		contatto1.setNome("m.rossi@beije.it");
//		
//		Contatto contatto2 = new Contatto();
//		contatto2.setNome("Carlo");
//		contatto2.setCognome("Bianchi");
//		contatto2.setTelefono("421412412");
//		contatto2.setNome("c.bianchi@beije.it");
//		
//		contatti.add(contatto1);
//		contatti.add(contatto2);
//		
//		return contatti;
//	}
	
//	/* Read from DB */
//	@RequestMapping(value = "/rubricaDB", method = RequestMethod.GET)
//	public @ResponseBody List<Contatto2> getRubricaFromDB() {
//		List<Contatto2> contatti = HibernateRubricaUtil.readListOfContactsFromDB();
//		return contatti;
//	}
	
}
