package it.unisalento.pps.business;

import java.util.ArrayList;

import it.unisalento.pps.dao.TipoEventoDAO;
import it.unisalento.pps.dao.TipoPagamentoDAO;
import it.unisalento.pps.model.TipoEvento;
import it.unisalento.pps.model.TipoPagamento;

public class TipoPagamentoBusiness {

private static TipoPagamentoBusiness instance;

	public static TipoPagamentoBusiness getInstance()
	{
		if(instance==null)
		{	
			instance = new TipoPagamentoBusiness();
		}
		return instance;
	}
	
	public TipoPagamento getTipoPagamentoById(int idTipoPagamento) {
		return TipoPagamentoDAO.getInstance().getTipoPagamentoById(idTipoPagamento);
	}
	
	public ArrayList<TipoPagamento> getTipoNome() {
		return TipoPagamentoDAO.getInstance().getTipoNome();
	}

	public int getIdTipoPagamentoByNome(String tipo) {
		return TipoPagamentoDAO.getInstance().getIdTipoPagamentoByNome(tipo);
	}
}
