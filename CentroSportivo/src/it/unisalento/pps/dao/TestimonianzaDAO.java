package it.unisalento.pps.dao;

public class TestimonianzaDAO {
	
	private static TestimonianzaDAO instance;
	
	public static TestimonianzaDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new TestimonianzaDAO();			
		}
		return instance;
	}
	
}