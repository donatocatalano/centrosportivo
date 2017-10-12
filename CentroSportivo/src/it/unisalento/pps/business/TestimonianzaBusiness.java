package it.unisalento.pps.business;

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
	

}
