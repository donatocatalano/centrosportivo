package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.IscrizioneDAO;
import it.unisalento.pps.model.Iscrizione;

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
		return IscrizioneDAO.getInstance().getIscrizioniAutorizzate();
	}

	public boolean autorizzaIscrizione(int iscrizione,int responsabile) {
		return IscrizioneDAO.getInstance().autorizzaIscrizione(iscrizione,responsabile);
	}

	public boolean nuovaIscrizione(int idUtente, int idDisciplina, int livelloId) {
		
		return IscrizioneDAO.getInstance().nuovaIscrizione(idUtente,idDisciplina,livelloId);
	}

	public int getIdUltimaIscrizione() {
				return IscrizioneDAO.getInstance().getIdUltimaIscrizione();
	}
}
