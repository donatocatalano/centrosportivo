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
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioneDisciplina;
import it.unisalento.pps.view.HomepageTesserato;

public class AscoltatoreConfermaIscrizioni implements ActionListener{
	
	private AreaIscrizioneDisciplina frame;
	private Utente tesserato;
	private Disciplina disciplina;
	private ArrayList<Livello> livelli = new  ArrayList<Livello>();
	int livelloId;
	int tipoPagamento;
	int idUltimaIscrizione;
	

	public AscoltatoreConfermaIscrizioni(AreaIscrizioneDisciplina frame, Utente tesserato,Disciplina disciplina) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		
		JRadioButton carta = frame.carta;
		JRadioButton paypal = frame.paypal;
		JRadioButton contanti = frame.contanti;
		JRadioButton livello = frame.livello;
		
		
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
						
			System.out.println(livello.getText());
			livelli = LivelloDAO.getInstance().getLivelli();
			

			for (int i = 0; i<livelli.size();i++) {
				if(livelli.get(i).getNome().equals(livello.getText())) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}