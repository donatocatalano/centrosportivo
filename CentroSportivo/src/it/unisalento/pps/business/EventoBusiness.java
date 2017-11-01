package it.unisalento.pps.business;

import java.sql.Date;
import java.util.ArrayList;

import it.unisalento.pps.dao.DisciplinaDAO;
import it.unisalento.pps.dao.EventoDAO;
import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;

public class EventoBusiness {

private static EventoBusiness instance;
	
	public static EventoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new EventoBusiness();
		}
		return instance;
	}

	public ArrayList<Evento> getCorsiByIdIstruttore(int idIstruttore) {
		return EventoDAO.getInstance().getCorsiByIdIstruttore(idIstruttore);
	}

	public ArrayList<Evento> getEventiByIdIstruttore(int idIstruttore) {
		return EventoDAO.getInstance().getEventiByIdIstruttore(idIstruttore);
	}
	
	public boolean registraEvento(Date datainizio, String orario, int istruttore, int spazio, int tipo, int disciplina, Date datafine) {

		return EventoDAO.getInstance().registraEvento(datainizio,orario,istruttore,spazio,tipo,disciplina,datafine);
	}

	public boolean registraCorso(Date datainizio, String orario, int istruttore, int spazio, int tipo, int disciplina, Date datafine) {

		return EventoDAO.getInstance().registraEvento(datainizio,orario,istruttore,spazio,tipo,disciplina,datafine);
	}
	
	public boolean cancellaEvento(Evento evento) {
		return EventoDAO.getInstance().cancellaEvento(evento);
	}
}
