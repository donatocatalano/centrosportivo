package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;

import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.model.*;
import it.unisalento.pps.view.AreaPrenotazioni;



public class AscoltatorePrenotazioni implements ActionListener {
	
	private AreaPrenotazioni frame;
	private Utente tesserato;
	private ArrayList<Integer> idEventiSelezionati = new ArrayList<Integer>();
	private ArrayList<Evento> eventiSelezionati = new ArrayList<Evento>();
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	
	
	
	public AscoltatorePrenotazioni(AreaPrenotazioni frame, Utente tesserato,ArrayList<Integer> ideventiselezionati) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.idEventiSelezionati = ideventiselezionati;
	}
	
	

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
		boolean prenotato=false;
		boolean prenotazioneGiaPresente=false;
		System.out.println(idEventiSelezionati);
		prenotazioni = PrenotazioneBusiness.getInstance().getPrenotazioniByUtente(tesserato.getIdUtente());
		System.out.println("adesso : " +prenotazioni.size());
		
		if(prenotazioni.size()==0)
		{
			for(int i=0;i<idEventiSelezionati.size();i++) {
				Evento evento = EventoBusiness.getInstance().getEventoById(idEventiSelezionati.get(i));
				boolean ok= eventiSelezionati.add(evento);
				prenotato=PrenotazioneBusiness.getInstance().setPrenotazioneTesserato(tesserato.getIdUtente(),evento.getIdEvento());
												}
				}
		else if(prenotazioni.size() > 0) {
			for(int j=0;j<idEventiSelezionati.size();j++) {
				prenotazioneGiaPresente=false;
				Evento evento = EventoBusiness.getInstance().getEventoById(idEventiSelezionati.get(j));
				boolean ok= eventiSelezionati.add(evento);
					for(int i=0;i<prenotazioni.size();i++) {
									if(idEventiSelezionati.get(j) == prenotazioni.get(i).getEvento()) {
											prenotazioneGiaPresente = true;
																}
														}
					if(!prenotazioneGiaPresente) {
						prenotato=PrenotazioneBusiness.getInstance().setPrenotazioneTesserato(tesserato.getIdUtente(),idEventiSelezionati.get(j));
					}
											}
								}
		if(prenotato) {
			
			JOptionPane.showMessageDialog(null, "Richiesta effettuata procedi con la stampa della ricevuta !");
			new AreaPrenotazioni(tesserato);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Non è stato possibile inviare richiesta.Non sono state rilevate modifiche!");
		}
	}
}