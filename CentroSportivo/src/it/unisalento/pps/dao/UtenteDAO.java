package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Utente;

public class UtenteDAO {
	
	private static UtenteDAO instance;
	
	public static UtenteDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new UtenteDAO();			
	}
	return instance;
	}

	public boolean userExists(Utente u) {
		
		String username = u.getUsername();
		String password = u.getPassword();
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where username=\""+ username +"\" and password=\""+password+"\"");
		
		
		return ((result.size() == 1));
		
	}
	public boolean userTesseratoExists(Utente u) {
		
		String username = u.getUsername();
		String password = u.getPassword();
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where username=\""+ username +"\" and password=\""+password+"\"");
		
		
		return ((result.size() == 1)&(result.get(0)[9].equals("1")));
		
	}

	public String getNomeByUsername(String username) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where username=\""+ username +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		return (tupla[1]);
		
	}

	public String getCognomeByUsername(String username) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where username=\""+ username +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		return (tupla[2]);
	}
}