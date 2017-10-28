package it.unisalento.pps.business;

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

	public TipoEvento getEventoById(int idTipo) {
		// TODO Auto-generated method stub
		return TipoEventoDAO.getInstance().getEventoById(idTipo);
	}
	
}
