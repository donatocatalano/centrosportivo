package it.unisalento.pps.dao;

public class EventoDAO {
	
	private static EventoDAO instance;
	
	public static EventoDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new EventoDAO();			
		}
		return instance;
	}
	
}