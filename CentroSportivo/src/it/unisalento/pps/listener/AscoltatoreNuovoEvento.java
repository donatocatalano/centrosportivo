package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.ElencoCorsi;
import it.unisalento.pps.view.ElencoEventi;
import it.unisalento.pps.view.FormEvento;

public class AscoltatoreNuovoEvento implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	
	public AscoltatoreNuovoEvento(ElencoEventi frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		new FormEvento(istruttore);
		frame.dispose();
	}
}