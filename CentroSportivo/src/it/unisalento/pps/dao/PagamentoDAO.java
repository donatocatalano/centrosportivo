package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Pagamento;

public class PagamentoDAO {
	
	private static PagamentoDAO instance;
	
	private Pagamento pagamento;
	
	public static PagamentoDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new PagamentoDAO();			
	}
	return instance;
	}
	
	public Pagamento getPagamentoById(int idPagamento) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from pagamento where ID_Pagamento=\""+ idPagamento +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		pagamento=new Pagamento(Integer.parseInt(tupla[0]),Integer.parseInt(tupla[1]),Integer.parseInt(tupla[2]),Double.parseDouble(tupla[3]),Integer.parseInt(tupla[7]));
		return  pagamento;
	}

	public ArrayList<Pagamento> getPagamentiDaAutorizzare() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from pagamento where binary accettato = 0");
		
		ArrayList<Pagamento> pagamentiDaAutorizzare = new ArrayList<Pagamento>();
		Pagamento pagamento;
		System.out.println(result.size());
		
		
		for(int i=0;i<result.size();i++) {
			int anno = Integer.parseInt((result.get(i)[6].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[6].substring(5,7)));
			int giorno = Integer.parseInt((result.get(i)[6].substring(8,10)));
			GregorianCalendar date = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi = date.getTimeInMillis();
			Date data = new Date(millisecondi);
			
			pagamento = new Pagamento(Integer.parseInt(result.get(i)[0]),Integer.parseInt(result.get(i)[1]),Integer.parseInt(result.get(i)[2]),Double.parseDouble(result.get(i)[3]),data,Integer.parseInt(result.get(i)[7]));
			pagamentiDaAutorizzare.add(pagamento);
		}
		return  pagamentiDaAutorizzare;
	}

	public boolean autorizzaPagamento(int pagamento, int responsabile) {
		
		boolean ok_autorizza = false;		
		ok_autorizza = DbConnection.getInstance().eseguiAggiornamento("UPDATE pagamento SET accettato = '1', data_conferma = curdate(), responsabile = "+responsabile+" WHERE ID_Pagamento = "+pagamento+" ");
		return ok_autorizza;
	}
}