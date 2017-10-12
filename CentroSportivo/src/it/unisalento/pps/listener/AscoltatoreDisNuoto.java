package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.Homepage;
import it.unisalento.pps.view.InfoDisciplina;


public class AscoltatoreDisNuoto implements ActionListener {
	
	private Homepage homepageWindow;

	public AscoltatoreDisNuoto(Homepage homepageWindow) {
		super();
		this.homepageWindow = homepageWindow;
	}


	
	public void actionPerformed(ActionEvent e) {
		
		new InfoDisciplina();
		homepageWindow.dispose();
		
	}

}