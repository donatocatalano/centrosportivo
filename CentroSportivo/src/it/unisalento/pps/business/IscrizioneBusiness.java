package it.unisalento.pps.business;

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
}
