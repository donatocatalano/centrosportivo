package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.IstruttoreInizio;

public class AscoltatoreEventi implements ActionListener {
	
private IstruttoreInizio istruttoreInizio;
	
	public AscoltatoreEventi(IstruttoreInizio istruttoreInizio) {
		super();
		this.istruttoreInizio = istruttoreInizio;
	}


	public void actionPerformed(ActionEvent e) {
		
	}

}

