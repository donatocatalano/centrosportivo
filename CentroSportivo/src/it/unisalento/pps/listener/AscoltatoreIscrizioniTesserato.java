package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioniTesserato;
import it.unisalento.pps.view.HomepageTesserato;


public class AscoltatoreIscrizioniTesserato implements ActionListener {
	
	private JFrame frame;
	private Utente tesserato;
	
	public AscoltatoreIscrizioniTesserato(HomepageTesserato frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}

	public void actionPerformed(ActionEvent e) {
		new AreaIscrizioniTesserato(tesserato);
		frame.dispose();
	}
}