package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.Feedback;
import it.unisalento.pps.view.FeedbackTesserato;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreFeedback implements ActionListener{
	
	private JFrame frame;
	private Utente tesserato;
	private Disciplina disciplina;
	
	public AscoltatoreFeedback(InfoDisciplinaTesserato frame, Disciplina disciplina, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}
	
	public AscoltatoreFeedback(Feedback frame, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.disciplina = disciplina;
	}
	
	public AscoltatoreFeedback(FeedbackTesserato frame, Disciplina disciplina, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton bottone = (JButton) e.getSource();
		String nomeDisciplina = bottone.getText();
		d1launch(nomeDisciplina);
	}
		private void d1launch(String nome) {
			String s = (String)JOptionPane.showInputDialog(frame,"Inserisci il tuo feedback:\n","FEEDBACK",JOptionPane.PLAIN_MESSAGE);
			new InfoDisciplinaTesserato(disciplina, tesserato);
			frame.dispose();
			//bisogna fare in modo che quando si preme ok il commento venga salvato nel database mentre se si preme annulla no
			}
	}