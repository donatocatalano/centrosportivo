package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Evento;

public class EventoDAO {
	
	private static EventoDAO instance;
	
	public static EventoDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new EventoDAO();			
		}
		return instance;
	}

	public ArrayList<Evento> getCorsiByIdIstruttore(int idIstruttore) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from EVENTO where (Istruttore = \""+idIstruttore+"\" ) and (tipo = 3)");
		
		ArrayList<Evento> corsi = new ArrayList<Evento>();
		Evento corso;
		
		
		for(int i=0;i<result.size();i++) {
			int anno_inizio = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_inizio = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_inizio = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataInizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
			long millisecondi_inizio = dataInizio.getTimeInMillis();
			Date data_inizio = new Date(millisecondi_inizio);
			
			int anno_fine = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
			long millisecondi_fine = dataFine.getTimeInMillis();
			Date data_fine = new Date(millisecondi_fine);
			corso = new Evento(Integer.parseInt(result.get(i)[0]),data_inizio,data_fine,result.get(i)[2],idIstruttore,Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			corsi.add(corso);
		}
		return corsi;
	}

	public ArrayList<Evento> getEventiByIdIstruttore(int idIstruttore) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from EVENTO where (Istruttore = \""+idIstruttore+"\" ) and ((tipo = 1) or (tipo = 2))");
		
		ArrayList<Evento> eventi = new ArrayList<Evento>();
		Evento evento;
		
		for(int i=0;i<result.size();i++) {
			int anno_inizio = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_inizio = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_inizio = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataInizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
			long millisecondi_inizio = dataInizio.getTimeInMillis();
			Date data_inizio = new Date(millisecondi_inizio);
			
			int anno_fine = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
			long millisecondi_fine = dataFine.getTimeInMillis();
			Date data_fine = new Date(millisecondi_fine);
			evento = new Evento(Integer.parseInt(result.get(i)[0]),data_inizio,data_fine,result.get(i)[2],idIstruttore,Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			eventi.add(evento);
			System.out.println(eventi.get(i).getTurno());
		}
		return eventi;
	}
}