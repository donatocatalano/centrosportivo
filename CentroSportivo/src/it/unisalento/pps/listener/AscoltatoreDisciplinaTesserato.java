package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.HomepageTesserato;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreDisciplinaTesserato implements ActionListener {
	
	private JFrame frame;
	Disciplina disciplina;
	Utente tesserato;
	
	public AscoltatoreDisciplinaTesserato (HomepageTesserato frame,Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}

	public void actionPerformed(ActionEvent e) {
		JButton bottone = (JButton) e.getSource();
		String nomeDisciplina = bottone.getText();
		d1launch(nomeDisciplina);
	}
	
	private void d1launch(String nome) {
		disciplina =  DisciplinaBusiness.getInstance().getDisciplinaByNome(nome);
		new InfoDisciplinaTesserato(disciplina,tesserato);
		frame.dispose();
	}
}
