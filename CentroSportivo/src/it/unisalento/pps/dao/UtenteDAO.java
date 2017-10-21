package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Utente;

public class UtenteDAO {
	
	private static UtenteDAO instance;
	private Utente tesserato;
	
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

	
	public Utente getUtenteByUsername(String username) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where username=\""+ username +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		tesserato = new Utente(Integer.parseInt(tupla[0]),tupla[1],tupla[2],tupla[3]);
		
		return tesserato;
	}

	public boolean registraUtenteByNome(String nome) {
		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select count(*) from utente " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idUtente = Integer.parseInt(tupla[0]);
		
		return DbConnection.getInstance().eseguiAggiornamento("insert into utente(ID_Utente,Nome) values(\""+(idUtente+1)+"\",\""+nome+"\")"); 
		
	}
}