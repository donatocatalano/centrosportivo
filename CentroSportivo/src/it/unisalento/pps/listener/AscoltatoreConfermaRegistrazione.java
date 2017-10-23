package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;

public class AscoltatoreConfermaRegistrazione implements ActionListener {
	
	private FormRegistrazione frame;
	private String sesso;
	
	

	public AscoltatoreConfermaRegistrazione(FormRegistrazione frame) {
		this.frame = frame; 
		
	}
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		JTextField nome = frame.nome_field;
		JTextField cognome = frame.cognome_field;
		JTextField username = frame.user_field;

        JPasswordField password = frame.pass_field;
		JRadioButton maschio = frame.maschio;
		JRadioButton femmina = frame.femmina;
		
		if(maschio.isSelected())
			sesso="m";
		else if (femmina.isSelected())
			sesso = "f";
		
		
		boolean ok = UtenteBusiness.getInstance().registraUtente(nome.getText(),cognome.getText(),username.getText(),password.getText(),sesso,new Date(1965,12,23));
		if(ok) {
			JOptionPane.showMessageDialog(null, "Dati inseriti correttamente. Registrazione in attesa di registrazione");
			new Homepage();
			frame.dispose();
			}
		else
			JOptionPane.showMessageDialog(null, "Registrazione non completata.Riprova");

		if (maschio.isSelected())
			sesso = "m";
		else
			sesso = "f";		
		
		
	}
}