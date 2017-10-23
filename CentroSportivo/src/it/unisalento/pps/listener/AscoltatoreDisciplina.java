package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.view.Homepage;
import it.unisalento.pps.view.InfoDisciplina;

public class AscoltatoreDisciplina implements ActionListener {
	
	private JFrame frame;
	private Disciplina disciplina;
	
	public AscoltatoreDisciplina (Homepage frame) {
		super();
		this.frame = frame; 		
	}

	public void actionPerformed(ActionEvent e) {
		JButton bottone = (JButton) e.getSource();
		String nomeDisciplina = bottone.getText();
		String com = e.getActionCommand();
		d1launch(nomeDisciplina);
		
	}
	
	private void d1launch(String nome) {
		disciplina =  DisciplinaBusiness.getInstance().getDisciplinaByNome(nome);
		new InfoDisciplina(disciplina);
		frame.dispose();
	}
}
