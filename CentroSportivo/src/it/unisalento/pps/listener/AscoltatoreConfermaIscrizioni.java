package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioneDisciplina;
import it.unisalento.pps.view.HomepageTesserato;

public class AscoltatoreConfermaIscrizioni implements ActionListener{
	
	private AreaIscrizioneDisciplina frame;
	private Utente tesserato;
	private Disciplina disciplina;
	int tipoPagamento;
	

	public AscoltatoreConfermaIscrizioni(AreaIscrizioneDisciplina frame, Utente tesserato,Disciplina disciplina) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
		this.disciplina = disciplina;
	}
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		
		JRadioButton evento = frame.campo_evento;
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
			System.out.println(evento.getText());
			
			ok_iscrizione = IscrizioneBusiness.getInstance().nuovaIscrizione()
			
			
			new HomepageTesserato(tesserato);
			frame.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}