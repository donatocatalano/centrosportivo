package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaIscrizioniCorsi;
import it.unisalento.pps.view.HomepageTesserato;

public class AscoltatoreConfermaIscrizioni implements ActionListener{
	
	private AreaIscrizioniCorsi frame;
	private Utente tesserato;
	int tipoPagamento;
	

	public AscoltatoreConfermaIscrizioni(AreaIscrizioniCorsi frame, Utente tesserato) {
		super();
		this.frame = frame;
		this.tesserato = tesserato;
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
			else {
					tipoPagamento = 3;
				}
			System.out.println(evento.getText());
			
			
			new HomepageTesserato(tesserato);
			frame.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}