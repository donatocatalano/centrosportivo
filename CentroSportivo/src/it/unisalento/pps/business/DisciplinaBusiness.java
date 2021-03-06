package it.unisalento.pps.business;


import java.util.ArrayList;

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


	public ArrayList<Disciplina> getDiscipline() {
		return DisciplinaDAO.getInstance().getDiscipline();
	}


	public boolean registraDisciplina(String nome, Double costo, String immagine, String descrizione) {
		return DisciplinaDAO.getInstance().registraDisciplina(nome,costo,immagine,descrizione);
	}
	
	public boolean aggiornaDisciplina(int disciplina, String nome, Double costo, String immagine, String descrizione) {
		return DisciplinaDAO.getInstance().aggiornaDisciplina(disciplina, nome,costo,immagine,descrizione);
	}
	
	public Disciplina getDisciplinaById(int disciplina) {
		return DisciplinaDAO.getInstance().getDisciplinaById(disciplina);
	}


	public boolean cancellaDisciplina(Disciplina disciplina) {
		return DisciplinaDAO.getInstance().cancellaDisciplina(disciplina);
	}


	public int getIdDisciplinaByNome(String disciplina) {
		return DisciplinaDAO.getInstance().getIdDisciplinaByNome(disciplina);
	}
}


