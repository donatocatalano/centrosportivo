package it.unisalento.pps.dao;

import java.util.ArrayList;
import java.util.Iterator;

import it.unisalento.pps.DbInterface.DbConnection;
import it.unisalento.pps.model.Iscrizione;

public class IscrizioneDAO {
	
	private static IscrizioneDAO instance;
	private Iscrizione iscrizione;
	
	public static IscrizioneDAO getInstance()
	{
	
	if (instance==null)
	{
		instance = new IscrizioneDAO();			
	}
	return instance;
	}

	public Iscrizione getIscrizioneById(int idIscrizione) {
		ArrayList<String[]> result=DbConnection.getInstance().eseguiQuery("select * from iscrizione where ID_Iscrizione=\""+ idIscrizione +"\" ");
		Iterator<String[]> iter = result.iterator();
		String[] tupla = iter.next();
		iscrizione=new Iscrizione(Integer.parseInt(tupla[0]),Integer.parseInt(tupla[4]),Integer.parseInt(tupla[5]),Integer.parseInt(tupla[6]));
		return  iscrizione;
	}
}