package it.beije.cilacap.tools;

public class CreaContatto {
	
	public Contatto CreazioneContatto(String nome, String cognome, String telefono, String email){
		Contatto contatto = new Contatto();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		return contatto;
	}
}
