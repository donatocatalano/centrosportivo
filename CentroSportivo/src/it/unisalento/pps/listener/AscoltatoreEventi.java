package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.ElencoEventi;

public class AscoltatoreEventi implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	
	public AscoltatoreEventi(AreaIstruttore frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		new ElencoEventi(istruttore);
		frame.dispose();
	}
}
