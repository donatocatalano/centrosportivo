package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.IstruttoreBusiness;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.ElencoIstruttori;

public class AscoltatoreEliminaIstruttore implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Istruttore istruttore;
	
	public AscoltatoreEliminaIstruttore(ElencoIstruttori frame, Responsabile responsabile, Istruttore istruttore) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
		this.istruttore = istruttore;
	}

	public void actionPerformed(ActionEvent e) {
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
				"Vuoi eliminare l'istruttore?",
				"ATTENZIONE !!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		
		if(n==0) {
			boolean ok = IstruttoreBusiness.getInstance().cancellaIstruttore(istruttore);
			JOptionPane.showMessageDialog(null, "Istruttore eliminato!");
			new ElencoIstruttori(responsabile);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Istruttore non eliminato!");
		}
	}
}