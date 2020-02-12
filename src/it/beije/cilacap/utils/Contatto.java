package it.beije.cilacap.utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contatti")
public class Contatto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;

	@Column(name="cognome")
	private String cognome;

	@Column(name="telefono")
	private String telefono;

	@Column(name="email")
	private String email;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		if(nome==null)
			return "";
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		if(cognome==null)
			return "";
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTelefono() {
		if(telefono==null)
			return "";
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		if(email==null)
			return "";
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id).append(';');
		builder.append(cognome).append(';');
		builder.append(nome).append(';');
		builder.append(telefono).append(';');
		builder.append(email).append("<br>");
		return builder.toString();
	}
}
