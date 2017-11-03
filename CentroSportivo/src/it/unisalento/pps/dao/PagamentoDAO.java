package it.unisalento.pps.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Iscrizione;
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
			
			int anno_in = Integer.parseInt((result.get(i)[1].substring(0,4)));
			int mese_in = Integer.parseInt((result.get(i)[1].substring(5,7)));
			int giorno_in= Integer.parseInt((result.get(i)[1].substring(8,10)));
			int anno_out = Integer.parseInt((result.get(i)[2].substring(0,4)));
			int mese_out = Integer.parseInt((result.get(i)[2].substring(5,7)));
			int giorno_out= Integer.parseInt((result.get(i)[2].substring(8,10)));
			GregorianCalendar dataIn = new GregorianCalendar(anno_in,mese_in-1,giorno_in);
			GregorianCalendar dataOut = new GregorianCalendar(anno_out,mese_out-1,giorno_out);
			long millisecondi_in = dataIn.getTimeInMillis();
			long millisecondi_out = dataOut.getTimeInMillis();
			Date dateIn = new Date(millisecondi_in);
			Date dateOut = new Date(millisecondi_out);
			
			pagamento = new Pagamento(Integer.parseInt(result.get(i)[0]),dateIn, dateOut, Integer.parseInt(result.get(i)[4]),Integer.parseInt(result.get(i)[5]),Integer.parseInt(result.get(i)[6]));
			pagamentiDaAutorizzare.add(pagamenti);
		}
		return pagamentiDaAutorizzare;
	}

	public boolean autorizzaIscrizione(int iscrizione) {
		
		boolean ok_autorizza = false;		
		ok_autorizza = DbConnection.getInstance().eseguiAggiornamento("UPDATE iscrizione SET accettata = '1', data_conferma = curdate() WHERE ID_Iscrizione = "+iscrizione+" ");
		return ok_autorizza;
	}
}
	
}