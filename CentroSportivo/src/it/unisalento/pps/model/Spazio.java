package it.unisalento.pps.model;

public class Spazio{

	private int idSpazio;
	private String nome;

	public Spazio() {
	}

	public Spazio(int idSpazio) {
		this.idSpazio = idSpazio;
	}
	
	public Spazio(int idSpazio, String nome) {
		this.idSpazio = idSpazio;
		this.nome = nome;
	}

	public int getIdSpazio() {
		return this.idSpazio;
	}

	public void setIdSpazio(int idSpazio) {
		this.idSpazio = idSpazio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
