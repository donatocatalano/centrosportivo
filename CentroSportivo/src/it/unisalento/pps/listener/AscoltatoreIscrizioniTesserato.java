package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioneDisciplina;
import it.unisalento.pps.view.AreaPrenotazioni;
import it.unisalento.pps.view.HomepageTesserato;
import it.unisalento.pps.view.InfoDisciplinaTesserato;


public class AscoltatoreIscrizioniTesserato implements ActionListener {
	
	private JFrame frame;
	private Utente tesserato;
	private Disciplina disciplina;
	public final static String D1 = "D1";
	
	public AscoltatoreIscrizioniTesserato(HomepageTesserato frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	
	public AscoltatoreIscrizioniTesserato(InfoDisciplinaTesserato frame, Utente tesserato, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();
		else {
			new AreaIscrizioneDisciplina(tesserato, disciplina);
			frame.dispose();
		}
	}
	public void d1launch() {
		new AreaPrenotazioni(tesserato);
		frame.dispose();
	}
}