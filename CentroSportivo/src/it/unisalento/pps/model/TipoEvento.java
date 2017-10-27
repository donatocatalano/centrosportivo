package it.unisalento.pps.model;

public class TipoEvento {

	private int idTipoEvento;
	private String tipo;

	public TipoEvento() {
	}

	public TipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public TipoEvento(int idTipoEvento, String tipo) {
		this.idTipoEvento = idTipoEvento;
		this.tipo = tipo;
	}

	public int getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
