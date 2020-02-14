package it.beije.cilacap.rubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.beije.cilacap.rubrica.Contatto;




public class DBtools {
	
	static Scanner scn = new Scanner(System.in);

	public static List<Contatto> leggiContatti() throws ClassNotFoundException, SQLException {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica");
			
			Contatto contatto = null;
			while (rs.next()) {
				contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
	        	contatto.setNome(rs.getString("nome"));
	        	contatto.setCognome(rs.getString("cognome"));
	        	contatto.setTelefono(rs.getString("telefono"));
	        	contatto.setEmail(rs.getString("email"));
	        		        	
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
	
	public static boolean insertContatto(Contatto contatto) throws ClassNotFoundException {
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
	
	public static void insertContattoJPA(Contatto contatto) throws ClassNotFoundException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapWeb");
		EntityManager entityManager = factory.createEntityManager();
		
		System.out.println("is open? " + factory.isOpen());
		
//		Transazione
		entityManager.getTransaction().begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		System.out.println("is open? " + factory.isOpen());
	}
	
	public static String printRubricaHTML(Contatto contatto) {
		StringBuilder sb = new StringBuilder();
	
		sb.append("<b>Nome: "+ contatto.getNome() +"</b><br>")
		.append("<b>Cognome: "+ contatto.getCognome() +"</b><br>")
		.append("<b>Telefono: "+ contatto.getTelefono() +"</b><br>")
		.append("<b>Email: "+ contatto.getEmail() +"</b><br>");
		
		return sb.toString();
	}
	
	public static List <Contatto> addContatti() {
		boolean finish= false;
		String finishString = "";
		List<Contatto> contatti = new ArrayList<>();
		
		while (!finish) {
			contatti.add(new Contatto());
			System.out.println("Inserire nome...\n");
			contatti.get(contatti.size()-1).setNome(scn.nextLine());
			System.out.println("Inserire cognome...\n");
			contatti.get(contatti.size()-1).setCognome(scn.nextLine());
			System.out.println("Inserire telefono...\n");
			contatti.get(contatti.size()-1).setTelefono(scn.nextLine());
			System.out.println("Inserire email...\n");
			contatti.get(contatti.size()-1).setEmail(scn.nextLine());
			
			System.out.println("Vuoi inserire un altro numero?\ts/n\n");
			finishString = scn.nextLine();
			
			if (finishString.contentEquals("n")) {
				finish = true;
			}
			
		}
		return contatti;
	}
	
//	public static void main(String[] args) {
//		boolean menuOn = false;
//		try {
//			String nome = ""; 
//			String cognome = ""; 
//			String telefono = ""; 
//			String email = ""; 
//			List<Contatto> contatti = leggiContatti(); 
//			List<Contatto> newContatti = new ArrayList<Contatto>(); 
//
//			
//			while (!menuOn) {
//				System.out.println("Rubrica dello zio 1.0\n\n1- Visualizzazione rubrica"
//						+ "\n2- Inserimento nuovo numero"
//						//+ "\n4- Copia file .xml esterno nella Rubrica"
//						//+ "\n5- Esporta rubrica in un file .csv"
//						+ "\n3- Aggiorna DB");
//				String scelta1 = scn.nextLine();
//				
//				switch(scelta1) {
//				case "1":
//					printRubrica(contatti);
//					break;
//				case "2":
//						insertContatto(DBtools.addContatti());
//					break;
//				case "3":
//					
//					break;
//				}
//				
//				System.out.println("Tornare al menu principale?\ts/n");
//				if (scn.nextLine().contentEquals("n"))
//					menuOn = true;
//				
//			}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}