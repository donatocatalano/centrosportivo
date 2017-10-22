package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.view.FormRegistrazione;

public class AscoltatoreConfermaRegistrazione implements ActionListener {
	
	private FormRegistrazione frame;
	
	

	public AscoltatoreConfermaRegistrazione(FormRegistrazione frame) {
		this.frame = frame; 
		
	}
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		JTextField nome = frame.nome_field;
		boolean ok = UtenteBusiness.getInstance().registraUtenteByNome(nome.getText());
	}
}