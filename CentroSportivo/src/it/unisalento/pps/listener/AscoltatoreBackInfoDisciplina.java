package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.InfoCorsi;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreBackInfoDisciplina implements ActionListener {
	
		private JFrame frame;
		private Utente tesserato;
		private Disciplina disciplina;
		public final static String D1="d1";
		
	public AscoltatoreBackInfoDisciplina(InfoCorsi frame, Utente tesserato, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}
	
	

	public void actionPerformed(ActionEvent e) {
		new InfoDisciplinaTesserato(disciplina, tesserato);
		frame.dispose();
	}
}


