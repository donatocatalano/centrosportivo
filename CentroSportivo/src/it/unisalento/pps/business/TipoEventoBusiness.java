package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.SpazioDAO;
import it.unisalento.pps.dao.TipoEventoDAO;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;

public class TipoEventoBusiness {

private static TipoEventoBusiness instance;
	
	public static TipoEventoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new TipoEventoBusiness();
		}
		return instance;
	}

	public TipoEvento getEventoById(int idTipo) {
		return TipoEventoDAO.getInstance().getEventoById(idTipo);
	}
	
	public ArrayList<TipoEvento> getTipoNome() {
		return TipoEventoDAO.getInstance().getTipoNome();
	}

	public int getIdTipoEventoByNome(String tipo) {
		// TODO Auto-generated method stub
		return TipoEventoDAO.getInstance().getIdTipoEventoByNome(tipo);
	}
}
