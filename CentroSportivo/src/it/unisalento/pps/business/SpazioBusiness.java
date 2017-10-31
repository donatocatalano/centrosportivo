package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.DisciplinaDAO;
import it.unisalento.pps.dao.SpazioDAO;
import it.unisalento.pps.model.Disciplina;
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
	
	public ArrayList<Spazio> getSpazi() {
		return SpazioDAO.getInstance().getSpazi();
	}

	public int getIdSpazioByNome(String spazio) {
		// TODO Auto-generated method stub
		return SpazioDAO.getInstance().getIdSpazioByNome(spazio);
	}
}
