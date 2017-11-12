package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.PrenotazioneDAO;
import it.unisalento.pps.model.Prenotazione;

public class PrenotazioneBusiness {
	
private static PrenotazioneBusiness instance;
	
	public static PrenotazioneBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new PrenotazioneBusiness();
		}
		return instance;
	}
	
	public Prenotazione getPrenotazioneById(int idPrenotazione) {
		return PrenotazioneDAO.getInstance().getPrenotazioneById(idPrenotazione);
	}
	
	public ArrayList<Prenotazione> getPrenotazioniDaAutorizzare() {
		return PrenotazioneDAO.getInstance().getPrenotazioniDaAutorizzare();
	}

	public boolean autorizzaModificaPrenotazione(int prenotazione) {
		return PrenotazioneDAO.getInstance().autorizzaModificaPrenotazione(prenotazione);
	}

	public boolean cancellaPrenotazione(Prenotazione prenotazione) {
		return PrenotazioneDAO.getInstance().cancellaPrenotazione(prenotazione);
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return PrenotazioneDAO.getInstance().getPrenotazioni();
	}

	public boolean setPrenotazioneTesserato(int idUtente, int idEvento) {
		
		return PrenotazioneDAO.getInstance().setPrenotazioneTesserato(idUtente,idEvento);
		
	}

	public ArrayList<Prenotazione> getPrenotazioniByUtente(int idUtente) {
		
		return PrenotazioneDAO.getInstance().getPrenotazioniByUtente(idUtente);
	}

	public boolean setPrenotazioneValidaTesserato(int idUtente, int idEvento) {
		
		return PrenotazioneDAO.getInstance().setPrenotazioneValidaTesserato(idUtente,idEvento);
	}
}
