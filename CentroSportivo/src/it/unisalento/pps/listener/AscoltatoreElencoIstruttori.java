package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.ElencoIstruttori;

public class AscoltatoreElencoIstruttori implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	
	public AscoltatoreElencoIstruttori(AreaResponsabile frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	

	public void actionPerformed(ActionEvent e) {
		new ElencoIstruttori(responsabile);
		frame.dispose();
	}
}