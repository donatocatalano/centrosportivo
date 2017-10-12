package it.unisalento.pps.business;

public class PrenotazioneBusiness {
	
private static PrenotazioneBusiness instance;
	
	public static PrenotazioneBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new PrenotazioneBusiness();
		}
		return instance;
	}
	

}
