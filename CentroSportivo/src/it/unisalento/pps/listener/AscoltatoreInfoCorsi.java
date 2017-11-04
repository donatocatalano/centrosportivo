package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.InfoCorsi;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreInfoCorsi implements ActionListener{
	private JFrame frame;
	private Disciplina disciplina;
	private Utente tesserato;


	public AscoltatoreInfoCorsi (InfoDisciplinaTesserato frame, Utente tesserato, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.disciplina = disciplina;	
		this.tesserato = tesserato;
	}

	public void actionPerformed(ActionEvent e) {
	
		new InfoCorsi(disciplina, tesserato);
		frame.dispose();
	}
}