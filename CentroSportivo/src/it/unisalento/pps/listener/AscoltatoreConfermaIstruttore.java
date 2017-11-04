package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.business.IstruttoreBusiness;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.ElencoIstruttori;
import it.unisalento.pps.view.FormIstruttore;

public class AscoltatoreConfermaIstruttore implements ActionListener {
	
	private FormIstruttore frame;
	private Responsabile responsabile;

	public AscoltatoreConfermaIstruttore(FormIstruttore frame, Responsabile responsabile) {
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		JTextField nome = frame.nome_field;
		JTextField cognome = frame.cognome_field;
		JTextField username = frame.user_field;
        JPasswordField password = frame.pass_field;
        
        Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi aggiungere questo istruttore?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(n==0) {
			boolean ok = IstruttoreBusiness.getInstance().registraIstruttore(nome.getText(),cognome.getText(),username.getText(),password.getText());
				if(ok) {
					JOptionPane.showMessageDialog(null, "Dati inseriti correttamente");
					new ElencoIstruttori(responsabile);
					frame.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "C'è qualche errore. Riprova");	
		}
		else JOptionPane.showMessageDialog(null, "Istruttore non inserito!");
	}
}