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
		pagamento=new Pagamento(Integer.parseInt(tupla[0]),Integer.parseInt(tupla[1]),Integer.parseInt(tupla[2]),Double.parseDouble(tupla[3]));
		return  pagamento;
	}

	public ArrayList<Pagamento> getPagamentiDaAutorizzare() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from pagamento where binary accettato = 0");
		
		ArrayList<Pagamento> pagamentiDaAutorizzare = new ArrayList<Pagamento>();
		Pagamento pagamento;
		for(int i=0;i<result.size();i++) {
			
			int anno = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno= Integer.parseInt((result.get(i)[1].substring(8,10)));
			
			GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi = data.getTimeInMillis();
			Date dataPagamento = new Date(millisecondi);
			
			pagamento = new Pagamento(Integer.parseInt(result.get(i)[0]),Integer.parseInt(result.get(i)[1]),Integer.parseInt(result.get(i)[2]),Double.parseDouble(result.get(i)[3]),dataPagamento,Integer.parseInt(result.get(i)[7]));
			pagamentiDaAutorizzare.add(pagamento);
		}
		return   pagamentiDaAutorizzare;
	}

	public boolean autorizzaIscrizione(int iscrizione) {
		
		boolean ok_autorizza = false;		
		ok_autorizza = DbConnection.getInstance().eseguiAggiornamento("UPDATE iscrizione SET accettata = '1', data_conferma = curdate() WHERE ID_Iscrizione = "+iscrizione+" ");
		return ok_autorizza;
	}
}
	
