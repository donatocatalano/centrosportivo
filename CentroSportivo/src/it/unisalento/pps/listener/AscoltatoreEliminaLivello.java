package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.FormElencoLivelli;

public class AscoltatoreEliminaLivello implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Livello livello;
	
	public AscoltatoreEliminaLivello(FormElencoLivelli frame, Responsabile responsabile, Livello livello) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
		this.livello = livello;
	}

	public void actionPerformed(ActionEvent e) {
		
		boolean ok = LivelloBusiness.getInstance().cancellaLivello(livello);
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi eliminare il livello?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(ok && n==0) {
			JOptionPane.showMessageDialog(null, "Livello eliminato!");
			new FormElencoLivelli(responsabile);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Livello non eliminato!");
		}
	}
}