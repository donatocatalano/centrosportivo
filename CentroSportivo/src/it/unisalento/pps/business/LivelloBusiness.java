package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.LivelloDAO;
import it.unisalento.pps.model.Livello;

public class LivelloBusiness {
	
private static LivelloBusiness instance;

	Livello livello;
	
	public static LivelloBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new LivelloBusiness();
		}
		return instance;
	}

	public ArrayList<Livello> getLivelli() {
		return LivelloDAO.getInstance().getLivelli();
	}

	public boolean cancellaLivello(Livello livello) {
		return LivelloDAO.getInstance().cancellaLivello(livello);
	}

	public boolean inserisciLivello(String livello) {
		return LivelloDAO.getInstance().inserisciLivello(livello);
	}

	public Livello getLivelloById(int idLivello) {
		livello = LivelloDAO.getInstance().getLivelloById(idLivello);
		return livello;
	}
}
