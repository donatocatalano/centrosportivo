package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AutorizzazioniRegistrazione;

public class AscoltatoreAutorizzaRegistrazione implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	
	private Utente utente;

	public AscoltatoreAutorizzaRegistrazione(AutorizzazioniRegistrazione frame, Responsabile responsabile, Utente utente) {
		this.frame = frame;
		this.responsabile = responsabile;
		this.utente = utente;
	}
	
	public void actionPerformed(ActionEvent e){
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi autorizzare la registrazione?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(n==0) {
			boolean ok = UtenteBusiness.getInstance().autorizzaUtente(utente.getIdUtente(), responsabile.getIdResponsabile());
			if(ok) {
			JOptionPane.showMessageDialog(null, "Utente tesserato!");
			new AutorizzazioniRegistrazione(responsabile);
			frame.dispose();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Registrazione non autorizzata!");
		}
	}
}