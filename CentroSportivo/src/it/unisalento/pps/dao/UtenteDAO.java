package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;


import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Utente;

public class UtenteDAO {
	
	private static UtenteDAO instance;
	private Utente tesserato;
	private Utente utente;
	
	public static UtenteDAO getInstance()
	{
		if (instance==null){
		instance = new UtenteDAO();			
		}
	return instance;
	}

	public boolean userExists(Utente u) {
		
		String username = u.getUsername();
		String password = u.getPassword();
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where binary username=\""+ username +"\" and binary password=\""+password+"\"");
		
		return ((result.size() == 1));
	}
	
	public boolean userTesseratoExists(Utente u) {
		
		String username = u.getUsername();
		String password = u.getPassword();
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where binary username=\""+ username +"\" and binary password=\""+password+"\"");
		
		return ((result.size() == 1)&(result.get(0)[9].equals("1")));
	}

	
	public Utente getUtenteByUsername(String username) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where binary username=\""+ username +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		tesserato = new Utente(Integer.parseInt(tupla[0]),tupla[1],tupla[2],tupla[3]);
		
		return tesserato;
	}


	public boolean registraUtente(String nome,String cognome,String username,String password,String sesso,Date data) {

		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Utente) from utente " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idUtente = Integer.parseInt(tupla[0]);

		
		boolean ok_registrazione = false;
		if(!(nome.isEmpty()||cognome.isEmpty()||username.isEmpty()||password.isEmpty()||sesso.isEmpty()))
			ok_registrazione = DbConnection.getInstance().eseguiAggiornamento("insert into utente(ID_Utente,Nome,Cognome,Username,Password,Sesso,Data_Nascita,Tesserato) values(\""+(idUtente+1)+"\",\""+nome+"\",\""+cognome+"\",\""+username+"\",\""+password+"\",\""+sesso+"\",\""+data+"\",\""+0+"\")");

		return  ok_registrazione;
	}	

	public ArrayList<Utente> getUtentiDaAutorizzare() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where binary tesserato = 0");
		
		ArrayList<Utente> utentiDaAutorizzare = new ArrayList<Utente>();
		Utente utente;
		for(int i=0;i<result.size();i++) {
			utente = new Utente(Integer.parseInt(result.get(i)[0]),result.get(i)[1],result.get(i)[2],result.get(i)[3]);
			utentiDaAutorizzare.add(utente);
		}
		return utentiDaAutorizzare;
	}

	public boolean confermaUtente(int utente, int responsabile) {		
		boolean ok_conferma = false;		
		ok_conferma = DbConnection.getInstance().eseguiAggiornamento("UPDATE utente SET responsabile = "+responsabile+", tesserato='1' WHERE ID_Utente = "+utente+" ");
		return ok_conferma;
	}
	
	public Utente getUtenteById(int idUtente) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where ID_Utente=\""+ idUtente +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		utente=new Utente(Integer.parseInt(tupla[0]),tupla[1],tupla[2]);
		return utente;
	}
}