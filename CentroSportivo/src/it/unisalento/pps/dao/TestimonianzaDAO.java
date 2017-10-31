package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
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
			
			
				int anno = Integer.parseInt((result.get(i)[1].substring(0,4)));
				int mese = Integer.parseInt((result.get(i)[1].substring(5,7)));
				int giorno= Integer.parseInt((result.get(i)[1].substring(8,10)));
				GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
				long millisecondi_inizio = data.getTimeInMillis();
				Date date = new Date(millisecondi_inizio);
				
							
			testimonianza = new Testimonianza(Integer.parseInt(result.get(i)[0]),date,result.get(i)[2],Integer.parseInt(result.get(i)[3]),Integer.parseInt(result.get(i)[4]));
			testimonianze.add(testimonianza);
		}
		return testimonianze;
	}
}