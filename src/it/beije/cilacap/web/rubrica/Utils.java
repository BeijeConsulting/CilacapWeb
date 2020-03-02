package it.beije.cilacap.web.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Utils {
	Scanner input = new Scanner(System.in);
	
	public static List<String[]> getFileCsvContent(String csvSplitBy, String filepath) throws IOException{
		
		//Mi ritorna una lista di array contenenti le varie righe contatto del CSV
		
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
        List<String[]> list = new ArrayList<>();
        String line = "";
        while((line = reader.readLine()) != null){
            String[] array = line.split(csvSplitBy);
            list.add(array);
        }
        reader.close();
        return list;
        }
	public static void writeToCsvFile(List<String[]> thingsToWrite, String csvSplitBy, String fileName){
	//Riceve una lista di array da scrivere nel CSV.
    try (FileWriter writer = new FileWriter(fileName)){
        for (String[] strings : thingsToWrite) {
            for (int i = 0; i < strings.length; i++) {
                writer.append(strings[i]);
                if(i < (strings.length-1))
                    writer.append(csvSplitBy);
            }
            writer.append(System.lineSeparator());
        }
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public List<String[]> setContatto(String[]intestazioneFile, List<String[]> lc){
    // Riceve la stringa di come'è intestato il CSV in cui bisogna aggiungere il contatto e la lista dei contatti già presenti nel CSV a cui bisogna accodare i nuovi contatti.

    	String[]contatto= new String[5];
    	boolean again=true;
    	while(again) {
    		
    		for (int i=0;i<intestazioneFile.length;i++) {
    	
    		
    			if(intestazioneFile[i].equalsIgnoreCase("nome")) {
    			System.out.println("Inserisci nome del nuovo contatto:");
    			contatto[i]=input.nextLine();
    			}
    			else if(intestazioneFile[i].equalsIgnoreCase("cognome")) {
    				System.out.println("Inserisci cognome del nuovo contatto:");
    				contatto[i]=input.nextLine();
    			}
    			else if(intestazioneFile[i].equalsIgnoreCase("telefono")) {
    				System.out.println("Inserisci telefono del nuovo contatto:");
    				contatto[i]=input.nextLine();
    			}
    			else if(intestazioneFile[i].equalsIgnoreCase("indirizzo")) {
    				System.out.println("Inserisci indirizzo del nuovo contatto:");
    				contatto[i]=input.nextLine();
    			}
    			else if(intestazioneFile[i].equalsIgnoreCase("email")) {
    				System.out.println("Inserisci email del nuovo contatto:");
    				contatto[i]=input.nextLine();
    			}
    		
    		}
    		lc.add(contatto);
    		
    		System.out.println("Inserire un altro contatto? S/N");
    		if(input.next().equalsIgnoreCase("n"))
    			again=false;
    	}
    	input.close();
    	return lc;
    	}
	public static List<Contatto> getContattiFromFileXml(File file) throws Exception {
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
//        System.out.println(element.getTagName());
        
//        System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
//        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
//        	System.out.println(utente.getTagName() + " " + i);
//        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
       	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
       	    contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
//        	System.out.println("\tnome = " + contatto.getNome());
//        	System.out.println("\tcognome = " + contatto.getCognome());
//        	System.out.println("\ttelefono = " + contatto.getTelefono());
//        	System.out.println("\temail = " + contatto.getEmail());
//        	
        	listaContatti.add(contatto);
        }
        
        return listaContatti;
	}
	public static void writeContattiInFileXml(List<Contatto> contatti, String pathfile) throws Exception  {
	    	//Di Ivo
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
    public static List<Contatto> getContattiFromFileXml(String pathfile) throws Exception {
	    	//Di Ivo
			File file = new File(pathfile);
			
			return getContattiFromFileXml(file);
		}
	public static List<String[]> getCsvListFromXmlFile(List<Contatto> xmlList){
			List<String[]> csvList = new ArrayList<String[]>();
			String[]array= new String[4];
			for(int i=0;i<xmlList.size();i++) {
					array[0]=xmlList.get(i).getNome();
					array[1]=xmlList.get(i).getCognome();
					array[2]=xmlList.get(i).getTelefono();
					array[3]=xmlList.get(i).getEmail();
					csvList.add(i,array);		
			}
			return csvList;
			
			}
    public static List<Contatto> getXmlListFromCsvFile(String csvSplitBy, String filepath) throws IOException{
     List<String[]> ls= new ArrayList<>();	
     List<Contatto> lc= new ArrayList<Contatto>();
     ls= getFileCsvContent(csvSplitBy,filepath);
     String[]intestazione= new String[5];
     String[]array=new String[5];
     
     //controllo l'ordine dell'intestazione del csv così che se i campi fossero in un diverso ordine non imposto nel campo cognome della lista il nome magari.
    
     intestazione=ls.get(0);
    
     //Scorro la lista di array contenenti ognuno un contatto, parto dall'indice 1 siccome l'indice 0 contiene "nome cognome telefono email" 
    
     for(int i=1; i<ls.size();i++) {
     	array=ls.get(i);
     	//scorro l'array  che ho estratto dalla lista che corrisponde ad un cotatto e controllo il campo in base all'intestazione ed aggiungo alla lista contatto.
     	for(int j=0;j<array.length;j++) {
     	if(intestazione[j].equalsIgnoreCase("nome")) {
     		lc.get(i-1).setNome(array[j]);
     	}
     	else if(intestazione[j].equalsIgnoreCase("cognome")) {
     		lc.get(i-1).setCognome(array[j]);
     	}
     	else if(intestazione[j].equalsIgnoreCase("telefono")){
     		lc.get(i-1).setTelefono(array[j]);
     	}
     	else if(intestazione[j].equalsIgnoreCase("email")){
     		lc.get(i-1).setEmail(array[j]);
     	}
     		
     	}
     	}
     //A questo punto dovrei avere la mia lista contatto con tutti i contatti della lista del csv.
     return lc;
     }
    public static  void insertContattoJpa(Contatto contatto ) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapWeb");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Contatto inserito correttamente");
	}
    public static void leggiContattiJpa()throws ClassNotFoundException,SQLException{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		String jpql= "select c from Contatto as c";
		TypedQuery<Contatto> query=entityManager.createQuery(jpql,Contatto.class);
		List<Contatto> contatti= query.getResultList();
		System.out.println(contatti.size());
		for (Contatto contatto: contatti) {
			System.out.println("id :"+contatto.getId());
			System.out.println("nome : "+contatto.getNome());
			System.out.println("congnome : "+contatto.getCognome());
			System.out.println("telefono : "+contatto.getTelefono());
			System.out.println("email : "+contatto.getEmail());
			System.out.println(contatto.getClass());
			entityManager.close();
		}
	}
    public static void updateContattoJpa(Integer idContatto) {	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Scanner read=new Scanner(System.in);
		Contatto contatto = entityManager.find(Contatto.class, idContatto);
		System.out.println(contatto);
		System.out.println("Vuoi modificare il nome del contatto?S/N?");
		if(read.next().equalsIgnoreCase("s")) {
			System.out.println("inserisci il nuovo nome");
			String nome= read.next();
			entityManager.createQuery("update Contatto set nome ="+ nome + " where id="+idContatto).executeUpdate();
		}
		System.out.println("Vuoi modificare il cognome del contatto?S/N?");
		if(read.next().equalsIgnoreCase("s")) {
			System.out.println("inserisci il nuovo cognome");
			String cognome= read.next();
			entityManager.createQuery("update Contatto set cognome ="+ cognome + " where id="+idContatto).executeUpdate();
		}
		System.out.println("Vuoi modificare il telefono del contatto?S/N?");
		if(read.next().equalsIgnoreCase("s")) {
			System.out.println("inserisci il nuovo numero di telefono");
			String telefono= read.next();
			entityManager.createQuery("update Contatto set telefono =" + telefono + " where id=" + idContatto).executeUpdate();
		}
		System.out.println("Vuoi modificare la mail del contatto?S/N?");
		if(read.next().equalsIgnoreCase("s")) {
			System.out.println("inserisci la nuova mail");
			String mail=read.next();
			entityManager.createQuery("update Contatto set email = " + mail + " where id="+ idContatto).executeUpdate();
		}
		System.out.println("Confermate l'aggionramento del contatto?S/N?");
		if(read.next().equalsIgnoreCase("s")) {
			entityManager.getTransaction().commit();
			entityManager.close();
			read.close();
			System.out.println("Contatto aggiornato!!");
		}
		else {
			entityManager.getTransaction().rollback();
			entityManager.close();
			read.close();
			System.out.println("Aggiornamento contatto annullato!!");
		}
		}
	public static void deleteContattoJpa(Integer idContatto){
		Scanner read = new Scanner(System.in);
		String jpql= "delete from Contatto c where c.id= "+ idContatto;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Contatto contatto = entityManager.find(Contatto.class, idContatto);
		System.out.println(contatto);
		System.out.println("Sei sicuro di volere eliminare il contatto? S/N?");
		if(read.next().equalsIgnoreCase("s")) {
			entityManager.createQuery(jpql).executeUpdate();
			System.out.println("Contatto cancellato con successo");
			entityManager.getTransaction().commit();
			entityManager.close();
			read.close();
		}
	}
}


