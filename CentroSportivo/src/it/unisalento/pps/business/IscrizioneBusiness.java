package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.IscrizioneDAO;
import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Utente;

public class IscrizioneBusiness {
	
private static IscrizioneBusiness instance;
	
	public static IscrizioneBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new IscrizioneBusiness();
		}
		return instance;
	}
	
	public Iscrizione getIscrizioneById(int idIscrizione) {
		return IscrizioneDAO.getInstance().getIscrizioneById(idIscrizione);
	}
	
	public ArrayList<Iscrizione> getIscrizioniDaAutorizzare() {
		return IscrizioneDAO.getInstance().getIscrizioniDaAutorizzare();
	}
	
	public ArrayList<Iscrizione> getIscrizioniAutorizzate() {
		return IscrizioneDAO.getInstance().getIscrizioniDaAutorizzare();
	}

	public boolean autorizzaIscrizione(int iscrizione) {
		return IscrizioneDAO.getInstance().autorizzaIscrizione(iscrizione);
	}
}
