package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.swing.*;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.model.*;
import it.unisalento.pps.view.AreaPrenotazioni;



public class AscoltatoreStampa implements ActionListener {
	
	private AreaPrenotazioni frame;
	private Utente tesserato;
	private ArrayList<Integer> idEventiSelezionati = new ArrayList<Integer>();
	private ArrayList<Evento> eventiSelezionati = new ArrayList<Evento>();
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	PrintWriter out;
	
	
	
	public AscoltatoreStampa(AreaPrenotazioni frame, Utente tesserato,ArrayList<Integer> ideventiselezionati) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.idEventiSelezionati = ideventiselezionati;
	}
	
	

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
		
		
		prenotazioni = PrenotazioneBusiness.getInstance().getPrenotazioniByUtente(tesserato.getIdUtente());
		Disciplina disciplina;
		Spazio spazio;
		TipoEvento tipo;
		
		
		if(prenotazioni.size()==0)
		{
			JOptionPane.showMessageDialog(null, "Non è stato selezionato nessun corso o evento");
			
				}
		else if(prenotazioni.size() > 0) {
			
			for(int j=0;j<idEventiSelezionati.size();j++) {
				
				Evento evento = EventoBusiness.getInstance().getEventoById(idEventiSelezionati.get(j));
				boolean ok= eventiSelezionati.add(evento);
											}
								}
		try
        {
  		out = new PrintWriter("Prenotazioni/prenotazione.txt");
  		
  		out.println("\n        			 Corsi / Eventi scelti da "+tesserato.getNome().toUpperCase()+ " "+tesserato.getCognome().toUpperCase()+"\n\n\n");
  				
  			
  		for(int i=0;i<eventiSelezionati.size();i++) {
  			
  			disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(eventiSelezionati.get(i).getDisciplina());
			spazio = SpazioBusiness.getInstance().getSpazioById(eventiSelezionati.get(i).getSpazio());
			tipo = TipoEventoBusiness.getInstance().getTipoEventoById(eventiSelezionati.get(i).getTipo());
			
			String giorno_inizio = eventiSelezionati.get(i).getDataInizio().toString().substring(8,10);
			String mese_inizio = eventiSelezionati.get(i).getDataInizio().toString().substring(5,7);
			String anno_inizio =eventiSelezionati.get(i).getDataInizio().toString().substring(0,4);	
		
			String giorno_fine = eventiSelezionati.get(i).getDataFine().toString().substring(8,10);
			String mese_fine = eventiSelezionati.get(i).getDataFine().toString().substring(5,7);
			String anno_fine =eventiSelezionati.get(i).getDataFine().toString().substring(0,4);	
			
  			out.println("                 "+tipo.getTipo().toUpperCase()+" di " +disciplina.getNome().toUpperCase()+ "  inizia il :  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   orario :  " +eventiSelezionati.get(i).getTurno()+ "   termina il :  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome()+"\n\n");
			
										}
			
		    
		    	
		        JOptionPane.showMessageDialog(null, "Prenotazione stampata su file.Premi ok per proseguire.");
		     
		         
        }

		catch (FileNotFoundException e1) 
             {			
	             e1.printStackTrace();
             }
		catch(NullPointerException t)
                     {}
	
		finally
		{ 
			out.close();
		}
	
		/*if(prenotato) {
			
			JOptionPane.showMessageDialog(null, "Richiesta effettuata procedi con la stampa della ricevuta !");
			new AreaPrenotazioni(tesserato);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Non è stato possibile inviare richiesta.Non sono state rilevate modifiche!");
		}*/
	}
}