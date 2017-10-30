package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.AutorizzazioniRegistrazione;
import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;

public class AscoltatoreConfermaRegistrazione implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	

	public AscoltatoreConfermaRegistrazione(AutorizzazioniRegistrazione frame, Responsabile responsabile) {
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public void actionPerformed(ActionEvent e){
		/*int i;
		String username = frame.username.get(i);
		
		boolean ok = UtenteBusiness.getInstance().confermaUtente(username);
		if(ok) {
			JOptionPane.showMessageDialog(null, "Registrazione confermata");
			new AreaResponsabile(responsabile);
			frame.dispose();
			}*/
	}
}