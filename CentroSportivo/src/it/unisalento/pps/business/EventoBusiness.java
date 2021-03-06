package it.unisalento.pps.business;

import java.sql.Date;
import java.util.ArrayList;

import it.unisalento.pps.dao.EventoDAO;
import it.unisalento.pps.model.Evento;

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

	public ArrayList<Evento> getCorsi() {
		return EventoDAO.getInstance().getCorsi();
	}
	
	public ArrayList<Evento> getEventi() {
		return EventoDAO.getInstance().getEventi();
	}
	
	public Evento getEventoById(int idEvento) {
		return EventoDAO.getInstance().getEventoById(idEvento);
	}

	public ArrayList<Evento> getCorsiByIdDisciplina(int idDisciplina) {
		return EventoDAO.getInstance().getCorsiByIdDisciplina(idDisciplina);
	}
	
	public ArrayList<Evento> getEventiByIdDisciplina(int idDisciplina) {
		return EventoDAO.getInstance().getEventiByIdDisciplina(idDisciplina);
	}
	
	public ArrayList<Evento> getEventiCorsiByIdDisciplina(int idDisciplina) {
		return EventoDAO.getInstance().getEventiCorsiByIdDisciplina(idDisciplina);
	}
}
