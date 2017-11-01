package it.unisalento.pps.business;

import java.sql.Date;
import java.util.ArrayList;

import it.unisalento.pps.dao.SpazioDAO;
import it.unisalento.pps.dao.TestimonianzaDAO;
import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.Testimonianza;
import it.unisalento.pps.model.Utente;

public class UtenteBusiness {
	
private static UtenteBusiness instance;

	Utente utente;
	
	public static UtenteBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new UtenteBusiness();
		}
		return instance;
	}
	
	public boolean verificaLogin(String username, String password)
	{
		Utente u = new Utente (username, password);
		return u.login();
	}
	
	public boolean verificaLoginTesserato(String username, String password) 
	{
		Utente u=new Utente(username, password);
		return u.loginTesserato();
	}

	public Utente getUtenteByUsername(String username) {
		
		return UtenteDAO.getInstance().getUtenteByUsername(username);
	}


	public boolean registraUtente(String nome,String cognome,String username,String password,String sesso,Date data) {
		return UtenteDAO.getInstance().registraUtente(nome,cognome,username,password,sesso,data);
	}
	
	public ArrayList<Utente> getUtentiDaAutorizzare() {
		return UtenteDAO.getInstance().getUtentiDaAutorizzare();
	}

	public boolean confermaUtente(int utente, int responsabile) {
		return UtenteDAO.getInstance().confermaUtente(utente, responsabile);
	}
	
	public Utente getUtenteById(int idUtente) {
		utente = UtenteDAO.getInstance().getUtenteById(idUtente);
		return utente;
	}
}