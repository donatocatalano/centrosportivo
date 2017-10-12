package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.AreaIstruttore;

public class AscoltatoreEventi implements ActionListener {
	
private AreaIstruttore istruttoreInizio;
	
	public AscoltatoreEventi(AreaIstruttore istruttoreInizio) {
		super();
		this.istruttoreInizio = istruttoreInizio;
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}

