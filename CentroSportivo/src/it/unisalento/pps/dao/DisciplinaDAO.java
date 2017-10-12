package it.unisalento.pps.dao;

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
	
}