package it.unisalento.pps.listener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.FormCorso;
import it.unisalento.pps.view.FormEvento;

public class AscoltatoreConfermaEvento implements ActionListener {
	
	private FormEvento frame;
	private Istruttore istruttore;
	

	public AscoltatoreConfermaEvento(FormEvento frame, Istruttore istruttore) {
		this.frame = frame;
		this.istruttore = istruttore;
	}
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		JTextField datainizio = frame.datainizio_field;
		JTextField turno = frame.orario_field;
		//JTextField luogo = frame.luogo_field;
		//JTextField tipoevento = frame.tipoevento_field;
		//JTextField disciplina = frame.disciplina_field;
		JTextField datafine = frame.datafine_field;
		
		
		//manipolazione data
		
		int anno_inizio = Integer.parseInt((datainizio.getText().substring(6,10)));   ///23-12-1965
		int mese_inizio = Integer.parseInt(datainizio.getText().substring(3,5));
		int giorno_inizio = Integer.parseInt(datainizio.getText().substring(0,2));
		
		int anno_fine = Integer.parseInt(datafine.getText().substring(6,10));   ///23-12-1965
		int mese_fine = Integer.parseInt(datafine.getText().substring(3,5));
		int giorno_fine = Integer.parseInt(datafine.getText().substring(0,2));
		
		GregorianCalendar data_inizio = new GregorianCalendar(anno_inizio,mese_inizio-1,giorno_inizio);
		GregorianCalendar data_fine = new GregorianCalendar(anno_fine,mese_fine-1,giorno_fine);
		long millisecondi_inizio = data_inizio.getTimeInMillis();
		long millisecondi_fine = data_fine.getTimeInMillis();
		Date dataInizio = new Date(millisecondi_inizio);
		Date dataFine = new Date(millisecondi_fine);
		
		
		
		
		boolean ok = EventoBusiness.getInstance().registraEvento(dataInizio,turno.getText(),dataFine);
		if(ok) {
			JOptionPane.showMessageDialog(null, "Inserimento avvenuto correttamente!");
			new AreaIstruttore(istruttore);
			frame.dispose();
			}
		else
			JOptionPane.showMessageDialog(null, "C'è qualche errore.Riprova");	
	}
}