package it.beije.cilacap.rubrica;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


//import it.beije.cilacap.esercizi.TextFileManager;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class DBtools {

	//leggo i vari contatti dal DB
	public static List<ContattoWeb> leggiContatti() throws ClassNotFoundException, SQLException {  //leggo i contatti dal db.
		List<ContattoWeb> contatti = new ArrayList<ContattoWeb>();
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica");
			
			ContattoWeb contatto = null;
			while (rs.next()) {
				contatto = new ContattoWeb();
				contatto.setId(rs.getInt("id"));
	        	contatto.setNome(rs.getString("nome"));
	        	contatto.setCognome(rs.getString("cognome"));
	        	contatto.setTelefono(rs.getString("telefono"));
	        	contatto.setEmail(rs.getString("email"));
	        	
	        	System.out.println("id = " + contatto.getId());
	        	System.out.println("nome = " + contatto.getNome());
	        	System.out.println("cognome = " + contatto.getCognome());
	        	System.out.println("telefono = " + contatto.getTelefono());
	        	System.out.println("email = " + contatto.getEmail());
	        	
	        	contatti.add(contatto);
			}
			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
			throw sqlEx;
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		System.out.println("contatti letti : " + contatti.size());
		
		return contatti;
	}
	
	
	//INSERT QUERY
	public static boolean insertContatto(ContattoWeb contatto) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
