package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Iscrizione;

public class IscrizioneDAO {
	
	private static IscrizioneDAO instance;
	private Iscrizione iscrizione;
	Date fraUnAnno;
	
	public static IscrizioneDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new IscrizioneDAO();			
	}
	return instance;
	}

	public Iscrizione getIscrizioneById(int idIscrizione) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from iscrizione where ID_Iscrizione=\""+ idIscrizione +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		iscrizione=new Iscrizione(Integer.parseInt(tupla[0]),Integer.parseInt(tupla[4]),Integer.parseInt(tupla[5]),Integer.parseInt(tupla[6]));
		return  iscrizione;
	}

	public ArrayList<Iscrizione> getIscrizioniDaAutorizzare() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from iscrizione where binary accettata = 0");
		
		ArrayList<Iscrizione> iscrizioniDaAutorizzare = new ArrayList<Iscrizione>();
		Iscrizione iscrizione;
		for(int i=0;i<result.size();i++) {
			
			int anno_in = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_in = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_in= Integer.parseInt((result.get(i)[1].substring(8,10)));
			int anno_out = Integer.parseInt((result.get(i)[2].substring(0,4)));
			int mese_out = Integer.parseInt((result.get(i)[2].substring(5,7)));
			int giorno_out= Integer.parseInt((result.get(i)[2].substring(8,10)));
			GregorianCalendar dataIn = new GregorianCalendar(anno_in,mese_in-1,giorno_in);
			GregorianCalendar dataOut = new GregorianCalendar(anno_out,mese_out-1,giorno_out);
			long millisecondi_in = dataIn.getTimeInMillis();
			long millisecondi_out = dataOut.getTimeInMillis();
			Date dateIn = new Date(millisecondi_in);
			Date dateOut = new Date(millisecondi_out);
			
			iscrizione = new Iscrizione(Integer.parseInt(result.get(i)[0]),dateIn, dateOut, Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			iscrizioniDaAutorizzare.add(iscrizione);
		}
		return iscrizioniDaAutorizzare;
	}
	
	public ArrayList<Iscrizione> getIscrizioniAutorizzate() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from iscrizione where binary accettata = 1 ");
		
		ArrayList<Iscrizione> iscrizioniAutorizzate = new ArrayList<Iscrizione>();
		Iscrizione iscrizione;
		for(int i=0;i<result.size();i++) {
			
			int anno_in = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_in = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_in= Integer.parseInt((result.get(i)[1].substring(8,10)));
			int anno_out = Integer.parseInt((result.get(i)[2].substring(0,4)));
			int mese_out = Integer.parseInt((result.get(i)[2].substring(5,7)));
			int giorno_out= Integer.parseInt((result.get(i)[2].substring(8,10)));
			int anno_conferma = Integer.parseInt((result.get(i)[8].substring(0,4)));
			int mese_conferma = Integer.parseInt((result.get(i)[8].substring(5,7)));
			int giorno_conferma = Integer.parseInt((result.get(i)[8].substring(8,10)));
			GregorianCalendar dataIn = new GregorianCalendar(anno_in,mese_in-1,giorno_in);
			GregorianCalendar dataOut = new GregorianCalendar(anno_out,mese_out-1,giorno_out);
			GregorianCalendar dataconferma = new GregorianCalendar(anno_conferma,mese_conferma-1,giorno_conferma);
			long millisecondi_in = dataIn.getTimeInMillis();
			long millisecondi_out = dataOut.getTimeInMillis();
			long millisecondi_conferma = dataconferma.getTimeInMillis();
			Date dateIn = new Date(millisecondi_in);
			Date dateOut = new Date(millisecondi_out);
			Date dateconferma = new Date(millisecondi_conferma);
			
			iscrizione = new Iscrizione(Integer.parseInt(result.get(i)[0]),dateIn, dateOut,Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]),Integer.parseInt(result.get(i)[7]),dateconferma);
			iscrizioniAutorizzate.add(iscrizione);
		}
		return iscrizioniAutorizzate;
	}

	public boolean autorizzaIscrizione(int iscrizione,int responsabile) {
		
		boolean ok_autorizza = false;		
		ok_autorizza = DbConnection.getInstance().eseguiAggiornamento("UPDATE iscrizione SET accettata = '1', data_conferma = curdate(),responsabile ="+responsabile+" WHERE ID_Iscrizione = "+iscrizione+" ");
		return ok_autorizza;
	}

	public boolean nuovaIscrizione(int idUtente, int idDisciplina, int livelloId) {
		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Iscrizione) from iscrizione " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idIscrizione = Integer.parseInt(tupla[0]);
		
		Date now = new Date(System.currentTimeMillis());
		int anno = Integer.parseInt(now.toString().substring(0,4))+1;
		int mese = Integer.parseInt(now.toString().substring(5,7));
		int giorno= Integer.parseInt(now.toString().substring(8,10));
		GregorianCalendar gregorianDataOut = new GregorianCalendar(anno,mese-1,giorno);
		long mills= gregorianDataOut.getTimeInMillis();
		Date dataOut = new Date(mills);
		
		
		boolean ok_iscrizione = DbConnection.getInstance().eseguiAggiornamento("insert into iscrizione(ID_Iscrizione,DataIn,DataOut,Livello,Disciplina,Utente) values(\""+(idIscrizione+1)+"\",curdate(),\""+dataOut+"\",\""+livelloId+"\",\""+idDisciplina+"\",\""+idUtente+"\")");

		return  ok_iscrizione;
	}

	public int getIdUltimaIscrizione() {
		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Iscrizione) from iscrizione " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idIscrizione = Integer.parseInt(tupla[0]);
		return idIscrizione;
	}

	public ArrayList<Iscrizione> getIscrizioniByIdTesserato(int idUtente) {
		
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from iscrizione where Utente="+ idUtente + "");
		
		ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
		Iscrizione iscrizione;
		for(int i=0;i<result.size();i++) {
			
			int anno_in = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_in = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_in= Integer.parseInt((result.get(i)[1].substring(8,10)));
			int anno_out = Integer.parseInt((result.get(i)[2].substring(0,4)));
			int mese_out = Integer.parseInt((result.get(i)[2].substring(5,7)));
			int giorno_out= Integer.parseInt((result.get(i)[2].substring(8,10)));
			GregorianCalendar dataIn = new GregorianCalendar(anno_in,mese_in-1,giorno_in);
			GregorianCalendar dataOut = new GregorianCalendar(anno_out,mese_out-1,giorno_out);
			long millisecondi_in = dataIn.getTimeInMillis();
			long millisecondi_out = dataOut.getTimeInMillis();
			Date dateIn = new Date(millisecondi_in);
			Date dateOut = new Date(millisecondi_out);
			
			iscrizione = new Iscrizione(Integer.parseInt(result.get(i)[0]),dateIn, dateOut, Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			iscrizioni.add(iscrizione);
		}
		return iscrizioni;
	}
}