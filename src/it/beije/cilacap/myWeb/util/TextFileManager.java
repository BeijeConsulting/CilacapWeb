package it.beije.cilacap.myWeb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TextFileManager {

//	public static String readFileContent(String filePath) throws IOException {
//		File file = new File(filePath);
//		
//		return readFileContent(file);
//	}
//	
//	public static String readFileContent(File file) throws IOException {
//		StringBuilder builder = new StringBuilder();
//		
//		FileReader fileReader = new FileReader(file);
//
//		int c;
//		while ((c = fileReader.read()) > -1) {
//			//System.out.print((char)c);
//			builder.append((char)c);
//		}
//		
//		fileReader.close();
//		
//		return builder.toString();
//	}
	
	public static List<String> readFileRows(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileRows(file);
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
		
		return rows;
	}

//	public static void writeFileContent(String content, String filePath) throws IOException {
//		File file = new File(filePath);
//		writeFileContent(content, file);
//	}
//	
//	public static void writeFileContent(String content, File file) throws IOException {
//		FileWriter fileWriter = new FileWriter(file);
//		
//		fileWriter.write(content);
//		
//		fileWriter.flush();
//		fileWriter.close();
//	}
}
