package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.AreaIstruttore;

public class AscoltatoreCorsi implements ActionListener {
	
private AreaIstruttore istruttoreInizio;
	
	public AscoltatoreCorsi(AreaIstruttore istruttoreInizio) {
		super();
		this.istruttoreInizio = istruttoreInizio;
	}

	public void actionPerformed(ActionEvent e) {
	}
}