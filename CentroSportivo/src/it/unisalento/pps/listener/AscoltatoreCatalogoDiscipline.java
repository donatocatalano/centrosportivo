package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.CatalogoDiscipline;

public class AscoltatoreCatalogoDiscipline implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Disciplina disciplina;
	
	public AscoltatoreCatalogoDiscipline(AreaResponsabile frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		new CatalogoDiscipline(responsabile, disciplina);
		frame.dispose();
	}
}