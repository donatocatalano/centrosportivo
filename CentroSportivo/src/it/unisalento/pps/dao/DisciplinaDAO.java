package it.unisalento.pps.dao;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Testimonianza;
import it.unisalento.pps.model.Utente;

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
	
	public boolean registraDisciplina(String nome, Double costo, String descrizione) {

		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select count(*) from disciplina " );
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idDisciplina = Integer.parseInt(tupla[0]);
		
		boolean ok_inserimento = false;
		if(!(nome.isEmpty()||(costo==0)||descrizione.isEmpty()))
			ok_inserimento = DbConnection.getInstance().eseguiAggiornamento("insert into disciplina(ID_Disciplina,Nome,CostoMensile,Descrizione) values(\""+(idDisciplina+1)+"\",\""+nome+"\",\""+costo+"\",\""+descrizione+"\")");

		return  ok_inserimento;
	}
	
	public ArrayList<Disciplina> getDisciplineByIdDisciplina() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from disciplina ");
		
		ArrayList<Disciplina> DisciplineByIdDisciplina = new ArrayList<Disciplina>();
		Disciplina disciplina;
		for(int i=0;i<result.size();i++) {
			disciplina = new Disciplina(Integer.parseInt(result.get(i)[0]),result.get(i)[1],Double.parseDouble(result.get(i)[2]), result.get(i)[4]);
			DisciplineByIdDisciplina.add(disciplina);
		}
		return DisciplineByIdDisciplina;
	}
}