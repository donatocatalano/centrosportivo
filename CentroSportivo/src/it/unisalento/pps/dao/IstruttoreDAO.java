package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Utente;

public class IstruttoreDAO {
	
	private static IstruttoreDAO instance;
	private Istruttore istruttore;
	
	public static IstruttoreDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new IstruttoreDAO();			
	}
	return instance;
	}

	public boolean userExists(Istruttore i) 
	{
		String username = i.getUsername();
		String password = i.getPassword();
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from istruttore where binary username=\""+ username + "\" and binary password=\""+ password + "\"");
		
		return (result.size() == 1);
	}

	public Istruttore getIstruttoreByUsername(String username) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from istruttore where binary username=\""+ username +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		istruttore = new Istruttore(Integer.parseInt(tupla[0]),tupla[1],tupla[2]);
		
		return istruttore;
	}
	
}
