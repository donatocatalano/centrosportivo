package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;
import it.unisalento.pps.view.HomepageTesserato;
import it.unisalento.pps.view.InfoDisciplina;
import it.unisalento.pps.view.InfoDisciplinaTesserato;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.Feedback;
import it.unisalento.pps.view.FeedbackTesserato;
import it.unisalento.pps.view.AreaIscrizioniTesserato;
import it.unisalento.pps.view.AreaIstruttore;


	public class AscoltatoreBackHome implements ActionListener{
	
		private JFrame frame;
		private Utente tesserato;
		public final static String D1="d1";
		
	public AscoltatoreBackHome(InfoDisciplina frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(InfoDisciplinaTesserato frame,Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	
	public AscoltatoreBackHome(HomepageTesserato frame,Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	
	public AscoltatoreBackHome(FormRegistrazione frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(AreaIstruttore frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(AreaResponsabile frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(AreaIscrizioniTesserato frame,Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	
	public AscoltatoreBackHome(Feedback frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(FeedbackTesserato frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
	}
	

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();	
		else {		
			new Homepage();
			frame.dispose();
		}
	}
	
	private void d1launch() {
		new HomepageTesserato(tesserato);
		frame.dispose();
	}
}
