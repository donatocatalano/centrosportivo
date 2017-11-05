package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.ElencoIstruttori;
import it.unisalento.pps.view.FormIstruttore;

public class AscoltatoreFormIstruttore implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	public AscoltatoreFormIstruttore(ElencoIstruttori frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		
			new FormIstruttore(responsabile);
			frame.dispose();
	}
}