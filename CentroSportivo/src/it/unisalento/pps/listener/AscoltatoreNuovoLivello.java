package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.FormElencoLivelli;

public class AscoltatoreNuovoLivello implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	public AscoltatoreNuovoLivello(FormElencoLivelli frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		
		String livello = (String)JOptionPane.showInputDialog(frame,"Inserisci il nuovo livello:\n","NUOVO LIVELLO",JOptionPane.PLAIN_MESSAGE);
		
		boolean ok;
		
		if (livello !=null) {
			Object[] options = {"SI","NO"};
			int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
				"Vuoi aggiungere il livello?",
				"ATTENZIONE !!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		
			if(n==0 && JOptionPane.PLAIN_MESSAGE!=0) {					
				ok = LivelloBusiness.getInstance().inserisciLivello(livello);
				JOptionPane.showMessageDialog(null, "Nuovo livello inserito!");
				new FormElencoLivelli(responsabile);
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Livello non inserito!");
			}
		}
	}
}