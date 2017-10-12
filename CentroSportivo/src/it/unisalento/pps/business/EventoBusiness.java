package it.unisalento.pps.business;

public class EventoBusiness {

private static EventoBusiness instance;
	
	public static EventoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new EventoBusiness();
		}
		return instance;
	}
	
}
