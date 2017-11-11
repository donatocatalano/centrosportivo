package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.model.*;
import it.unisalento.pps.view.AreaIscrizioneDisciplina;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.AreaPrenotazioni;
import it.unisalento.pps.view.InfoDisciplinaTesserato;


public class AscoltatorePrenotazioni implements ActionListener {
	
	private AreaPrenotazioni frame;
	private Utente tesserato;
	private Disciplina disciplina;
	private ArrayList<Integer> idEventiSelezionati = new ArrayList<Integer>();
	private ArrayList<Evento> eventiSelezionati = new ArrayList<Evento>();
	public final static String D1 = "D1";
	
	
	public AscoltatorePrenotazioni(AreaPrenotazioni frame, Utente tesserato,ArrayList<Integer> eventi) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.idEventiSelezionati = eventi;
	}
	
	

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
		boolean prenotato=false;
		for(int i=0;i<idEventiSelezionati.size();i++) {
			Evento evento = EventoBusiness.getInstance().getEventoById(idEventiSelezionati.get(i));
			boolean ok= eventiSelezionati.add(evento);
			if(ok) {
				
				prenotato=PrenotazioneBusiness.getInstance().setPrenotazioneTesserato(tesserato.getIdUtente(),idEventiSelezionati.get(i));
				
			}
			
		}
		if(prenotato) {
			JOptionPane.showMessageDialog(null, "Richiesta effettuata procedi con la stampa della ricevuta !");
			new AreaPrenotazioni(tesserato);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Non è stato possibile inviare richiesta.Riprova più tardi !");
		}
	}
}