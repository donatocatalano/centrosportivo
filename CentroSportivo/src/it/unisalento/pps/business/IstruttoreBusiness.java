package it.unisalento.pps.business;

import it.unisalento.pps.model.Istruttore;

public class IstruttoreBusiness {
	
private static IstruttoreBusiness instance;
	
	public static IstruttoreBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new IstruttoreBusiness();
		}
		return instance;
	}
	
	public boolean verificaLogin(String username, String password)
	{
		Istruttore i = new Istruttore (username, password);
		return i.login();
	}

}
