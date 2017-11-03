package it.unisalento.pps.model;

import java.util.Date;

public class Evento{

	private int idEvento;
	private Date dataInizio;
	private Date dataFine;
	private String turno;
	private int istruttore;
	private int spazio;
	private int tipo;
	private int disciplina;

	public Evento() {
	}

	public Evento(int idEvento) {
		this.idEvento = idEvento;
	}

	public Evento(int idEvento, Date dataInizio,Date dataFine, String turno, int istruttore, int spazio, int tipo, int disciplina) {
		this.idEvento = idEvento;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;		
		this.turno = turno;
		this.istruttore = istruttore;
		this.spazio = spazio;
		this.tipo = tipo;
		this.disciplina = disciplina;
	}
	
	public Evento(int idEvento, String turno, int tipo) {
		this.idEvento = idEvento;		
		this.turno = turno;
		this.tipo = tipo;
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	
	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getIstruttore() {
		return this.istruttore;
	}

	public void setIstruttore(int istruttore) {
		this.istruttore = istruttore;
	}

	public int getSpazio() {
		return this.spazio;
	}

	public void setSpazio(int spazio) {
		this.spazio = spazio;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(int disciplina) {
		this.disciplina = disciplina;
	}
}
