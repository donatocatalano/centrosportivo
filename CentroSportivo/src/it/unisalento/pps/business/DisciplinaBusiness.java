package it.unisalento.pps.business;

import it.unisalento.pps.model.Disciplina;

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
	/*
	public boolean restituiscidisciplina (String nome) 
	{
		Disciplina d = new Disciplina ();
		return d.selezionadisciplina();
	}*/
	

}
