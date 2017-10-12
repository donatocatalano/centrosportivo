package it.unisalento.pps.dao;

public class IscrizioneDAO {
	
	private static IscrizioneDAO instance;
	
	public static IscrizioneDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new IscrizioneDAO();			
	}
	return instance;
	}
	
}