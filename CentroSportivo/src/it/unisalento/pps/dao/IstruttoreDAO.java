package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Istruttore;

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
	
	public ArrayList<Istruttore> getIstruttori() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from istruttore ");
		ArrayList<Istruttore> istruttori = new ArrayList<Istruttore>();
		Istruttore istruttore;
		for(int i=0;i<result.size();i++) {
			
			istruttore = new Istruttore(Integer.parseInt(result.get(i)[0]),result.get(i)[1],result.get(i)[2],result.get(i)[3],result.get(i)[4]);
			istruttori.add(istruttore);
		}
		return istruttori;
	}
	
	public boolean cancellaIstruttore(Istruttore istruttore) {
		boolean ok_eliminazione = false;
		ok_eliminazione = DbConnection.getInstance().eseguiAggiornamento("Delete from istruttore where ID_Istruttore = \""+ istruttore.getIdIstruttore() +"\" ");
	
		return   ok_eliminazione;
	}
	
	public boolean registraIstruttore(String nome,String cognome,String username,String password) {

		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Istruttore) from istruttore " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idIstruttore = Integer.parseInt(tupla[0]);

		
		boolean ok_registrazione = false;
		if(!(nome.isEmpty()||cognome.isEmpty()||username.isEmpty()||password.isEmpty()))
			ok_registrazione = DbConnection.getInstance().eseguiAggiornamento("insert into istruttore (ID_Istruttore,Nome,Cognome,Username,Password) values(\""+(idIstruttore+1)+"\",\""+nome+"\",\""+cognome+"\",\""+username+"\",\""+password+"\")");

		return  ok_registrazione;
	}	
}
