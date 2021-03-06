package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.TestimonianzaDAO;
import it.unisalento.pps.model.Testimonianza;

public class TestimonianzaBusiness {
	
private static TestimonianzaBusiness instance;
	
	public static TestimonianzaBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new TestimonianzaBusiness();
		}
		return instance;
	}

	public ArrayList<Testimonianza> getTestimonianzeByIdDisciplina(int IdDisciplina) {
		return TestimonianzaDAO.getInstance().getTestimonianzeByDisciplina(IdDisciplina);
	}

	public boolean inserisciFeed(String contenuto, int tesserato, int disciplina) {
		return TestimonianzaDAO.getInstance().inserisciFeed(contenuto, tesserato, disciplina);
	}
}
