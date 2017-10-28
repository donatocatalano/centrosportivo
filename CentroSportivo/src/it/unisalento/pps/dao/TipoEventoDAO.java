package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;

public class TipoEventoDAO {
	
	private static TipoEventoDAO instance;
	private TipoEvento tipo;
	
	public static TipoEventoDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new TipoEventoDAO();			
		}
		return instance;
	}

	public TipoEvento getEventoById(int idTipo) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipoevento where ID_TipoEvento=\""+ idTipo +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		tipo=new TipoEvento(Integer.parseInt(tupla[0]),tupla[1]);
		return tipo;
	}
	
}