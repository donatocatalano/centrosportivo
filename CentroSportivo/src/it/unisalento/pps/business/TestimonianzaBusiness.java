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
		// TODO Auto-generated method stub
		return TestimonianzaDAO.getInstance().getTestimonianzeByDisciplina(IdDisciplina);
	}
	

}
