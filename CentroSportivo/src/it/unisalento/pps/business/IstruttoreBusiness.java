package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.IstruttoreDAO;
import it.unisalento.pps.model.Istruttore;

public class IstruttoreBusiness {
	
private static IstruttoreBusiness instance;
	
	public static IstruttoreBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new IstruttoreBusiness();
		}
		return instance;
	}
	
	public boolean verificaLogin(String username, String password)
	{
		Istruttore i = new Istruttore (username, password);
		return i.login();
	}

	public Istruttore getIstruttoreByUsername(String username) {
		
		return IstruttoreDAO.getInstance().getIstruttoreByUsername(username);
	}
	
	public ArrayList<Istruttore> getIstruttori() {
		return IstruttoreDAO.getInstance().getIstruttori();
	}
	
	public boolean cancellaIstruttore(Istruttore istruttore) {
		return IstruttoreDAO.getInstance().cancellaIstruttore(istruttore);
	}
	
	public boolean registraIstruttore(String nome,String cognome,String username,String password) {
		return IstruttoreDAO.getInstance().registraIstruttore(nome,cognome,username,password);
	}
}
