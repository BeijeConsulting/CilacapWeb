package it.beije.cilacap.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.cilacap.web.rubrica.Contatto;
import it.beije.cilacap.web.util.MyRubricaCSV_XML_DB_Hibernate;
import it.beije.cilacap.web.util.MyRubricaCSV_XML_DB_JPA;

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

	@RequestMapping(value = "/rubricajpa", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubricaJPA() {

		List<Contatto> listaContatti = MyRubricaCSV_XML_DB_JPA.leggiContatti();
		return listaContatti;
	}

	@RequestMapping(value = "/rubricahibernate", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubricaHibernate() {
		List<Contatto> listaContatti = MyRubricaCSV_XML_DB_Hibernate.leggiContatti();
		return listaContatti;
	}

}
