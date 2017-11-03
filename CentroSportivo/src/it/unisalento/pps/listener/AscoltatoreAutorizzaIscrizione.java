package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.model.Prenotazione;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AutorizzazioniIscrizione;

public class AscoltatoreAutorizzaIscrizione implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	
	private Prenotazione prenotazione;

	public AscoltatoreAutorizzaIscrizione(AutorizzazioniIscrizione frame, Responsabile responsabile, Prenotazione prenotazione) {
		this.frame = frame;
		this.responsabile = responsabile;
		this.prenotazione = prenotazione;
	}
	
	public void actionPerformed(ActionEvent e){
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi autorizzare l'iscrizione?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(n==0) {
			boolean ok = PrenotazioneBusiness.getInstance().autorizzaPrenotazione(prenotazione.getIdPrenotazione());
			JOptionPane.showMessageDialog(null, "Iscrizione autorizzata!");
			new AutorizzazioniIscrizione(responsabile, prenotazione);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Iscrizione non autorizzata!");
		}
	}
}