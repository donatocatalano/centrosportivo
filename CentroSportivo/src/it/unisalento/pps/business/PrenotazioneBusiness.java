package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.DisciplinaDAO;
import it.unisalento.pps.dao.PrenotazioneDAO;
import it.unisalento.pps.model.Disciplina;
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

	public boolean autorizzaPrenotazione(int prenotazione) {
		return PrenotazioneDAO.getInstance().autorizzaPrenotazione(prenotazione);
	}

	public boolean cancellaPrenotazione(Prenotazione prenotazione) {
		return PrenotazioneDAO.getInstance().cancellaPrenotazione(prenotazione);
	}
}
