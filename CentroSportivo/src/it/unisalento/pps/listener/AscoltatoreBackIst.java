package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.ElencoCorsi;
import it.unisalento.pps.view.ElencoEventi;
import it.unisalento.pps.view.ElencoIscrizioni;
import it.unisalento.pps.view.FormCorso;
import it.unisalento.pps.view.FormEvento;

public class AscoltatoreBackIst implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	
	
	public AscoltatoreBackIst(ElencoCorsi frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore=istruttore;
	}
	
	public AscoltatoreBackIst(ElencoEventi frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore=istruttore;
	}
	
	public AscoltatoreBackIst(ElencoIscrizioni frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore=istruttore;
	}
	
	public AscoltatoreBackIst(FormCorso frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore=istruttore;
	}
	
	public AscoltatoreBackIst(FormEvento frame, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.istruttore=istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		new AreaIstruttore(istruttore);
		frame.dispose();
	}
}
