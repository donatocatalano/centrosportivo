package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.Feedback;
import it.unisalento.pps.view.FeedbackTesserato;
import it.unisalento.pps.view.InfoDisciplina;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreVediFeed implements ActionListener {
	
	private JFrame frame;
	private Disciplina disciplina;
	private Utente tesserato;
	public final static String D1="d1";
	
	
	public AscoltatoreVediFeed(InfoDisciplina frame, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.disciplina = disciplina;		
	}
	
	public AscoltatoreVediFeed(InfoDisciplinaTesserato frame, Disciplina disciplina, Utente tesserato) {
		super();
		this.frame = frame;
		this.disciplina = disciplina;
		this.tesserato = tesserato;		
	}
	
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com==D1) {
			new FeedbackTesserato(disciplina, tesserato);
			frame.dispose();
		}
		else {		
			new Feedback(disciplina);
			frame.dispose();
		}
	}
}