package it.unisalento.pps.dao;


public class PrenotazioneDAO {
	
	private static PrenotazioneDAO instance;
	
	public static PrenotazioneDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new PrenotazioneDAO();			
	}
	return instance;
	}

		
}
