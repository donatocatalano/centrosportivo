package it.unisalento.pps.dao;

public class LivelloDAO {
	
	private static LivelloDAO instance;
	
	public static LivelloDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new LivelloDAO();			
	}
	return instance;
	}
	
}