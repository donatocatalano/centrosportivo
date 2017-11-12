package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Prenotazione;

public class PrenotazioneDAO {
	
	private static PrenotazioneDAO instance;
	private Prenotazione prenotazione;
	
	public static PrenotazioneDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new PrenotazioneDAO();			
	}
	return instance;
	}

	public Prenotazione getPrenotazioneById(int idPrenotazione) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from prenotazione where ID_Prenotazione=\""+ idPrenotazione +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		prenotazione=new Prenotazione(Integer.parseInt(tupla[0]),Integer.parseInt(tupla[1]),Integer.parseInt(tupla[2]));
		return  prenotazione;
	}

	public ArrayList<Prenotazione> getPrenotazioniDaAutorizzare() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from prenotazione where valida = 0");
		
		ArrayList<Prenotazione> prenotazioniDaAutorizzare = new ArrayList<Prenotazione>();
		Prenotazione prenotazione;
		for(int i=0;i<result.size();i++) {
			
			int anno = Integer.parseInt((result.get(i)[3].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[3].substring(5,7)));
			int giorno = Integer.parseInt((result.get(i)[3].substring(8,10)));
			GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi = data.getTimeInMillis();
			Date date = new Date(millisecondi);
			
			prenotazione = new Prenotazione(Integer.parseInt(result.get(i)[0]),Integer.parseInt(result.get(i)[1]),Integer.parseInt(result.get(i)[2]), date);
			prenotazioniDaAutorizzare.add(prenotazione);
		}
		return prenotazioniDaAutorizzare;
	}

	public boolean autorizzaModificaPrenotazione(int prenotazione) {
		
		boolean ok_autorizza = false;		
		ok_autorizza = DbConnection.getInstance().eseguiAggiornamento("UPDATE prenotazione SET valida = '1', data_prenotazione = curdate() WHERE ID_Prenotazione = "+prenotazione+" ");
		return ok_autorizza;
	}

	public boolean cancellaPrenotazione(Prenotazione prenotazione) {
		boolean ok_eliminazione = false;
		ok_eliminazione = DbConnection.getInstance().eseguiAggiornamento("Delete from prenotazione where ID_Prenotazione = \""+ prenotazione.getIdPrenotazione() +"\" ");
	
		return   ok_eliminazione;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from prenotazione ");
		
		ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		Prenotazione prenotazione;
		for(int i=0;i<result.size();i++) {
			
			int anno = Integer.parseInt((result.get(i)[3].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[3].substring(5,7)));
			int giorno = Integer.parseInt((result.get(i)[3].substring(8,10)));
			GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi = data.getTimeInMillis();
			Date date = new Date(millisecondi);
			
			prenotazione = new Prenotazione(Integer.parseInt(result.get(i)[0]),Integer.parseInt(result.get(i)[1]),Integer.parseInt(result.get(i)[2]), date);
			prenotazioni.add(prenotazione);
		}
		return prenotazioni;
	}

	public boolean setPrenotazioneTesserato(int idUtente, Integer idEvento) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select count(*) from prenotazione");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		int idUltimaPrenotazione = Integer.parseInt(tupla[0]);
		int idPrenotazione= idUltimaPrenotazione+1;
		
		boolean prenotato = false;		
		prenotato = DbConnection.getInstance().eseguiAggiornamento("INSERT prenotazione(ID_Prenotazione,Utente,Evento,Data_Prenotazione,Valida) values ("+idPrenotazione+","+idUtente+","+idEvento+",curdate(),"+0+")");
		return prenotato;
	}

	public ArrayList<Prenotazione> getPrenotazioniByUtente(int idUtente) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from prenotazione where Utente = "+idUtente);
		
		ArrayList<Prenotazione> prenotazioniByUtente = new ArrayList<Prenotazione>();
		Prenotazione prenotazione;
		for(int i=0;i<result.size();i++) {
			
			int anno = Integer.parseInt((result.get(i)[3].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[3].substring(5,7)));
			int giorno = Integer.parseInt((result.get(i)[3].substring(8,10)));
			GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi = data.getTimeInMillis();
			Date date = new Date(millisecondi);
			
			prenotazione = new Prenotazione(Integer.parseInt(result.get(i)[0]),Integer.parseInt(result.get(i)[1]),Integer.parseInt(result.get(i)[2]), date,Integer.parseInt(result.get(i)[4]));
			prenotazioniByUtente.add(prenotazione);
		}
		return prenotazioniByUtente;
	}

	public boolean setPrenotazioneValidaTesserato(int idUtente, int idEvento) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select count(*) from prenotazione");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		int idUltimaPrenotazione = Integer.parseInt(tupla[0]);
		int idPrenotazione= idUltimaPrenotazione+1;
		
		boolean prenotato = false;		
		prenotato = DbConnection.getInstance().eseguiAggiornamento("INSERT prenotazione(ID_Prenotazione,Utente,Evento,Data_Prenotazione,Valida) values ("+idPrenotazione+","+idUtente+","+idEvento+",curdate(),"+1+")");
		return prenotato;
	}
}
