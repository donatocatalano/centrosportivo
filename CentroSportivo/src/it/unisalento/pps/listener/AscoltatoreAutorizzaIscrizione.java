package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AutorizzazioniIscrizione;
import it.unisalento.pps.view.AutorizzazioniRegistrazione;

public class AscoltatoreAutorizzaIscrizione implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	
	private Iscrizione iscrizione;

	public AscoltatoreAutorizzaIscrizione(AutorizzazioniIscrizione frame, Responsabile responsabile, Iscrizione iscrizione) {
		this.frame = frame;
		this.responsabile = responsabile;
		this.iscrizione = iscrizione;
	}
	
	public void actionPerformed(ActionEvent e){
		
		boolean ok = IscrizioneBusiness.getInstance().autorizzaIscrizione(iscrizione.getIdIscrizione());
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi autorizzare l'iscrizione?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(ok && n==0) {
			JOptionPane.showMessageDialog(null, "Iscrizione autorizzata!");
			new AutorizzazioniIscrizione(responsabile);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Iscrizione non autorizzata!");
		}
	}
}