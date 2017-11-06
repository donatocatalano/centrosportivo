package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.business.PagamentoBusiness;
import it.unisalento.pps.model.Pagamento;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AutorizzazioniIscrizioneEPagamento;

public class AscoltatoreAutorizzaIscrizioneEPagamento implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	
	private Pagamento pagamento;

	public AscoltatoreAutorizzaIscrizioneEPagamento(AutorizzazioniIscrizioneEPagamento frame, Responsabile responsabile, Pagamento pagamento) {
		this.frame = frame;
		this.responsabile = responsabile;
		this.pagamento = pagamento;
	}
	
	public void actionPerformed(ActionEvent e){
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi autorizzare il pagamento?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(n==0) {
			boolean ok_pagamento = PagamentoBusiness.getInstance().autorizzaPagamento(pagamento.getIdPagamento(), responsabile.getIdResponsabile());
			boolean ok_iscrizione   = IscrizioneBusiness.getInstance().autorizzaIscrizione(pagamento.getIscrizione(),responsabile.getIdResponsabile());
			
			if(ok_pagamento) { 
				JOptionPane.showMessageDialog(null, "Pagamento autorizzato!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Pagamento non autorizzato!");
			}
			if(ok_iscrizione) {
				JOptionPane.showMessageDialog(null, "Iscrizione autorizzata!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Iscrizione non autorizzata!");
			}
			if(ok_pagamento && ok_iscrizione) {
					new AutorizzazioniIscrizioneEPagamento(responsabile);
					frame.dispose();
				}
			}
		
	}
}