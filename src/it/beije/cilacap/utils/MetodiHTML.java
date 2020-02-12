package it.beije.cilacap.utils;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;







public class MetodiHTML {
	
	public static List<String> generaLista(List<Contatto> listaContatti) throws IOException
	{
		int i=0;
		List<String> listaStringa=new ArrayList<String>();
		for(i=0;i<listaContatti.size();i++)
		{
			listaStringa.add(toCSV(listaContatti.get(i)));
			
		}
		return listaStringa;
		
		
	}
	public static List<Contatto> generaLista(File f) throws IOException
	{
		int i;
		List<String> listStringa = new ArrayList<>();
		List<Contatto> listaContatti = new ArrayList<>();
		listStringa.addAll(readFileRows(f));
		
		for(i=0;i<listStringa.size();i++)
		{
			Contatto contatto = new Contatto();
			
			contatto.setCognome(listStringa.get(i).split(";")[0]);
			contatto.setNome(listStringa.get(i).split(";")[1]);
			contatto.setTelefono(listStringa.get(i).split(";")[2]);
			contatto.setEmail(listStringa.get(i).split(";")[3]);
			listaContatti.add(contatto);
		}
		
		
		
		return listaContatti;	
	}
	public static String toCSV(Contatto contatto)
	{
		
		String stringa="";
		stringa += contatto.getCognome()+";"+contatto.getNome()+";"+contatto.getTelefono()+";"+contatto.getEmail()+"<br>";
		return stringa;
	}
	public static void toXML(File f) throws Exception
	{
		int i=0;
		List<String> listStringa = new ArrayList<>();
		List<Contatto> listaContatti = new ArrayList<>();
		listStringa.addAll(readFileRows(f));
		
		for(i=0;i<listStringa.size();i++)
		{
			Contatto contatto = new Contatto();
			
			contatto.setCognome(listStringa.get(i).split(";")[0]);
			contatto.setNome(listStringa.get(i).split(";")[1]);
			contatto.setTelefono(listStringa.get(i).split(";")[2]);
			contatto.setEmail(listStringa.get(i).split(";")[3]);
			listaContatti.add(contatto);
			
			
		}
		
		writeContattiInFile(listaContatti, "c:/work/prova.xml");
	}
	public static void writeFileContent(List<String> contentRows, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
				
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (String row : contentRows) {
			bufferedWriter.append(row).append('\n');
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	
	public static String readFileContent(File file) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		FileReader fileReader = new FileReader(file);

		int c;
		while ((c = fileReader.read()) > -1) {
			//System.out.print((char)c);
			builder.append((char)c);
		}
		
		fileReader.close();
		
		//IM 20200122 : approccio alternativo, utilizzo il metodo readFileRows e unisco nuovamente le righe
//		List<String> rows = readFileRows(file);
//		for (int r = 0; r < rows.size(); r++) {
//			builder.append(rows.get(r));
//			if (r < rows.size()-1) builder.append('\n');
//		}
		
		return builder.toString();
	}
	
	
	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
			rows.add(row);
		}
		
		System.out.println("rows size : " + rows.size());
		return rows;
	}
	
	
	
	public static void writeFileContent(String content, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		
		fileWriter.write(content );
		
		
		fileWriter.flush();
		fileWriter.close();
	}
	
	public static List<Contatto> getContattiFromFile(String pathfile) throws Exception {
		File file = new File(pathfile);
		
		return getContattiFromFile(file);
	}

	public static List<Contatto> getContattiFromFile(File file) throws Exception {
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        System.out.println(element.getChildNodes().getLength());
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
        	
        	Contatto contatto = new Contatto();
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
        
        return listaContatti;
	}
	
	public static void writeContattiInFile(List<Contatto> contatti, String pathfile) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element docElement = document.createElement("rubrica");
        document.appendChild(docElement);
        
        for (Contatto c : contatti) {
        	Element contatto = document.createElement("contatto");
        	Element nome = document.createElement("nome");
        	Element cognome = document.createElement("cognome");
        	Element telefono = document.createElement("telefono");
        	Element email = document.createElement("email");
        	
        	nome.setTextContent(c.getNome());
        	cognome.setTextContent(c.getCognome());
        	telefono.setTextContent(c.getTelefono());
        	email.setTextContent(c.getEmail());
        	
        	contatto.appendChild(nome);
        	contatto.appendChild(cognome);
        	contatto.appendChild(telefono);
        	contatto.appendChild(email);

        	docElement.appendChild(contatto);
        }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathfile));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}
}
