package it.unisalento.pps.business;

public class PagamentoBusiness {
	
private static PagamentoBusiness instance;
	
	public static PagamentoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new PagamentoBusiness();
		}
		return instance;
	}
	

}
