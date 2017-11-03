package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.TestimonianzaBusiness;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.Feedback;
import it.unisalento.pps.view.FeedbackTesserato;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreFeedback implements ActionListener{
	
	private JFrame frame;
	private Utente tesserato;
	private Disciplina disciplina;
	
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
	
	public AscoltatoreFeedback(InfoDisciplinaTesserato frame, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.disciplina = disciplina;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton bottone = (JButton) e.getSource();
		String nomeDisciplina = bottone.getText();
		d1launch(nomeDisciplina);
	}
		private void d1launch(String nome) {
			
			String feedback = (String)JOptionPane.showInputDialog(frame,"Inserisci il tuo feedback:\n","FEEDBACK",JOptionPane.PLAIN_MESSAGE);
			
			
		/*	int anno = 2017;
			int mese = 01;
			int giorno= 01;
			GregorianCalendar date = new GregorianCalendar(anno,mese-1,giorno);
			long millisecondi_inizio = date.getTimeInMillis();
			Date data = new Date(millisecondi_inizio);*/
			
			boolean ok;
			
			if (feedback !=null) {
				Object[] options = {"SI","NO"};
				int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
					"Vuoi aggiungere il feedback?",
					"ATTENZIONE !!",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,     //do not use a custom Icon
					options,  //the titles of buttons
					options[0]); //default button title
			
				if(n==0 && JOptionPane.PLAIN_MESSAGE!=0) {					
					ok = TestimonianzaBusiness.getInstance().inserisciFeed(feedback,disciplina.getIdDisciplina(), tesserato.getIdUtente());
					JOptionPane.showMessageDialog(null, "Feedback inserito!");
					new FeedbackTesserato(disciplina, tesserato);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Feedback non inserito!");
				}
			}
			else {
				new InfoDisciplinaTesserato(disciplina, tesserato);
				frame.dispose();
			}
		}
	}