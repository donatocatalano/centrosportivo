package it.unisalento.pps.model;

public class TipoPagamento {

	private int idTipoPagamento;
	private String tipo;

	public TipoPagamento() {
	}

	public TipoPagamento(int idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public TipoPagamento(int idTipoPagamento, String tipo) {
		this.idTipoPagamento = idTipoPagamento;
		this.tipo = tipo;
	}

	public int getIdTipoPagamento() {
		return this.idTipoPagamento;
	}

	public void setIdTipoPagamento(int idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
