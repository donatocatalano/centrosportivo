package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;
import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Testimonianza;

public class TestimonianzaDAO {
	
	private static TestimonianzaDAO instance;
	
	public static TestimonianzaDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new TestimonianzaDAO();			
		}
		return instance;
	}

	public ArrayList<Testimonianza> getTestimonianzeByDisciplina(int IdDisciplina) {
		
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from testimonianza where binary disciplina=\""+ IdDisciplina +"\" ");
				
		ArrayList<Testimonianza> testimonianze = new ArrayList<Testimonianza>();
		Testimonianza testimonianza;
		for(int i=0;i<result.size();i++) {
			testimonianza = new Testimonianza(Integer.parseInt(result.get(i)[0]),result.get(i)[2],Integer.parseInt(result.get(i)[3]),Integer.parseInt(result.get(i)[4]));
			testimonianze.add(testimonianza);
		}
		return testimonianze;
	}
}