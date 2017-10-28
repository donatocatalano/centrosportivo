package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Spazio;

public class SpazioDAO {
		
	private static SpazioDAO instance;
	private Spazio spazio;
	
	public static SpazioDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new SpazioDAO();			
	}
	return instance;
	}
	
	public Spazio getSpazioById(int idSpazio) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from spazio where ID_Spazio=\""+ idSpazio +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		spazio=new Spazio(Integer.parseInt(tupla[0]),tupla[1]);
		return spazio;
	}
	
}