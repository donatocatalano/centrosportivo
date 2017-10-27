package it.unisalento.pps.model;

import it.unisalento.pps.dao.IstruttoreDAO;

public class Istruttore  {

	private int idIstruttore;
	private String nome;
	private String cognome;
	private String username;
	private String password;

	public Istruttore() {
	}

	public Istruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}
	
	

	public Istruttore(int idIstruttore, String nome, String cognome) {
		this.idIstruttore = idIstruttore;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Istruttore(int idIstruttore, String nome, String cognome, String username, String password) {
		this.idIstruttore = idIstruttore;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public Istruttore(String username, String password) 
	{
		this.username = username;
		this.password = password;
	}

	public int getIdIstruttore() {
		return this.idIstruttore;
	}

	public void setIdIstruttore(int idIstruttore) {
		this.idIstruttore = idIstruttore;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login ()
	{
		return IstruttoreDAO.getInstance().userExists(this);
	}
}
