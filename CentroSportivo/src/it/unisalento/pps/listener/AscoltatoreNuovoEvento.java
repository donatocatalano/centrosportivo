package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.ElencoCorsi;
import it.unisalento.pps.view.ElencoEventi;
import it.unisalento.pps.view.FormEvento;
import it.unisalento.pps.view.FormCorso;

public class AscoltatoreNuovoEvento implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	public final static String D1 = "D1";
	
	public AscoltatoreNuovoEvento(ElencoEventi frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
	}
	
	public AscoltatoreNuovoEvento(ElencoCorsi frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();	
		else {
			new FormEvento(istruttore);
			frame.dispose();
		}
	}
	
	private void d1launch(){
		new FormCorso(istruttore);
	}
}