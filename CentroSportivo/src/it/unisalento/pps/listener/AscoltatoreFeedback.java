package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreFeedback implements ActionListener{
	
	private JFrame frame;
	private Utente tesserato;
	
	public AscoltatoreFeedback(InfoDisciplinaTesserato frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	
	public void actionPerformed(ActionEvent e) {
		String s = (String)JOptionPane.showInputDialog(frame,"Inserisci il tuo feedback:\n","FEEDBACK",JOptionPane.PLAIN_MESSAGE);
		
		//bisogna fare in modo che quando si preme ok il commento venga salvato nel database mentre se si preme annulla no.
		}
	}