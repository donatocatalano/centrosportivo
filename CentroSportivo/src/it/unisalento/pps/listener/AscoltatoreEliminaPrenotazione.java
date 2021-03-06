package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.model.Prenotazione;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AutorizzazioniModifichePrenotazioni;

public class AscoltatoreEliminaPrenotazione implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Prenotazione prenotazione;
	
	public AscoltatoreEliminaPrenotazione(AutorizzazioniModifichePrenotazioni frame, Responsabile responsabile, Prenotazione prenotazione) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
		this.prenotazione = prenotazione;
	}

	public void actionPerformed(ActionEvent e) {
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
				"Vuoi eliminare la prenotazione?",
				"ATTENZIONE !!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		
		if(n==0) {
			boolean ok = PrenotazioneBusiness.getInstance().cancellaPrenotazione(prenotazione);
			if(ok) {
			JOptionPane.showMessageDialog(null, "Prenotazione eliminata!");
			new AutorizzazioniModifichePrenotazioni(responsabile, prenotazione);
			frame.dispose();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Prenotazione non eliminata!");
		}
	}
}