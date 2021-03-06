package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.PagamentoDAO;
import it.unisalento.pps.model.Pagamento;

public class PagamentoBusiness {
	
private static PagamentoBusiness instance;
	
	public static PagamentoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new PagamentoBusiness();
		}
		return instance;
	}
	
	public Pagamento getPagamentoById(int idPagamento) {
		return PagamentoDAO.getInstance().getPagamentoById(idPagamento);
	}
	
	public ArrayList<Pagamento> getPagamentiDaAutorizzare() {
		return PagamentoDAO.getInstance().getPagamentiDaAutorizzare();
	}
	
	public boolean autorizzaPagamento(int pagamento, int responsabile) {
		return PagamentoDAO.getInstance().autorizzaPagamento(pagamento, responsabile);
	}

	public boolean nuovoPagamento(int idUtente, int tipoPagamento, double totale, int idUltimaIscrizione) {
		
		return PagamentoDAO.getInstance().nuovoPagamento(idUtente,tipoPagamento,totale,idUltimaIscrizione);
	}
}
