package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Spazio;

public class SpazioDAO {
	
	private static PrenotazioneDAO instance;
	
	public static PrenotazioneDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new PrenotazioneDAO();			
	}
	return instance;
	}
	
	public Spazio getSpazioById(int idSpazio) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from spazio where ID_Spazio=\""+ idSpazio +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		disciplina=new Disciplina(Integer.parseInt(tupla[0]),tupla[1],Double.parseDouble(tupla[2]),tupla[3],tupla[4]);
		return disciplina;
	}
	
}