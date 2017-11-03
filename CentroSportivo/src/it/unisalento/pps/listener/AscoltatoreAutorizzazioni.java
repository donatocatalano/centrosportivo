package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.AutorizzazioniIscrizione;
import it.unisalento.pps.view.AutorizzazioniPagamento;
import it.unisalento.pps.view.AutorizzazioniRegistrazione;
import it.unisalento.pps.view.ElencoAutorizzazioni;

public class AscoltatoreAutorizzazioni implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	
	public AscoltatoreAutorizzazioni(AreaResponsabile frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreAutorizzazioni(AutorizzazioniRegistrazione frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreAutorizzazioni(AutorizzazioniIscrizione frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreAutorizzazioni(AutorizzazioniPagamento frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		new ElencoAutorizzazioni(responsabile);
		frame.dispose();
	}
}