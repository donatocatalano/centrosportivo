package it.unisalento.pps.model;

import java.sql.Date;

import it.unisalento.pps.dao.UtenteDAO;

public class Utente{

	private int idUtente;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String sesso;
	private Date dataNascita;
	private int responsabile;
	private Date dataRegistrazione;
	private Boolean tesserato;
	private String contenuto;

	public Utente() {
	}

	public Utente(int idUtente) {
		this.idUtente = idUtente;
	}

	public Utente(int idUtente, String nome, String cognome, String username, String password, String sesso,
			Date dataNascita, int responsabile, Date dataRegistrazione, Boolean tesserato) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.responsabile = responsabile;
		this.dataRegistrazione = dataRegistrazione;
		this.tesserato = tesserato;
	}
	
	
	
	public Utente(int idUtente, String nome, String cognome) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Utente(int idUtente, String nome, String cognome,  String sesso) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
	}
	
	public Utente(int idUtente, String nome, String cognome,  String username, Date dataNascita) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.dataNascita = dataNascita;
	}
	
	public Utente(String username, String password) 
	{		
		this.username = username;
		this.password = password;		
	}
	
	public Utente(int idUtente, String nome) {
		this.idUtente = idUtente;
		this.nome = nome;
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
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

	public String getSesso() {
		return this.sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Integer getResponsabile() {
		return this.responsabile;
	}

	public void setResponsabile(Integer responsabile) {
		this.responsabile = responsabile;
	}

	public Date getDataRegistrazione() {
		return this.dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Boolean getTesserato() {
		return this.tesserato;
	}

	public void setTesserato(Boolean tesserato) {
		this.tesserato = tesserato;
	}
	
	public String getContenuto() {
		return this.contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	public boolean login ()
	{
		return UtenteDAO.getInstance().userExists(this);
	}
	
	public boolean loginTesserato()
	{
		return UtenteDAO.getInstance().userTesseratoExists(this);
	}
}
