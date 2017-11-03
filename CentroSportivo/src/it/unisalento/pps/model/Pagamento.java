package it.unisalento.pps.model;

import java.sql.Date;

public class Pagamento{

	private int idPagamento;
	private int utente;
	private int tipo;
	private double totale;
	private int responsabile;
	private Date dataConferma;
	private Date dataPagamento;
	private int iscrizione;
	private Boolean accettato;

	public Pagamento() {
	}

	public Pagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Pagamento(int idPagamento, int utente, int tipo, float totale, int responsabile,
			Date dataConferma, Date dataPagamento, int iscrizione, Boolean accettato) {
		this.idPagamento = idPagamento;
		this.utente = utente;
		this.tipo = tipo;
		this.totale = totale;
		this.responsabile = responsabile;
		this.dataConferma = dataConferma;
		this.dataPagamento = dataPagamento;
		this.iscrizione = iscrizione;
		this.accettato = accettato;
	}

<<<<<<< HEAD
	public Pagamento(int idPagamento, int utente, int tipo, float totale, Date dataPagamento, int iscrizione) {
		this.idPagamento = idPagamento;
		this.utente = utente;
		this.tipo = tipo;
		this.totale = totale;
		this.dataPagamento = dataPagamento;
		this.iscrizione = iscrizione;
	}

	public Pagamento(int idPagamento, int utente, int tipo, float totale, int iscrizione) {
		this.idPagamento = idPagamento;
		this.utente = utente;
		this.tipo = tipo;
		this.totale = totale;
=======
	public Pagamento(int parseInt, int parseInt2, int parseInt3, double parseDouble) {
		// TODO Auto-generated constructor stub
	}

	

	public Pagamento(int idPagamento, int utente, int tipo, double totale, Date dataPagamento, int iscrizione) {
		this.idPagamento = idPagamento;
		this.utente = utente;
		this.tipo = tipo;
		this.totale = totale;
		this.dataPagamento = dataPagamento;
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
		this.iscrizione = iscrizione;
	}

	public int getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public int getUtente() {
		return this.utente;
	}

	public void setUtente(Integer utente) {
		this.utente = utente;
	}

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public double getTotale() {
		return this.totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
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

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public int getIscrizione() {
		return this.iscrizione;
	}

	public void setIscrizione(int iscrizione) {
		this.iscrizione = iscrizione;
	}

	public Boolean getAccettato() {
		return this.accettato;
	}

	public void setAccettato(Boolean accettato) {
		this.accettato = accettato;
	}
}
