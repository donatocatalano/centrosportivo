package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AutorizzazioniRegistrazione;

public class AscoltatoreConfermaRegistrazione implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	
	private Utente utente;

	public AscoltatoreConfermaRegistrazione(AutorizzazioniRegistrazione frame, Responsabile responsabile, Utente utente) {
		this.frame = frame;
		this.responsabile = responsabile;
		this.utente = utente;
	}
	
	public void actionPerformed(ActionEvent e){
		
		boolean ok = UtenteBusiness.getInstance().confermaUtente(utente.getIdUtente(), responsabile.getIdResponsabile());
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi confermare la registrazione?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(ok && n==0) {
			JOptionPane.showMessageDialog(null, "Utente tesserato!");
			new AutorizzazioniRegistrazione(responsabile);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Utente non confermato!");
		}
	}
}