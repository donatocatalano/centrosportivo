package it.unisalento.pps.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Testimonianza;

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


	public Disciplina getDisciplinaByNome(String nome) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from disciplina where nome=\""+ nome +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		disciplina=new Disciplina(Integer.parseInt(tupla[0]),tupla[1],Double.parseDouble(tupla[2]),tupla[3],tupla[4]);
		return disciplina;
	}


	public ArrayList<Disciplina> getDiscipline() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from disciplina");
		
		ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
		Disciplina disciplina;
		
		for(int i=0;i<result.size();i++) {
			disciplina = new Disciplina(Integer.parseInt(result.get(i)[0]),result.get(i)[1],Double.parseDouble(result.get(i)[2]),result.get(i)[3],result.get(i)[4]);
			discipline.add(disciplina);
				
		}
		return discipline;
	}	
}