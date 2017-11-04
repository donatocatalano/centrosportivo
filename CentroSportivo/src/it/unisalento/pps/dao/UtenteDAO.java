package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
			
			int anno = Integer.parseInt((result.get(i)[6].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[6].substring(5,7)));
			int giorno= Integer.parseInt((result.get(i)[6].substring(8,10)));
			GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi_inizio = data.getTimeInMillis();
			Date date = new Date(millisecondi_inizio);
			
			utente = new Utente(Integer.parseInt(result.get(i)[0]),result.get(i)[1],result.get(i)[2],result.get(i)[3], date);
			utentiDaAutorizzare.add(utente);
		}
		return utentiDaAutorizzare;
	}
	
	public ArrayList<Utente> getTesserati() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where binary tesserato = 1");
		
		ArrayList<Utente> tesserati = new ArrayList<Utente>();
		Utente utente;
		for(int i=0;i<result.size();i++) {
			
			int anno = Integer.parseInt((result.get(i)[6].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[6].substring(5,7)));
			int giorno= Integer.parseInt((result.get(i)[6].substring(8,10)));
			GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi_inizio = data.getTimeInMillis();
			Date date = new Date(millisecondi_inizio);
			
			utente = new Utente(Integer.parseInt(result.get(i)[0]),result.get(i)[1],result.get(i)[2],result.get(i)[3], date);
			tesserati.add(utente);
		}
		return tesserati;
	}

	public boolean autorizzaUtente(int utente, int responsabile) {
		
		/*Calendar data = Calendar.getInstance();
		data.getTime();
		int anno=data.get(Calendar.YEAR);
		int mese=data.get(Calendar.MONTH);
		int giorno=data.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar data1 = new GregorianCalendar(anno,mese,giorno);
		long millisecondi_inizio = data1.getTimeInMillis();
		Date dataodierna = new Date(millisecondi_inizio);
		System.out.println(dataodierna);*/
		
		boolean ok_autorizza = false;		
		ok_autorizza = DbConnection.getInstance().eseguiAggiornamento("UPDATE utente SET responsabile = "+responsabile+", data_registrazione = curdate(), tesserato='1' WHERE ID_Utente = "+utente+" ");
		return ok_autorizza;
	}
	
	public Utente getUtenteById(int idUtente) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from utente where ID_Utente=\""+ idUtente +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		utente=new Utente(Integer.parseInt(tupla[0]),tupla[1],tupla[2]);
		return utente;
	}

	public boolean cancellaTesserato(Utente tesserato) {
		boolean ok_eliminazione = false;
		ok_eliminazione = DbConnection.getInstance().eseguiAggiornamento("Delete from tesserato where ID_Utente = \""+ tesserato.getIdUtente() +"\" ");
	
		return   ok_eliminazione;
	}
}