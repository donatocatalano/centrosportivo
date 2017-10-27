package it.unisalento.pps.model;

import java.util.Date;


public class Testimonianza{

	private int idTestimonianza;
	private Date data;
	private String contenuto;
	private int utente;
	private int disciplina;

	public Testimonianza() {
	}

	public Testimonianza(int idTestimonianza) {
		this.idTestimonianza = idTestimonianza;
	}

	
	
	public Testimonianza(int idTestimonianza, String contenuto, int utente, int disciplina) {
		this.idTestimonianza = idTestimonianza;
		this.contenuto = contenuto;
		this.utente = utente;
		this.disciplina = disciplina;
	}

	public Testimonianza(int idTestimonianza, Date data, String contenuto, int utente, int disciplina) {
		this.idTestimonianza = idTestimonianza;
		this.data = data;
		this.contenuto = contenuto;
		this.utente = utente;
		this.disciplina = disciplina;
	}

	public int getIdTestimonianza() {
		return this.idTestimonianza;
	}

	public void setIdTestimonianza(int idTestimonianza) {
		this.idTestimonianza = idTestimonianza;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getContenuto() {
		return this.contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public int getUtente() {
		return this.utente;
	}

	public void setUtente(Integer utente) {
		this.utente = utente;
	}

	public int getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Integer disciplina) {
		this.disciplina = disciplina;
	}

}
