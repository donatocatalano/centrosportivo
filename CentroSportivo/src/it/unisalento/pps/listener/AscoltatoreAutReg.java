package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AutorizzazioniRegistrazione;
import it.unisalento.pps.view.ElencoAutorizzazioni;

public class AscoltatoreAutReg implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	public AscoltatoreAutReg(ElencoAutorizzazioni frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		new AutorizzazioniRegistrazione(responsabile);
		frame.dispose();
	}
}