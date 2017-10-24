package it.unisalento.pps.business;


import it.unisalento.pps.dao.DisciplinaDAO;
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
	
	
	public Disciplina getDisciplinaByNome(String nome) {
		return DisciplinaDAO.getInstance().getDisciplinaByNome(nome);
	}
}
