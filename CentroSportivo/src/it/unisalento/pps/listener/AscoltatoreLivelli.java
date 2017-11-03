package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.CatalogoDiscipline;
import it.unisalento.pps.view.ElencoLivelli;

public class AscoltatoreLivelli implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	public AscoltatoreLivelli(CatalogoDiscipline frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		new FormElencoLivelli(responsabile);
		frame.dispose();
	}
}