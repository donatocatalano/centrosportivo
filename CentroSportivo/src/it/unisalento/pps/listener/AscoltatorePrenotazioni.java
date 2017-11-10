package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioneDisciplina;
import it.unisalento.pps.view.AreaPrenotazioni;
import it.unisalento.pps.view.InfoDisciplinaTesserato;


public class AscoltatorePrenotazioni implements ActionListener {
	
	private AreaPrenotazioni frame;
	private Utente tesserato;
	private Disciplina disciplina;
	public final static String D1 = "D1";
	
	
	public AscoltatorePrenotazioni(AreaPrenotazioni frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	
	

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
		JCheckBox evento = frame.campo_evento;
		
		System.out.println(evento.getText());
}
}