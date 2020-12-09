package com.gianluca.bc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Utente {

	@Size(min=2, max=30, message="Da 2 a 30 caratteri")
	@Pattern(regexp = "^[a-zA-Z]{1,30}", message = "Solo lettere accettate, massimo 30 caratteri")
	private String nome;
	@Size(min=2, max=30, message="Da 2 a 30 caratteri")
	@Pattern(regexp = "^[a-zA-Z]{1,30}", message = "Solo lettere accettate, massimo 30 caratteri")
	private String cognome;
	@Size(min=2, max=30, message="Da 2 a 30 caratteri")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}", message = "Inserire un formato e-mail valido")
	private String email;
	@Size(min=2, max=30, message="Da 2 a 30 caratteri")
	private String password;
	@Size(min=2, max=30, message="Da 2 a 30 caratteri")
	private String username;
	
	public Utente() {
		
	}
	
	public Utente(String nome, String cognome, String email, String password, String username) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
