package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;
import it.unisalento.pps.view.HomepageTesserato;
import it.unisalento.pps.view.InfoDisciplina;
import it.unisalento.pps.view.InfoDisciplinaTesserato;
import it.unisalento.pps.view.AreaGestore;
import it.unisalento.pps.view.AreaIstruttore;


	public class AscoltatoreBackHome implements ActionListener{
	
		private JFrame frame;
		public final static String D1="d1";
		
	public AscoltatoreBackHome(InfoDisciplina frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(InfoDisciplinaTesserato frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(HomepageTesserato frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(FormRegistrazione frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(AreaIstruttore frame) {
		super();
		this.frame = frame;
	}
	
	public AscoltatoreBackHome(AreaGestore frame) {
		super();
		this.frame = frame;
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
		new HomepageTesserato();
		frame.dispose();
	}
}
