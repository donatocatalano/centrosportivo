package it.unisalento.pps.model;

import it.unisalento.pps.dao.ResponsabileDAO;

public class Responsabile{

	private int idResponsabile;
	private String nome;
	private String cognome;
	private String username;
	private String password;

	public Responsabile() {
	}

	public Responsabile(int idResponsabile) {
		this.idResponsabile = idResponsabile;
	}
	
	
	
	public Responsabile(int idResponsabile, String nome, String cognome) {
		this.idResponsabile = idResponsabile;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Responsabile(int idResponsabile, String nome, String cognome, String username, String password) {
		this.idResponsabile = idResponsabile;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}
	
	public Responsabile(String username, String password) 
	{		
		this.username = username;
		this.password = password;		
	}

	public int getIdResponsabile() {
		return this.idResponsabile;
	}

	public void setIdResponsabile(int idResponsabile) {
		this.idResponsabile = idResponsabile;
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
		return ResponsabileDAO.getInstance().userExists(this);
	}
}
