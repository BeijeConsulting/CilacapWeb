package it.beije.cilacap.web.rubrica;


public class Contatto {
	
	
	public Contatto() {}
	
	public Contatto(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}
	
	public Contatto(int id, String nome, String cognome, String telefono, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}

	
	private Integer id;

	
	private String nome;

	
	private String cognome;

	
	private String telefono;

	
	private String email;

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
	
	public String toStringHTML() {
		StringBuilder builder = new StringBuilder();
		builder.append("<hr width=\"50%\">");
		builder.append("<p><strong>");
		builder.append("nome : ").append(nome).append("<br />");
		builder.append("cognome : ").append(cognome).append("<br />");
		builder.append("telefono : ").append(telefono).append("<br />");
		builder.append("email : ").append(email).append("<br />");
		builder.append("</strong></p>");
		builder.append("<hr width=\"50%\">");
		return builder.toString();
	}

}
