package it.beije.cilacap.restcontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.cilacap.web.rubrica.CSVTool;
import it.beije.cilacap.web.rubrica.DBtools;
import it.beije.cilacap.web.rubrica.Contatto;

@RestController
public class MyRubricaRestController {

	@RequestMapping(value = "/myrubrica", method = RequestMethod.GET)
	public @ResponseBody List<Contatto> getRubrica() throws ClassNotFoundException, SQLException {
		List<Contatto> contatti;
		//CSVTool csvTool = new CSVTool();
		//csvTool.ReaderCSV("C:/work/Prova.txt");
		
		DBtools dbtools = new DBtools();
		contatti = dbtools.leggiContatti();
		System.out.println(contatti);
		
		return contatti;
	}
}
