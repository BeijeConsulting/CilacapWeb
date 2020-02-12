package it.beije.cilacap.web.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.cilacap.web.rubrica.Contatto;

public class ParserCSV {
	public static String readFileContent(String filePath) throws IOException {
		File file = new File(filePath);

		return readFileContent(file);
	}

	public static String readFileContent(File file) throws IOException {
		StringBuilder builder = new StringBuilder();

		FileReader fileReader = new FileReader(file);

		int c;
		while ((c = fileReader.read()) > -1) {
			// System.out.print((char)c);
			builder.append((char) c);
		}

		fileReader.close();
		return builder.toString();
	}

	public static void writeFileContent(String content, String filePath) throws IOException {
		File file = new File(filePath);
		writeFileContent(content, file);
	}

	public static void writeFileContent(String content, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);

		fileWriter.write(content);

		fileWriter.flush();
		fileWriter.close();
	}

	public static List<Contatto> loadContactListFromCSV(File file) throws IOException {
		List<Contatto> contactList = new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row = reader.readLine();
		while ((row = reader.readLine()) != null) {
			Contatto c1 = new Contatto();
			String[] info = row.split(";");
			c1.setCognome(info[0]);
			c1.setNome(info[1]);
			c1.setTelefono(info[2]);
			c1.setEmail(info[3]);
			contactList.add(c1);
		}
		return contactList;
	}

	public static void writeInFileCSV(List<Contatto> contatti, File f1) throws IOException {

		StringBuilder contenuto = new StringBuilder();
		for (Contatto contatto : contatti) {
			contenuto.append(contatto.getCognome() + ";");
			contenuto.append(contatto.getNome() + ";");
			contenuto.append(contatto.getTelefono() + ";");
			contenuto.append(contatto.getEmail() + "\n");
		}

		String intestazione = "COGNOME;NOME;TELEFONO;EMAIL\n";
		String nuovoContenuto = contenuto.toString();

		if (f1.exists()) {
			String contenutoFile = readFileContent(f1);
			String stringContenutoFile = intestazione
					.concat(contenutoFile.substring(contenutoFile.indexOf('\n') + 1).concat(nuovoContenuto));
			writeFileContent(stringContenutoFile, f1);
		} else {
			String contenuto2 = intestazione.concat(nuovoContenuto);
			writeFileContent(contenuto2, f1);

		}
	}



}