//			StringBuilder insert = new StringBuilder("INSERT into cilacap.rubrica VALUES (null,")
//					.append('\'').append(contatto.getNome()).append("\',")
//					.append('\'').append(contatto.getCognome()).append("\',")
//					.append('\'').append(contatto.getTelefono()).append("\',")
//					.append('\'').append(contatto.getEmail()).append('t').append("\')");
//			System.out.println(insert.toString());
			pstmt = connection.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());
			
			esito = pstmt.execute();
			System.out.println(pstmt.getUpdateCount());
			
			//pstmt.executeUpdate();
			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		return esito;
	}
	
	
	//UPDATE QUERY
     	public static boolean updateContatto(ContattoWeb contatto) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement prepared=null;
		boolean b=false;
		try {
			connection=DBManager.getMySqlConnection(DBManager.DB_URL,DBManager.DB_USER, DBManager.DB_PASSWORD);
			prepared = connection.prepareStatement("UPDATE cilacap.rubrica  SET nome=?, cognome=?,"
					+ " telefono=?, email=? WHERE id=2");
			prepared.setString(1, "Salvo");
			prepared.setString(2,"Dani");
			prepared.setString(3,"33445556677");
			prepared.setString(4,"Dani@salvo.it");
			b=prepared.execute();
			System.out.println(prepared.getUpdateCount());
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				prepared.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		return b;
			
}
     	
     	
     	//DELETE QUERY
     	public static boolean deleteContatto(ContattoWeb contatto) throws ClassNotFoundException {
     		Connection conn=null;
     		PreparedStatement prepared=null;
     		boolean b=false;
     		try {
     			conn=DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
     			prepared=conn.prepareStatement("DELETE FROM cilacap.rubrica WHERE id=?");
     			
     			b=prepared.execute();
     		} catch (SQLException sqlEx) {
    			System.out.println("PROBLEMA : " + sqlEx);
    		} finally {
    			try {
    				prepared.close();
    				conn.close();
    			} catch (SQLException finEx) {
    				System.out.println("PROBLEMA : " + finEx);
    			}
     		}
     		return b;
     	}
     	
     	
     	public static int esportadbsucsv(String path) throws ClassNotFoundException, SQLException, IOException {
     		List<ContattoWeb> c=DBtools.leggiContatti();
     		ContattoWeb con=new ContattoWeb();
     		con.settoFile(c);
     		return c.size();
     	}
     	
     	
     	//setta il file CSV
    	public static ArrayList<ContattoWeb> settoFile() throws IOException{  //carico i contatti csv
    		ContattoWeb c=new ContattoWeb();
    		TextFileManager tfx=new TextFileManager();
    		List<String> file=tfx.readFileRows("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
    		ArrayList<ContattoWeb> contatticaricati=new ArrayList <ContattoWeb>();
    		String separatore=(";");
    		String[] righe;
    		for(int i=0;i<file.size();i++) {
    			ContattoWeb nuovo=new ContattoWeb();
    			righe=file.get(i).split(separatore);
    			for(int a=0;a<righe.length-1;a++) {
    				if(a==0) {
    					nuovo.setCognome(righe[i]);
    				}
    				if(a==1) {
    					nuovo.setNome(righe[i]);
    				}
    				if (a==2) {
    					nuovo.setTelefono(righe[i]);
    				}
    				if(a==3) {
    					nuovo.setEmail(righe[i]);
    				}
//    				switch (a) {
//    				case 0:
//    					nuovo.setCognome(righe[i]);
//    					
//    				case 1:
//    					nuovo.setNome(righe[i]);
//    					break;
//    				case 2:
//    					nuovo.setTelefono(righe[i]);
//    					break;
//    				case 3:
//    					nuovo.setEmail(righe[i]);
//    					break;
//    				default:
//    					break;
//    				}
    			}
    			contatticaricati.add(nuovo);
    		}
    		return contatticaricati;
    	}
    	
    	
     	
    	public static List<ContattoWeb> getContattiFromFile() throws Exception {  //carico i contatti xml
    		File file=new File("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.xml");
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
    	
    	public static void scrivisudb(List<ContattoWeb> lista, String percorso) throws Exception {
    		ParserXML.writeContattiInFile(lista, percorso);
    	}

    	public static void scrivisuFileCSV(List <ContattoWeb> lista) throws IOException {
    		ContattoWeb c=new ContattoWeb();
    		c.scrivisuFile(lista, ";");
    	}
//public static void leggiconHibernate() throws ClassNotFoundException, SQLException {
//Configuration configuration=new Configuration();
//configuration=configuration.configure().addAnnotatedClass(Contatto.class);
//SessionFactory factory=configuration.buildSessionFactory();
//
//Session session=factory.openSession();
//System.out.println("La sessione è aperta?"+factory.isOpen());
//
//DBtools.leggiContatti();
//session.close();
//System.out.println("session is open? " + session.isOpen());
//
//}

//public static List<ContattoWeb> leggiconJPA() {
//	List<ContattoWeb> contatti=new ArrayList<>();
//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Cilacap");
//	EntityManager manager=factory.createEntityManager();
//	String jpql="SELECT c from Contatto as c";
//	Query query=(Query) manager.createQuery(jpql);
//	contatti=query.getResultList();
//	System.out.println("Numero di contatti: "+contatti.size());
//	return contatti;
//	
//}

//public static void insertconHibernate(Contatto contatto) throws ClassNotFoundException {
//
//Configuration configuration=new Configuration();
//configuration=configuration.configure().addAnnotatedClass(Contatto.class);
//SessionFactory factory=configuration.buildSessionFactory();
//Session session=factory.openSession();
//Transaction transaction=session.beginTransaction();
//session.save(contatto);
//session.close();
//
//
//}

//public static void selectconJPA() {
//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Cilacap");
//	EntityManager manager=factory.createEntityManager();
//	String jpql="SELECT c FROM Contatto as c WHERE cognome='Dani'";
//	Query query= manager.createQuery(jpql);
//	List<ContattoWeb> contatti=query.getResultList();
//	System.out.println("I contatti sono: \n"+contatti.size());
//	for (ContattoWeb c:contatti) {
//		System.out.println("id: "+c.getId());
//		System.out.println("nome: "+c.getNome());
//	    System.out.println("cognome: "+c.getCognome());
//	    System.out.println("telefono: "+c.getTelefono());
//	    System.out.println("email: "+c.getEmail());
//	}
//	
//	
//}

//public static void insertconJPA() {
//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Cilacap");
//	EntityManager manager=factory.createEntityManager();
//	ContattoWeb contatto=new ContattoWeb();
//	contatto.setNome("Padawan");
//	contatto.setCognome("05");
//	contatto.setTelefono("3397225004");
//	contatto.setEmail("padawan005@stock.x");
//	manager.getTransaction().begin();
//	System.out.println("Contatto iniziale: "+contatto.getId());
//	manager.persist(contatto);
//	System.out.println("Contatto attuale: "+contatto.getId());
//	manager.getTransaction().commit();
//	manager.close();
//}


//public static void scriviconHibernate() throws Exception {
//
//Configuration configuration = new Configuration();
//configuration = configuration.configure().addAnnotatedClass(Contatto.class);
//SessionFactory factory = configuration.buildSessionFactory();
//System.out.println("is open? " + factory.isOpen());
//Session session = factory.openSession();
//String hibernateQuery="SELECT *FORM Contatto as c";
//Query<Contatto> query=session.createQuery(hibernateQuery);
//for (Contatto c:query.list()) {
//	System.out.println(c);
//	
//}
//session.close();
//}
  
     		
     	
		
		
	
	public static void main(String[] args) throws Exception, ArrayIndexOutOfBoundsException {
		
		
		ArrayList <ContattoWeb> contatti= new ArrayList<ContattoWeb>();
		List<ContattoWeb> xml=new ArrayList<>();
		List<ContattoWeb> db=new ArrayList<>();
//		leggiconJPA();
//		selectconJPA();
//		insertconJPA();
		
//		xml=getContattiFromFile();
//		try{
//			contatti=settoFile();
//		}catch(ArrayIndexOutOfBoundsException arrayex){
//			contatti=settoFile();
//			System.out.println(arrayex);
//		}
////		for(int i=0;i<contatti.size();i++) {
////			insertContatto(contatti.get(i));
////			for(int a=0;a<xml.size();a++) {
////				insertContatto(xml.get(a));
////			}
////			db=leggiContatti();
////			ParserXML parser=new ParserXML();
////			parser.writeContattiInFile(db, "C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.xml");
////			Contatto c=new Contatto();
////			c.scrivisuFile(db, ";");
////		}
//		
//		try {
////			insertContatto(leggiContatti().get(0));
//			updateContatto(leggiContatti().get(0));
//			
//			esportadbsucsv("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
////			csvtoDb("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
//		} catch (Exception e) {
////			e.printStackTrace();
//			System.out.println("Qualcosa non va: "+e);
//		}
		
	}

}
