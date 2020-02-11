package it.beije.cilacap.rubrica;
import it.beije.cilacap.rubrica.ParserXML;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

//import it.beije.cilacap.esercizi.TextFileManager;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;



public class ContattoWeb extends MetodiCSV {


	private Integer id;
	

	private String nome;


	private String cognome;


	private String telefono;


	private String email;


	public ContattoWeb() {

	}
	public ContattoWeb(String c, String n, String t, String e) {
		this.nome=n;
		this.cognome=c;
		this.telefono=t;
		this.email=e;
	}

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;

	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id : ").append(id).append('\n');
		builder.append("cognome : ").append(cognome).append('\n');
		builder.append("nome : ").append(nome).append('\n');
		builder.append("telefono : ").append(telefono).append('\n');
		builder.append("email : ").append(email).append('\n');
		return builder.toString();
	}
	
	
	public  void fileXML() throws Exception{

		ContattoWeb c=new ContattoWeb();
		List<ContattoWeb> lista= c.scheletroCsv();
		ParserXML.writeContattiInFile(lista,"C:\\Users\\Padawan05\\Desktop\\Esercizio\\rubrica.xml" );


	}
    //creo un file xml scrivendoci sopra la lista che ho creato nel metodo sopra
	public  List<ContattoWeb> scriviXml()throws Exception{
		File mioFile=new File("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
		List<ContattoWeb> lista=new ArrayList<ContattoWeb>();
		lista=ParserXML.getContattiFromFile("C:\\Users\\Padawan05\\Desktop\\Esercizio\\rubrica.xml");
//		try {
		ContattoWeb c=new ContattoWeb();
		c.settoFile(lista);
		
//		}catch(SAXParseException e) {
//			System.out.println("a");
//		}
		return lista;
	}
	
	
	//converto il file xml creato in precedenza in un csv
	public void CSVtoXML() throws Exception {
		String s=";";
		ContattoWeb c =new ContattoWeb();
		ParserXML parser=new ParserXML();
		List<ContattoWeb> lista=new ArrayList<>();
		lista=parser.getContattiFromFile("C:\\Users\\Padawan05\\Desktop\\Esercizio\\rubrica.xml");
		c.scrivisuFile(lista, s);
		
	}
	
	
	
	
	
public static List<ContattoWeb> dammiContattoDaFile(File file) throws Exception {
		
		List<ContattoWeb> listaContatti = new ArrayList<ContattoWeb>();
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	System.out.println(utente.getTagName() + " " + i);
        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	ContattoWeb contatto = new ContattoWeb();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
        	System.out.println("\tnome = " + contatto.getNome());
        	System.out.println("\tcognome = " + contatto.getCognome());
        	System.out.println("\ttelefono = " + contatto.getTelefono());
        	System.out.println("\temail = " + contatto.getEmail());
        	
        	listaContatti.add(contatto);
        }
		}catch(Exception e) {
			System.out.println("a");
		}
        
	
        
        return listaContatti;



	

}
}


