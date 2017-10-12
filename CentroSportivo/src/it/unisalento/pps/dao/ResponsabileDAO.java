package it.unisalento.pps.dao;

import java.util.ArrayList;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Responsabile;

public class ResponsabileDAO {
	
	private static ResponsabileDAO instance;
	
	public static ResponsabileDAO getInstance()
	{
	
		if (instance==null)
		{
			instance = new ResponsabileDAO();			
		}
		return instance;
	}

	public boolean userExists(Responsabile r) 
	{
		String username = r.getUsername();
		String password = r.getPassword();
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from responsabile where username=\""+ username + "\" and password=\""+ password + "\"");
		
		return (result.size() == 1);
	}
	
}