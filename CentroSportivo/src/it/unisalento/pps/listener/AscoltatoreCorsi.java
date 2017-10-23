package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.ElencoCorsi;

public class AscoltatoreCorsi implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	
	public AscoltatoreCorsi(AreaIstruttore frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		new ElencoCorsi(istruttore);
		frame.dispose();
	}
}