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
	
	public final static String D1="Fitness";
	public final static String D2="Pesistica";
	public final static String D3="Nuoto";
	public final static String D4="Ginnastica Artistica";
	public final static String D5="Ginnastica Ritmica";
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
		/*if (com==D1)
			d1launch(nomeDisciplina);	
		else if (com==D2)
			d1launch(nomeDisciplina);	
		else if (com==D3)
			d1launch(nomeDisciplina);	
		else if (com==D4)
			d1launch(nomeDisciplina);	
		else if (com==D5)
			d1launch(nomeDisciplina);	*/	
	}
	
	private void d1launch(String nome) {
		disciplina =  DisciplinaBusiness.getInstance().getDisciplinaByNome(nome);
		new InfoDisciplina(disciplina);
		frame.dispose();
	}

}
