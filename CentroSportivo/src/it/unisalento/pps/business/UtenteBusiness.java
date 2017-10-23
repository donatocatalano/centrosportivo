package it.unisalento.pps.business;

import java.util.Date;

import javax.swing.JTextField;

import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Utente;

public class UtenteBusiness {
	
private static UtenteBusiness instance;
	
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

	public boolean registraUtente(String nome, String cognome, String username, String password, String sesso, Date data) {
		
		return UtenteDAO.getInstance().registraUtente(nome, cognome, username, password, sesso, data);
	}
}