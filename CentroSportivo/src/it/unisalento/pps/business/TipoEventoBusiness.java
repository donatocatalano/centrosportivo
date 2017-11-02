package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.TipoEventoDAO;
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

	public TipoEvento getTipoEventoById(int idTipo) {
		return TipoEventoDAO.getInstance().getTipoEventoById(idTipo);
	}
	
	public ArrayList<TipoEvento> getTipoNome() {
		return TipoEventoDAO.getInstance().getTipoNome();
	}

	public int getIdTipoEventoByNome(String tipo) {
		return TipoEventoDAO.getInstance().getIdTipoEventoByNome(tipo);
	}
}
