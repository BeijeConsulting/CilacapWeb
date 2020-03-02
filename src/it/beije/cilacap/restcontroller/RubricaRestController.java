package it.beije.cilacap.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
			contatti.addAll(ParserJPDB.getContattiFromJPDB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contatti;
	}
}
