package it.unisalento.pps.dao;

import java.util.ArrayList;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Istruttore;

public class IstruttoreDAO {
	
	private static IstruttoreDAO instance;
	
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
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from istruttore where username=\""+ username + "\" and password=\""+ password + "\"");
		
		return (result.size() == 1);
	}
	
}
