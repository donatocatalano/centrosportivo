package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.ElencoCorsi;
import it.unisalento.pps.view.ElencoEventi;

public class AscoltatoreEliminaEvento implements ActionListener {
	
	private JFrame frame;
	private Istruttore istruttore;
	private Evento evento;
	public final static String D1="d1";
	
	public AscoltatoreEliminaEvento(ElencoEventi frame, Istruttore istruttore, Evento evento) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
		this.evento = evento;
	}
	
	public AscoltatoreEliminaEvento(ElencoCorsi frame, Istruttore istruttore, Evento evento) {
		super();
		this.frame = frame;
		this.istruttore = istruttore;
		this.evento = evento;
	}

	public void actionPerformed(ActionEvent e) {
		
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();	
		else {
			boolean ok = EventoBusiness.getInstance().cancellaEvento(evento);
			Object[] options = {"SI","NO"};
			int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
				"Vuoi eliminare l'evento?",
				"ATTENZIONE !!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		
		
			if(ok && n==0) {
				JOptionPane.showMessageDialog(null, "Evento eliminato!");
				new ElencoEventi(istruttore);
				frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Evento non eliminato!");
			}
		}
	}
	
	private void d1launch(){
		
		boolean ok = EventoBusiness.getInstance().cancellaEvento(evento);
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi eliminare il corso?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
	
	
		if(ok && n==0) {
			JOptionPane.showMessageDialog(null, "Corso eliminato!");
			new ElencoCorsi(istruttore);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Corso non eliminato!");
		}		
	}
}