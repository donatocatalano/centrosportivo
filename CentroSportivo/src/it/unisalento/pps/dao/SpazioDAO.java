package it.unisalento.pps.dao;

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
	
}