package it.unisalento.pps.dao;

public class TipoPagamentoDAO {
	
	private static TipoPagamentoDAO instance;
	
	public static TipoPagamentoDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new TipoPagamentoDAO();			
		}
		return instance;
	}
	
}