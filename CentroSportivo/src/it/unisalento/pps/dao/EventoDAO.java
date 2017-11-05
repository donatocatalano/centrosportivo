package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Evento;

public class EventoDAO {
	
	private static EventoDAO instance;
	private Evento evento;
	
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
			
			int anno_fine = Integer.parseInt((result.get(i)[7].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[7].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[7].substring(8,10)));
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
			
			int anno_fine = Integer.parseInt((result.get(i)[7].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[7].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[7].substring(8,10)));
			GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
			long millisecondi_fine = dataFine.getTimeInMillis();
			Date data_fine = new Date(millisecondi_fine);
			evento = new Evento(Integer.parseInt(result.get(i)[0]),data_inizio,data_fine,result.get(i)[2],idIstruttore,Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			eventi.add(evento);
		}
		return eventi;
	}
	
	public ArrayList<Evento> getCorsiByIdDisciplina(int idDisciplina) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from EVENTO where (Disciplina = \""+idDisciplina+"\") and (tipo = 3)");
		
		ArrayList<Evento> eventi = new ArrayList<Evento>();
		Evento evento;
		
		for(int i=0;i<result.size();i++) {
			int anno_inizio = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_inizio = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_inizio = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataInizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
			long millisecondi_inizio = dataInizio.getTimeInMillis();
			Date data_inizio = new Date(millisecondi_inizio);
			
			int anno_fine = Integer.parseInt((result.get(i)[7].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[7].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[7].substring(8,10)));
			GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
			long millisecondi_fine = dataFine.getTimeInMillis();
			Date data_fine = new Date(millisecondi_fine);
			evento = new Evento(Integer.parseInt(result.get(i)[0]),data_inizio,data_fine,result.get(i)[2],Integer.parseInt(result.get(i)[3]),Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),idDisciplina);
			eventi.add(evento);
		}
		return eventi;
	}
		
	public ArrayList<Evento> getEventi() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from EVENTO where (tipo=1) and (tipo=2)");
		
		ArrayList<Evento> eventi = new ArrayList<Evento>();
		Evento evento;
		
		for(int i=0;i<result.size();i++) {
			int anno_inizio = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_inizio = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_inizio = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataInizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
			long millisecondi_inizio = dataInizio.getTimeInMillis();
			Date data_inizio = new Date(millisecondi_inizio);
			
			int anno_fine = Integer.parseInt((result.get(i)[7].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[7].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[7].substring(8,10)));
			GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
			long millisecondi_fine = dataFine.getTimeInMillis();
			Date data_fine = new Date(millisecondi_fine);
			evento = new Evento(Integer.parseInt(result.get(i)[0]),data_inizio,data_fine,result.get(i)[2],Integer.parseInt(result.get(i)[3]),Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			eventi.add(evento);
		}
		return eventi;
	}
	
	public ArrayList<Evento> getCorsi() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from EVENTO where Tipo = 3");
		
		ArrayList<Evento> eventi = new ArrayList<Evento>();
		Evento evento;
		
		for(int i=0;i<result.size();i++) {
			int anno_inizio = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_inizio = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_inizio = Integer.parseInt((result.get(i)[1].substring(8,10)));
			GregorianCalendar dataInizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
			long millisecondi_inizio = dataInizio.getTimeInMillis();
			Date data_inizio = new Date(millisecondi_inizio);
			
			int anno_fine = Integer.parseInt((result.get(i)[7].substring(0,4)));
			int mese_fine = Integer.parseInt((result.get(i)[7].substring(5,7)));
			int giorno_fine = Integer.parseInt((result.get(i)[7].substring(8,10)));
			GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
			long millisecondi_fine = dataFine.getTimeInMillis();
			Date data_fine = new Date(millisecondi_fine);
			evento = new Evento(Integer.parseInt(result.get(i)[0]),data_inizio,data_fine,result.get(i)[2],Integer.parseInt(result.get(i)[3]),Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			eventi.add(evento);
		}
		return eventi;
	}

	public boolean registraEvento(Date datainizio, String orario, int istruttore, int spazio, int tipo, int disciplina, Date datafine) {
		
		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Evento) from evento " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idEvento = Integer.parseInt(tupla[0]);
		
		boolean ok_inserimento = false;
		if(!orario.isEmpty())
			ok_inserimento = DbConnection.getInstance().eseguiAggiornamento("insert into evento(ID_Evento,Data_Inizio,Turno,Istruttore,Spazio,Tipo,Disciplina,Data_Fine) values(\""+(idEvento+1)+"\",\""+datainizio+"\",\""+orario+"\",\""+istruttore+"\",\""+spazio+"\",\""+tipo+"\",\""+disciplina+"\",\""+datafine+"\")");

		return  ok_inserimento;
	}

	public boolean registraCorso(Date datainizio, String orario, int istruttore, int spazio, int tipo, int disciplina, Date datafine) {
		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Evento) from evento " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idEvento = Integer.parseInt(tupla[0]);
		
		boolean ok_inserimento = false;
		if(!orario.isEmpty())
			ok_inserimento = DbConnection.getInstance().eseguiAggiornamento("insert into evento(ID_Evento,Data_Inizio,Turno,Istruttore,Spazio,Tipo,Disciplina,Data_Fine) values(\""+(idEvento+1)+"\",\""+datainizio+"\",\""+orario+"\",\""+istruttore+"\",\""+spazio+"\",\""+tipo+"\",\""+disciplina+"\",\""+datafine+"\")");

		return  ok_inserimento;
	}

	public boolean cancellaEvento(Evento evento) {
		boolean ok_eliminazione = false;
		ok_eliminazione = DbConnection.getInstance().eseguiAggiornamento("Delete from evento where ID_Evento = \""+ evento.getIdEvento() +"\" ");
		
		return   ok_eliminazione;
	}
	
	public Evento getEventoById(int idEvento) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from evento where ID_Evento=\""+ idEvento +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		int anno_inizio = Integer.parseInt((tupla[1].substring(0,4)));
		int mese_inizio = Integer.parseInt((tupla[1].substring(5,7)));
		int giorno_inizio = Integer.parseInt((tupla[1].substring(8,10)));
		GregorianCalendar dataInizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
		long millisecondi_inizio = dataInizio.getTimeInMillis();
		Date data_inizio = new Date(millisecondi_inizio);
		
		int anno_fine = Integer.parseInt((tupla[7].substring(0,4)));
		int mese_fine = Integer.parseInt((tupla[7].substring(5,7)));
		int giorno_fine = Integer.parseInt((tupla[7].substring(8,10)));
		GregorianCalendar dataFine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
		long millisecondi_fine = dataFine.getTimeInMillis();
		Date data_fine = new Date(millisecondi_fine);
		evento=new Evento(Integer.parseInt(tupla[0]),data_inizio,data_fine,tupla[2],Integer.parseInt(tupla[3]),Integer.parseInt(tupla[4]),Integer.parseInt(tupla[5]),Integer.parseInt(tupla[6]));
		return  evento;
	}
}