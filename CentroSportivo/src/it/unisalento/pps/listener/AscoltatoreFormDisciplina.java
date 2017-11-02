package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.CatalogoDiscipline;
import it.unisalento.pps.view.FormDisciplina;
import it.unisalento.pps.view.FormModDisciplina;

public class AscoltatoreFormDisciplina implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Disciplina disciplina;
	public final static String D1 ="D1";
	
	public AscoltatoreFormDisciplina(CatalogoDiscipline frame, Responsabile responsabile, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
		this.disciplina = disciplina;
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();
		else {
			new FormDisciplina(responsabile);
			frame.dispose();
		}
	}
	
	private void d1launch() {
		new FormModDisciplina(responsabile, disciplina);
		frame.dispose();
	}
}