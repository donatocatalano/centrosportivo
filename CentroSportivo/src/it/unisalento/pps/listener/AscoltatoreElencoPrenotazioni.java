package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.ElencoPrenotazioni;

public class AscoltatoreElencoPrenotazioni implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	
	public AscoltatoreElencoPrenotazioni (AreaIstruttore frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		new ElencoPrenotazioni(istruttore);
		frame.dispose();
	}
}