package it.unisalento.pps.model;

public class Disciplina {

	private int idDisciplina;
	private String nome;
	private double costoMensile;
	private String immagine;
	private String descrizione;

	public Disciplina() {
	}

	public Disciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}


	public Disciplina(int idDisciplina, String nome, double costoMensile, String immagine, String descrizione) {

		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.costoMensile = costoMensile;
		this.immagine = immagine;
		this.descrizione = descrizione;
	}
	
	public Disciplina(int idDisciplina, String nome, double costoMensile, String descrizione) {

		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.costoMensile = costoMensile;
		this.descrizione = descrizione;
	}

	
	public int getIdDisciplina() {
		return this.idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getCostoMensile() {

			return this.costoMensile;
	}

	public void setCostoMensile(double costoMensile) {
		this.costoMensile = costoMensile;
	}

	public String getImmagine() {
		return this.immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
