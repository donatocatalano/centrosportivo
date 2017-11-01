package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
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
		
	public ArrayList<Spazio> getSpazi() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from spazio");
		
		ArrayList<Spazio> spazi = new ArrayList<Spazio>();
		Spazio spazio;
		
		for(int i=0;i<result.size();i++) {
			spazio = new Spazio(Integer.parseInt(result.get(i)[0]),result.get(i)[1]);
			spazi.add(spazio);
		}
		return spazi;
	}

	public int getIdSpazioByNome(String spazio) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from spazio where Nome=\""+ spazio +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		int spazioId=Integer.parseInt(tupla[0]);
		return spazioId;
	}	
}