package it.unisalento.pps.business;

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

}
