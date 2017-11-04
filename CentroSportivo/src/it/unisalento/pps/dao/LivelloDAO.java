package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Livello;

public class LivelloDAO {
	
	private static LivelloDAO instance;
	private Livello livello;
	
	public static LivelloDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new LivelloDAO();			
	}
	return instance;
	}

	public ArrayList<Livello> getLivelli() {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from livello");
		
		ArrayList<Livello> livelli = new ArrayList<Livello>();
		Livello livello;
		
		for(int i=0;i<result.size();i++) {
			livello = new Livello(Integer.parseInt(result.get(i)[0]),result.get(i)[1]);
			livelli.add(livello);
		}
		return livelli;
	}

	public boolean cancellaLivello(Livello livello) {
		boolean ok_eliminazione = false;
		ok_eliminazione = DbConnection.getInstance().eseguiAggiornamento("Delete from livello where ID_Livello = \""+ livello.getIdLivello() +"\" ");
	
		return   ok_eliminazione;
	}

	public boolean inserisciLivello(String nome) {

		ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("select max(ID_Livello) from livello");
		Iterator<String[]> iter = risultato.iterator();
		String[] tupla = iter.next();
		int idLivello = Integer.parseInt(tupla[0]);
		
		boolean ok_inserimento = false;
		if(!(nome.isEmpty()))
			ok_inserimento = DbConnection.getInstance().eseguiAggiornamento("insert into livello (ID_Livello,Nome) values(\""+(idLivello+1)+"\",\""+nome+"\") ");

		return  ok_inserimento;
	}

	public Livello getLivelloById(int idLivello) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from livello where ID_Livello=\""+ idLivello +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		livello=new Livello(Integer.parseInt(tupla[0]),tupla[1]);
		return livello;
	}	
}