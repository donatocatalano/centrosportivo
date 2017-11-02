package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
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

	public TipoEvento getTipoEventoById(int idTipo) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipoevento where ID_TipoEvento=\""+ idTipo +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		tipo=new TipoEvento(Integer.parseInt(tupla[0]),tupla[1]);
		return tipo;
	}
	
	public ArrayList<TipoEvento> getTipoNome() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipoevento");
		
		ArrayList<TipoEvento> tipi = new ArrayList<TipoEvento>();
		TipoEvento tipo;
		
		for(int i=0;i<result.size();i++) {
			tipo = new TipoEvento(Integer.parseInt(result.get(i)[0]),result.get(i)[1]);
			tipi.add(tipo);
		}
		return tipi;
	}

	public int getIdTipoEventoByNome(String tipo) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipoevento where Tipo=\""+ tipo +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		int tipoId=Integer.parseInt(tupla[0]);
		return tipoId;
	}	
	
}