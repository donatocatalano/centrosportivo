package it.unisalento.pps.business;

public class IscrizioneBusiness {
	
private static IscrizioneBusiness instance;
	
	public static IscrizioneBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new IscrizioneBusiness();
		}
		return instance;
	}
	

}
