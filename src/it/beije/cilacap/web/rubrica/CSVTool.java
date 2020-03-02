package it.beije.cilacap.web.rubrica;

import java.io.*;
import java.util.*;


public class CSVTool {

	static List<Contatto> listaContatti = new ArrayList<Contatto>();

	// Legge file CSV
	public List<Contatto> ReaderCSV(String path) throws IOException {

		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);

		String row;
		String[] credenziali = new String[10];
		int count = 0;

		Contatto contatto = null;
		while ((row = reader.readLine()) != null) {
			contatto = new Contatto();

			String[] header = row.split(";");

			if (count == 0) {
				for (int i = 0; i < header.length; i++) {
					credenziali[i] = header[i];
				}
				count++;

			} else {

				for (int i = 0; i < header.length; i++) {

					if (credenziali[i].equalsIgnoreCase("nome"))
						contatto.setNome(header[i]);
					else if (credenziali[i].equalsIgnoreCase("cognome"))
						contatto.setCognome(header[i]);
					else if (credenziali[i].equalsIgnoreCase("telefono"))
						contatto.setTelefono(header[i]);
					else if (credenziali[i].equalsIgnoreCase("email"))
						contatto.setEmail(header[i]);

				}
				listaContatti.add(contatto);
			}
		}
		reader.close();
		return listaContatti;
	}

	// Scrive file CSV
	public void WriterCSV(String path, List<Contatto> listaContatti) throws IOException {

		ArrayList<String> arrayContatti = new ArrayList<>();

		File file = new File(path);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		String assemblaContatto = null;
		for (Contatto contatto : listaContatti) {

			assemblaContatto = contatto.getId() + ";" + contatto.getCognome() + ";" + contatto.getNome() + ";"
					+ contatto.getTelefono() + ";" + contatto.getEmail();

			arrayContatti.add(assemblaContatto);
		}

		int count = 0;
		for (String cursore : arrayContatti) {

			if (count == 0) {
				bw.write("ID;COGNOME;NOME;TELEFONO;EMAIL\n");
				++count;
			}

			bw.write(cursore + "\n");
			System.out.println(cursore);
		}
		bw.flush();
		bw.close();
	}
}