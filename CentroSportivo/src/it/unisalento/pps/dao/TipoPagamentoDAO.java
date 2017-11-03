package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.TipoPagamento;

public class TipoPagamentoDAO {
	
	private static TipoPagamentoDAO instance;
	private TipoPagamento tipo;
	
	public static TipoPagamentoDAO getInstance()
	{
	
		if (instance==null)
		{
		instance = new TipoPagamentoDAO();			
		}
		return instance;
	}

	public TipoPagamento getTipoPagamentoById(int idTipoPagamento) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipopagamento where ID_TipoPagamento=\""+ idTipoPagamento +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		tipo=new TipoPagamento(Integer.parseInt(tupla[0]),tupla[1]);
		return  tipo;
	}

	public ArrayList<TipoPagamento> getTipoNome() {		
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipoevento");
	
		ArrayList<TipoPagamento> tipi = new ArrayList<TipoPagamento>();
		TipoPagamento tipo;
	
		for(int i=0;i<result.size();i++) {
			tipo = new TipoPagamento(Integer.parseInt(result.get(i)[0]),result.get(i)[1]);
			tipi.add(tipo);
		}
		return tipi;
	}

	public int getIdTipoPagamentoByNome(String tipo) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from tipopagamento where Tipo=\""+ tipo +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		int tipoId=Integer.parseInt(tupla[0]);
		return tipoId;
	}
}