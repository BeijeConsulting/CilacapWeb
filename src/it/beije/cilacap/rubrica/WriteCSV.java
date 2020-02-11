package it.beije.cilacap.rubrica;
import it.beije.cilacap.rubrica.ContattoWeb;

import java.util.ArrayList;
import java.util.List;




public class WriteCSV {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String separatore=";";
		ContattoWeb rubrica=new ContattoWeb();
		MetodiCSV csv=new MetodiCSV();
		List <ContattoWeb> contatto=new ArrayList<>();
        contatto=csv.scheletroCsv();
        csv.scrivisuFile(contatto, separatore);
//		rubrica.settoFile();
//		rubrica.fileXML();
//		rubrica.leggiconHibernate();
//		rubrica.scriviconHibernate(contatto);	
//		rubrica.scriviXml();

	}
}


		
		
	
		
	




