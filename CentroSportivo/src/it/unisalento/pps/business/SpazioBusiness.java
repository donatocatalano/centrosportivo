package it.unisalento.pps.business;

import it.unisalento.pps.dao.SpazioDAO;
import it.unisalento.pps.model.Spazio;

public class SpazioBusiness {
	
private static SpazioBusiness instance;
	
	Spazio spazio;
	
	public static SpazioBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new SpazioBusiness();
		}
		return instance;
	}

	public Spazio getSpazioById(int idSpazio) {
		spazio = SpazioDAO.getInstance().getSpazioById(idSpazio);
		return spazio;
	}
	

}
