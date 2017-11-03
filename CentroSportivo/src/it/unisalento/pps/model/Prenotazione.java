package it.unisalento.pps.model;

import java.util.Date;

public class Prenotazione {

	private int idPrenotazione;
	private int utente;
	private int evento;
	private Date dataPrenotazione;

	public Prenotazione() {
	}

	public Prenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Prenotazione(int idPrenotazione, int utente, int evento, Date dataPrenotazione) {
		this.idPrenotazione = idPrenotazione;
		this.utente = utente;
		this.evento = evento;
		this.dataPrenotazione = dataPrenotazione;
	}

	public Prenotazione(int idPrenotazione, int utente, int evento) {
		this.idPrenotazione = idPrenotazione;
		this.utente = utente;
		this.evento = evento;
	}

	public int getIdPrenotazione() {
		return this.idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public int getUtente() {
		return this.utente;
	}

	public void setUtente(Integer utente) {
		this.utente = utente;
	}

	public int getEvento() {
		return this.evento;
	}

	public void setEvento(Integer evento) {
		this.evento = evento;
	}

	public Date getDataPrenotazione() {
		return this.dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
}
