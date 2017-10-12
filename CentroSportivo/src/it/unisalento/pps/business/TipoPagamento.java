package it.unisalento.pps.business;

public class TipoPagamento {

private static TipoPagamento instance;
	
	public static TipoPagamento getInstance()
	{
		if(instance==null)
		{	
			instance = new TipoPagamento();
		}
		return instance;
	}
	
}
