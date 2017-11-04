package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioniCorsi;
import it.unisalento.pps.view.AreaIscrizioniEventi;
import it.unisalento.pps.view.HomepageTesserato;


public class AscoltatoreIscrizioniTesserato implements ActionListener {
	
	private JFrame frame;
	private Utente tesserato;
	public final static String D1 = "D1";
	
	public AscoltatoreIscrizioniTesserato(HomepageTesserato frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();
		else {
			new AreaIscrizioniCorsi(tesserato);
			frame.dispose();
		}
	}
	public void d1launch() {
		new AreaIscrizioniEventi(tesserato);
	}
}