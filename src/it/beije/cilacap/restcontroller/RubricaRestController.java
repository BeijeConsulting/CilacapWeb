package it.beije.cilacap.restcontroller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.cilacap.web.rubrica.Contatto;
import it.beije.cilacap.web.rubrica.Utils;

@RestController
public class RubricaRestController {

	@RequestMapping(value = "/rubrica", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubrica() {
		List<Contatto> contatti = new ArrayList<Contatto>();
	
		try {
			contatti= Utils.getContattiFromFileXml("C:\\Users\\Padawan07\\git\\Cilacap\\xml\\ExtractDatabase.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return contatti;
	}
}
