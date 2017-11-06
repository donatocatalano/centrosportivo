package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Prenotazione;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AutorizzazioniModifichePrenotazioni;
import it.unisalento.pps.view.ElencoAutorizzazioni;

public class AscoltatoreAutPre implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Prenotazione prenotazione;
	
	
	public AscoltatoreAutPre(ElencoAutorizzazioni frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	

	public void actionPerformed(ActionEvent e) {
		new AutorizzazioniModifichePrenotazioni(responsabile, prenotazione);
		frame.dispose();
	}
}