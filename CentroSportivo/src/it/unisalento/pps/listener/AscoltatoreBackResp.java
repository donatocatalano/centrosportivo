package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.CatalogoDiscipline;
import it.unisalento.pps.view.ElencoAutorizzazioni;
import it.unisalento.pps.view.ElencoIstruttori;
import it.unisalento.pps.view.ElencoTesserati;
import it.unisalento.pps.view.FormDisciplina;
import it.unisalento.pps.view.FormElencoLivelli;
import it.unisalento.pps.view.FormIstruttore;
import it.unisalento.pps.view.FormModDisciplina;

public class AscoltatoreBackResp implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	
	
	public AscoltatoreBackResp(FormElencoLivelli formElencoLivelli, Responsabile responsabile) {
		super();
		this.frame = formElencoLivelli;
		this.responsabile=responsabile;
	}
	
	public AscoltatoreBackResp(CatalogoDiscipline frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
		
	public AscoltatoreBackResp(FormDisciplina frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public AscoltatoreBackResp(FormModDisciplina frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreBackResp(ElencoAutorizzazioni frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreBackResp(ElencoTesserati frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreBackResp(ElencoIstruttori frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreBackResp(FormIstruttore frame, Responsabile responsabile) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent e) {
		new AreaResponsabile(responsabile);
		frame.dispose();
	}
}
