package it.unisalento.pps.dao;

public class PagamentoDAO {
	
	private static PagamentoDAO instance;
	
	public static PagamentoDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new PagamentoDAO();			
	}
	return instance;
	}
	
}