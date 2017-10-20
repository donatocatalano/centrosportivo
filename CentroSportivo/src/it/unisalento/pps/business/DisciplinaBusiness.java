package it.unisalento.pps.business;

<<<<<<< HEAD
import it.unisalento.pps.dao.DisciplinaDAO;
=======
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo.git
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
	
	public Disciplina getDisciplinaByNome(String nome) {
		return DisciplinaDAO.getInstance().getDisciplinaByNome(nome);
	}
	

}
