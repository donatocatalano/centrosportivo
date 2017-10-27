package it.unisalento.pps.business;


import java.util.ArrayList;

import it.unisalento.pps.dao.DisciplinaDAO;
import it.unisalento.pps.dao.TestimonianzaDAO;
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


	public ArrayList<Disciplina> getDiscipline() {
		// TODO Auto-generated method stub
		return DisciplinaDAO.getInstance().getDiscipline();
	}
}
