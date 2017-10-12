package it.unisalento.pps.business;

public class SpazioBusiness {
	
private static SpazioBusiness instance;
	
	public static SpazioBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new SpazioBusiness();
		}
		return instance;
	}
	

}
