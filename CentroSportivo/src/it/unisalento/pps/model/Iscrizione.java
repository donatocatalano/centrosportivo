package it.unisalento.pps.model;

import java.util.Date;

public class Iscrizione {

	private int idIscrizione;
	private Date dataIn;
	private Date dataOut;
	private Boolean accettata;
	private int livello;
	private int disciplina;
	private int utente;
	private int responsabile;
	private Date dataConferma;

	public Iscrizione() {
	}

	public Iscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public Iscrizione(int idIscrizione, Date dataIn, Date dataOut, Boolean accettata, int livello,
			int disciplina, int utente, int responsabile, Date dataConferma) {
		this.idIscrizione = idIscrizione;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.accettata = accettata;
		this.livello = livello;
		this.disciplina = disciplina;
		this.utente = utente;
		this.responsabile = responsabile;
		this.dataConferma = dataConferma;
	}

	public Iscrizione(int idIscrizione, int livello, int disciplina, int utente) {
		this.idIscrizione = idIscrizione;
		this.livello = livello;
		this.disciplina = disciplina;
		this.utente = utente;
	}
	
	public Iscrizione(int idIscrizione, Date dataIn, Date dataOut, int livello, int disciplina, int utente) {
		this.idIscrizione = idIscrizione;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.livello = livello;
		this.disciplina = disciplina;
		this.utente = utente;
	}

	public Iscrizione(int idIscrizione, Date dataIn, Date dataOut, int livello, int disciplina, int utente,int responsabile, Date dataConferma) {
		this.idIscrizione = idIscrizione;
		this.dataIn = dataIn;
		this.dataOut = dataOut;
		this.livello = livello;
		this.disciplina = disciplina;
		this.utente = utente;
		this.responsabile = responsabile;
		this.dataConferma = dataConferma;
	}

	public int getIdIscrizione() {
		return this.idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public Date getDataIn() {
		return this.dataIn;
	}

	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}

	public Date getDataOut() {
		return this.dataOut;
	}

	public void setDataOut(Date dataOut) {
		this.dataOut = dataOut;
	}

	public Boolean getAccettata() {
		return this.accettata;
	}

	public void setAccettata(Boolean accettata) {
		this.accettata = accettata;
	}

	public int getLivello() {
		return this.livello;
	}

	public void setLivello(int livello) {
		this.livello = livello;
	}

	public int getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(int disciplina) {
		this.disciplina = disciplina;
	}

	public int getUtente() {
		return this.utente;
	}

	public void setUtente(int utente) {
		this.utente = utente;
	}

	public int getResponsabile() {
		return this.responsabile;
	}

	public void setResponsabile(int responsabile) {
		this.responsabile = responsabile;
	}

	public Date getDataConferma() {
		return this.dataConferma;
	}

	public void setDataConferma(Date dataConferma) {
		this.dataConferma = dataConferma;
	}
}
