package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Responsabile;

public class ResponsabileDAO {
	
	private static ResponsabileDAO instance;
	private Responsabile responsabile;
	
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

	public Responsabile getResponsabileByUsername(String username) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from responsabile where username=\""+ username +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		responsabile = new Responsabile(Integer.parseInt(tupla[0]),tupla[1],tupla[2]);
		
		return responsabile;
	}
	
}