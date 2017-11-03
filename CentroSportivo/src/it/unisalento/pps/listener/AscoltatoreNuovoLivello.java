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
	
		boolean ok = LivelloBusiness.getInstance().inserisciLivello(livello);
		
		JOptionPane.showMessageDialog(null, "Livello inserito!");
		new FormElencoLivelli(responsabile);
		frame.dispose();
	}
}