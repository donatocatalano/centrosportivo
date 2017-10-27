package it.unisalento.pps.model;

public class Livello {

	private int idLivello;
	private String nome;

	public Livello() {
	}

	public Livello(int idLivello) {
		this.idLivello = idLivello;
	}

	public Livello(int idLivello, String nome) {
		this.idLivello = idLivello;
		this.nome = nome;
	}

	public int getIdLivello() {
		return this.idLivello;
	}

	public void setIdLivello(int idLivello) {
		this.idLivello = idLivello;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
