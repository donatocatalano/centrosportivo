package it.unisalento.pps.dao;

import java.util.ArrayList;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;

public class DisciplinaDAO {
	
	private static DisciplinaDAO instance;
	
	public static DisciplinaDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new DisciplinaDAO();			
		}
		return instance;
	}
	/*
	public DisciplinaDAO restituiscidisciplina (String datidisc) {
		
		Disciplina d =new Disciplina();
		
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from disciplina");
		
		if(result.size() == 0) return null;
		
		return d;
		
		
	}*/
	
}