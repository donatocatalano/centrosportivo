package it.unisalento.pps.business;

public class TipoEventoBusiness {

private static TipoEventoBusiness instance;
	
	public static TipoEventoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new TipoEventoBusiness();
		}
		return instance;
	}
	
}
