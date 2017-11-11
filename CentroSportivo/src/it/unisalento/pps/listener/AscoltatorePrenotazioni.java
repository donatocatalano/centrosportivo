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
		prenotazioni = PrenotazioneBusiness.getInstance().getPrenotazioniByUtente(tesserato.getIdUtente());
		//System.out.println(prenotazioni.size());
		for(int i=0;i<idEventiSelezionati.size();i++) {
			Evento evento = EventoBusiness.getInstance().getEventoById(idEventiSelezionati.get(i));
			boolean ok= eventiSelezionati.add(evento);
			for(int j=0;j<prenotazioni.size();j++) {
				System.out.println(evento.getIdEvento());
			if(evento.getIdEvento() != prenotazioni.get(j).getEvento()) {
				System.out.println(prenotazioni.get(j).getEvento());
				prenotato=PrenotazioneBusiness.getInstance().setPrenotazioneTesserato(tesserato.getIdUtente(),evento.getIdEvento());
				
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