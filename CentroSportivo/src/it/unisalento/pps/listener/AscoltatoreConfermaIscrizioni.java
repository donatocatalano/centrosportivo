package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.business.PagamentoBusiness;
import it.unisalento.pps.dao.LivelloDAO;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioneDisciplina;
import it.unisalento.pps.view.HomepageTesserato;

public class AscoltatoreConfermaIscrizioni implements ActionListener{
	
	private AreaIscrizioneDisciplina frame;
	private Utente tesserato;
	private Disciplina disciplina;
	private ArrayList<Livello> livelli = new  ArrayList<Livello>();
	private ArrayList<Iscrizione> iscrizioniTesserato = new  ArrayList<Iscrizione>();
	int livelloId;
	int tipoPagamento;
	int idUltimaIscrizione;
	boolean giaIscritto = false;
	

	public AscoltatoreConfermaIscrizioni(AreaIscrizioneDisciplina frame, Utente tesserato,Disciplina disciplina) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}
	
	public void actionPerformed(ActionEvent event) throws IllegalArgumentException{
		
		JRadioButton carta = frame.carta;
		JRadioButton paypal = frame.paypal;
		JRadioButton contanti = frame.contanti;
		
		
		//Utente gia iscritto a quella dfisciplina
		iscrizioniTesserato = IscrizioneBusiness.getInstance().getIscrizioniByIdTesserato(tesserato.getIdUtente());
		for(int i =0; i<iscrizioniTesserato.size();i++) {
			if(disciplina.getIdDisciplina() == iscrizioniTesserato.get(i).getIdIscrizione() ) {
				giaIscritto = true;
				}
			}
		if(!giaIscritto) {		
		
		try {
			
			if(carta.isSelected()) {
				tipoPagamento = 1;
				}
			else if(paypal.isSelected()) {
				tipoPagamento = 2;
			}
			else if(contanti.isSelected()){
					tipoPagamento = 3;
				}
				System.out.println(frame.getSelectedButton());		
			livelli = LivelloDAO.getInstance().getLivelli();
			
			if(frame.getSelectedButton() != null && tipoPagamento !=0) {
				for (int i = 0; i<livelli.size();i++) {
									
					if(livelli.get(i).getIdLivello() == Integer.parseInt(frame.getSelectedButton())) {
					livelloId = livelli.get(i).getIdLivello();
					}
				}
				boolean ok_iscrizione = IscrizioneBusiness.getInstance().nuovaIscrizione(tesserato.getIdUtente(),disciplina.getIdDisciplina(),livelloId);
				
				if (ok_iscrizione) {
				JOptionPane.showMessageDialog(null, "Richiesta Iscrizione Inviata");
				idUltimaIscrizione = IscrizioneBusiness.getInstance().getIdUltimaIscrizione();
				
				}
				boolean ok_pagamento = PagamentoBusiness.getInstance().nuovoPagamento(tesserato.getIdUtente(),tipoPagamento,disciplina.getCostoMensile()*12,idUltimaIscrizione);
			if (ok_pagamento) {
				JOptionPane.showMessageDialog(null, "Richiesta Pagamento Effettuata");
				}
			
			if (ok_iscrizione && ok_pagamento) {			
			new HomepageTesserato(tesserato);
			frame.dispose();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Campi non completamenmte valorizzati !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Sei gia ISCRITTO a "+disciplina.getNome().toUpperCase());
			}
		}
}