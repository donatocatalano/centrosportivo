package it.unisalento.pps.business;

public class LivelloBusiness {
	
private static LivelloBusiness instance;
	
	public static LivelloBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new LivelloBusiness();
		}
		return instance;
	}
	

}
