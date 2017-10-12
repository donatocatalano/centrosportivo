package it.unisalento.pps.business;

import it.unisalento.pps.model.Responsabile;

public class ResponsabileBusiness {
	
private static ResponsabileBusiness instance;
	
	public static ResponsabileBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new ResponsabileBusiness();
		}
		return instance;
	}
	
	public boolean verificaLogin(String username, String password)
	{
		Responsabile r = new Responsabile (username, password);
		return r.login();
	}

}
