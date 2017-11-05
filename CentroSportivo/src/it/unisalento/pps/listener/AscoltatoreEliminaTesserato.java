package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.ElencoTesserati;

public class AscoltatoreEliminaTesserato implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Utente tesserato;
	
	public AscoltatoreEliminaTesserato(ElencoTesserati frame, Responsabile responsabile, Utente tesserato) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
		this.tesserato = tesserato;
	}

	public void actionPerformed(ActionEvent e) {
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
				"Vuoi eliminare l'utente?",
				"ATTENZIONE !!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		
		if(n==0) {
			boolean ok = UtenteBusiness.getInstance().cancellaTesserato(tesserato);
			if(ok) { 
				JOptionPane.showMessageDialog(null, "Utente eliminato!");
				new ElencoTesserati(responsabile);
				frame.dispose();
				}
			else {
				JOptionPane.showMessageDialog(null, "Utente non eliminato!");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Utente non eliminato!");
		}
	}
}