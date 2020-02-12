package it.beije.cilacap.rubrica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetodiCSV {

	//definisco lo scheletro del csv

		public List<ContattoWeb> scheletroCsv() throws IOException {

			Scanner sc=new Scanner(System.in);
			String cognome="";
			String nome=""; 
			String telefono="";
			String email="";
			String scelta="";


			List<ContattoWeb> contatti=new ArrayList<ContattoWeb>();
			while(!scelta.equalsIgnoreCase("n")) {

				ContattoWeb mioContatto=new ContattoWeb();

				while(cognome.equals("")) {
					System.out.println("Inserisci il cognome: ");
					cognome=sc.nextLine();
					mioContatto.setCognome(cognome);
				}

				while(nome.equals("")) {
					System.out.println("Inserisci il nome: ");
					nome=sc.nextLine();
					mioContatto.setNome(nome);
				}

				while(telefono.equals("")) {
					System.out.println("Inserisci il telefono: ");
					telefono=sc.nextLine();
					mioContatto.setTelefono(telefono);
				}

				while(email.equals("")) {
					System.out.println("Inserisci l'email: ");
					email=sc.nextLine();
					mioContatto.setEmail(email);
				}
				contatti.add(mioContatto);



				System.out.println("Vuoi inserire un altro contatto? Se sì premi S, altrimenti N.");

				scelta=sc.nextLine();

				if(scelta.equalsIgnoreCase("s")) {
					cognome="";
					nome="";
					telefono="";
					email="";
				}
			}
			return contatti;
		}
		
	    //scrivo i contatti sul file csv
		public void scrivisuFile(List<ContattoWeb> contenuto,String separatore) throws IOException {

			TextFileManager tfm=new TextFileManager();

			StringBuilder sb=new StringBuilder();
			String intestazione=("COGNOME;NOME;TELEFONO;EMAIL");
			sb.append("COGNOME;NOME;TELEFONO;EMAIL");
			sb.append('\n');
			for(int i=0; i<contenuto.size(); i++) {
				sb.append(contenuto.get(i).getCognome());
				sb.append(separatore);

				sb.append(contenuto.get(i).getNome());
				sb.append(separatore);

				sb.append(contenuto.get(i).getTelefono());
				sb.append(separatore);

				sb.append(contenuto.get(i).getEmail());
			
				sb.append('\n');
			}
			tfm.writeFileContent(sb.toString(), "C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
		}
		
	    //creo una lista con i contatti scritti nel CSV
		public List<ContattoWeb> settoFile(List<ContattoWeb> lista, String pathfile) throws IOException{
			ContattoWeb c=new ContattoWeb();
			TextFileManager tfx=new TextFileManager();
			List<String> file=tfx.readFileRows(pathfile);
			
			String separatore=(";");
			String[] righe;
			for(int i=1;i<file.size();i++) {
				ContattoWeb nuovo=new ContattoWeb();
				righe=file.get(i).split(separatore);
				for(int a=0;a<righe.length;a++) {
					switch (a) {
					case 0:
						nuovo.setCognome(righe[i]);
						break;
					case 1:
						nuovo.setNome(righe[i]);
						break;
					case 2:
						nuovo.setTelefono(righe[i]);
						break;
					case 3:
						nuovo.setEmail(righe[i]);
						break;
					default:
						break;
					}
				}
				lista.add(nuovo);
			}
			return lista;
		}

}
