package it.unisalento.pps.dao;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Iterator;
=======
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo.git

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;

public class DisciplinaDAO {
	
	private static DisciplinaDAO instance;
	private Disciplina disciplina;
	
	public static DisciplinaDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new DisciplinaDAO();			
		}
		return instance;
	}
<<<<<<< HEAD

	public Disciplina getDisciplinaByNome(String nome) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from disciplina where nome=\""+ nome +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		disciplina=new Disciplina(Integer.parseInt(tupla[0]),tupla[1],Double.parseDouble(tupla[2]),tupla[3],tupla[4]);
		return disciplina;
	}
=======
	/*
	public DisciplinaDAO restituiscidisciplina (String datidisc) {
		
		Disciplina d =new Disciplina();
		
		
		//SINGLETON
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from disciplina");
		
		if(result.size() == 0) return null;
		
		return d;
		
		
	}*/
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo.git
	
}