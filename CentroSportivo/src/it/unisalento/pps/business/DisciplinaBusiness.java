package it.unisalento.pps.business;

public class DisciplinaBusiness {
	
private static DisciplinaBusiness instance;
	
	public static DisciplinaBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new DisciplinaBusiness();
		}
		return instance;
	}
	

}
