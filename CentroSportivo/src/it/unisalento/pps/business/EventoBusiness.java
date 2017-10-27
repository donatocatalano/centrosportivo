package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.DisciplinaDAO;
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
		// TODO Auto-generated method stub
		return EventoDAO.getInstance().getCorsiByIdIstruttore(idIstruttore);
	}

	public ArrayList<Evento> getEventiByIdIstruttore(int idIstruttore) {
		// TODO Auto-generated method stub
		return EventoDAO.getInstance().getEventiByIdIstruttore(idIstruttore);
	}
	
}
