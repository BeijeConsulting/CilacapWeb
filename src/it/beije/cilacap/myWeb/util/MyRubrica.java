package it.beije.cilacap.myWeb.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyRubrica {

	// Leggo file XML e carico in lista ci Contatto
	public static List<ContattoWeb> caricaArrayListDiContattiFromXML(String pathXML) throws ParserConfigurationException, SAXException, IOException {

		List<ContattoWeb> listaContatti = new ArrayList<ContattoWeb>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		File fileXML = new File(pathXML);

		if(fileXML.length() == 0) {

		} else {

			Document document = builder.parse(fileXML);
			Element element = document.getDocumentElement();       
			System.out.println(element.getTagName());

			NodeList contatti = element.getElementsByTagName("contatto");

			for (int i = 0; i < contatti.getLength(); i++) {
				Element utente = (Element)contatti.item(i);

				Element nome = (Element)utente.getElementsByTagName("nome").item(0);
				Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
				Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
				Element email = (Element)utente.getElementsByTagName("email").item(0);

				ContattoWeb contatto = new ContattoWeb();
				contatto.setNome(nome.getTextContent());
				contatto.setCognome(cognome.getTextContent());
				contatto.setTelefono(telefono.getTextContent());
				contatto.setEmail(email.getTextContent());

				listaContatti.add(contatto);
			}
		}

		return listaContatti;
	}


	// Leggo file csv e carico in lista ci Contatto
	public static List<ContattoWeb> caricaArrayListDiContattiFromCSV(String filePath) throws IOException {

		List<ContattoWeb> listaContatti = new ArrayList<ContattoWeb>();

		File file = new File(filePath);
		List<String> rows = TextFileManager.readFileRows(file);

		for (int r = 1; r < rows.size(); r++) {
			String [] array = rows.get(r).split(";");
			ContattoWeb contatto = new ContattoWeb();
			for(int i = 0; i < array.length; i++) {
				contatto.setCognome(array[0]);
				contatto.setNome(array[1]);
				contatto.setTelefono(array[2]);
				contatto.setEmail(array[3]);
			}
			listaContatti.add(contatto);
		}
		//System.out.println("Ho caricato nella lista tutti i contatti prelevati dal file .csv!!!");
		return listaContatti;
	}

	

//	public static void readXMLwriteCSV(String pathCVS, String pathXML) throws SAXException, IOException, ParserConfigurationException {
//		List<Contatto2> listaContatti = new ArrayList<Contatto2>();
//
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//
//		File fileXML = new File(pathXML);
//
//		// Load the input XML document, parse it and return an instance of the
//		// Document class.
//		Document document = builder.parse(fileXML);
//		Element element = document.getDocumentElement();       
//		System.out.println(element.getTagName());
//
//		//System.out.println(element.getChildNodes().getLength());
//		NodeList contatti = element.getElementsByTagName("contatto");
//
//		for (int i = 0; i < contatti.getLength(); i++) {
//			Element utente = (Element)contatti.item(i);
//
//			Element nome = (Element)utente.getElementsByTagName("nome").item(0);
//			Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
//			Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
//			Element email = (Element)utente.getElementsByTagName("email").item(0);
//
//			Contatto2 contatto = new Contatto2();
//			contatto.setNome(nome.getTextContent());
//			contatto.setCognome(cognome.getTextContent());
//			contatto.setTelefono(telefono.getTextContent());
//			contatto.setEmail(email.getTextContent());
//
//			listaContatti.add(contatto);
//		}
//
//		insertNewContattiOnFileCSV(pathCVS, listaContatti);
//
//		System.out.println("File XML saved in CSV format!!!");
//	}
//
//	public static void readCSVwriteXML(String pathCSV, String pathXML) throws IOException, ParserConfigurationException, TransformerException {
//
//		// leggo CSV e carico contatti in una lista di Contatto
//		List<Contatto2> listaContatti = caricaArrayListDiContattiFromCSV(pathCSV);
//
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//
//		Document document = builder.newDocument();
//		Element docElement = document.createElement("rubrica");
//		document.appendChild(docElement);
//
//		for (Contatto2 c : listaContatti) {
//			Element contatto = document.createElement("contatto");
//			Element nome = document.createElement("nome");
//			Element cognome = document.createElement("cognome");
//			Element telefono = document.createElement("telefono");
//			Element email = document.createElement("email");
//
//			nome.setTextContent(c.getNome());
//			cognome.setTextContent(c.getCognome());
//			telefono.setTextContent(c.getTelefono());
//			email.setTextContent(c.getEmail());
//
//			contatto.appendChild(nome);
//			contatto.appendChild(cognome);
//			contatto.appendChild(telefono);
//			contatto.appendChild(email);
//
//			docElement.appendChild(contatto);
//		}
//
//		// write the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(document);
//		StreamResult result = new StreamResult(new File(pathXML));
//
//		// Output to console for testing
//		//StreamResult result = new StreamResult(System.out);
//
//		transformer.transform(source, result);
//
//		System.out.println("File CSV saved in XML format!!!");
//	}


//	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
//
//		String pathCSV = "C:\\Users\\Padawan04\\Desktop\\LaMiaRubrica.csv";
//		String pathXML = "C:\\Users\\Padawan04\\Desktop\\LaMiaRubrica.xml";
//
//		List<Contatto2> listaContatti;
//
//		// nuovi contatti nella lista
//		listaContatti = insertNewContatti();
//
//		// inserisco i contatti nel file CSV
////		updateConattiOnFileCSV(pathCSV, listaContatti);
//
//		// inserisco i contatti nel file XML
//		updateConattiOnFileXML(pathXML, listaContatti);
//
//		// carico la lista con i contatti letti da CSV
////		if(listaContatti.size() == 0) {
////			listaContatti = caricaArrayListDiContattiFromCSV(pathCSV);
////		} else {
////			listaContatti.addAll(caricaArrayListDiContattiFromCSV(pathCSV));
////		}
//		
//		// carico la lista con i contatti letti da XML
//		if(listaContatti.size() == 0) {
//			listaContatti = caricaArrayListDiContattiFromXML(pathXML);
//		} else {
//			listaContatti.addAll(caricaArrayListDiContattiFromXML(pathXML));
//		}
//
//		// leggo CSV e scrivo un XML
////		readCSVwriteXML(pathCSV, pathXML);
//
//		// leggo XML e scrivo in CSV
//		readXMLwriteCSV(pathCSV, pathXML);
//
//		System.gc();
//		System.out.println("Bye bye!!!");
//
//
//	}

}
