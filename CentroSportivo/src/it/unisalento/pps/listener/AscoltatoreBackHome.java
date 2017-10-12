package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;
import it.unisalento.pps.view.InfoDisciplina;
import it.unisalento.pps.view.InfoDisciplinaTesserato;
import it.unisalento.pps.view.IstruttoreInizio;


	public class AscoltatoreBackHome implements ActionListener{
	
		private JFrame frame;
		
	public AscoltatoreBackHome(InfoDisciplina frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(InfoDisciplinaTesserato frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(FormRegistrazione frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(IstruttoreInizio frame) {
		super();
		this.frame = frame;
	}
	

	public void actionPerformed(ActionEvent e) {
	
	new Homepage();
	frame.dispose();
	}
}
