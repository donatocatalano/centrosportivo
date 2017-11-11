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
	
	
	
	public AscoltatorePrenotazioni(AreaPrenotazioni frame, Utente tesserato,ArrayList<Integer> eventi) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.idEventiSelezionati = eventi;
	}
	
	

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
		boolean prenotato=false;
		for(int i=0;i<idEventiSelezionati.size();i++) {
			Evento evento = EventoBusiness.getInstance().getEventoById(idEventiSelezionati.get(i));
			boolean ok= eventiSelezionati.add(evento);
			for(int j=0;j<prenotazioni.size();j++) {
			//if(idEventiSelezionati.get(i) != prenotazioni.get(j).getIdPrenotazione()) {
				// inserire controllo prenotazioni
				prenotato=PrenotazioneBusiness.getInstance().setPrenotazioneTesserato(tesserato.getIdUtente(),idEventiSelezionati.get(i));
				
				//}
			}
		}
		if(prenotato) {
			JOptionPane.showMessageDialog(null, "Richiesta effettuata procedi con la stampa della ricevuta !");
			new AreaPrenotazioni(tesserato);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Non è stato possibile inviare richiesta.Riprova più tardi !");
		}
	}
}