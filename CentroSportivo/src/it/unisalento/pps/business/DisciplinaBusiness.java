package it.unisalento.pps.business;


import java.sql.Date;
import java.util.ArrayList;

import it.unisalento.pps.dao.DisciplinaDAO;
import it.unisalento.pps.dao.EventoDAO;
import it.unisalento.pps.dao.TestimonianzaDAO;
import it.unisalento.pps.dao.UtenteDAO;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;

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


	public boolean registraDisciplina(String nome, Double costo, String descrizione) {

		return DisciplinaDAO.getInstance().registraDisciplina(nome, costo, descrizione);
	}
	
	
	public Disciplina getDisciplinaById(int disciplina) {
		return DisciplinaDAO.getInstance().getDisciplinaById(disciplina);
	}
}


