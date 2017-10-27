package it.unisalento.pps.listener;

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

public class AscoltatoreConfermaCorso implements ActionListener {
	
	private FormCorso frame;
	private FormEvento frame1;
	private Istruttore istruttore;
	

	public AscoltatoreConfermaCorso(FormCorso frame, Istruttore istruttore) {
		this.frame = frame;
		this.istruttore = istruttore;
	}
	
	public AscoltatoreConfermaCorso(FormEvento frame1, Istruttore istruttore) {
		this.frame1 = frame1;
		this.istruttore = istruttore;
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		JTextField datainizio = frame.datainizio_field;
		JTextField turno = frame.turno_field;
		//JTextField luogo = frame.luogo_field;
		//JTextField tipoevento = frame.tipoevento_field;
		//JTextField disciplina = frame.disciplina_field;
		JTextField datafine = frame.datafine_field;
		
		
		//manipolazione data
		
		int anno = Integer.parseInt((datainizio.getText().substring(6,10)));   ///23-12-1965
		int mese = Integer.parseInt(datainizio.getText().substring(3,5));
		int giorno = Integer.parseInt(datainizio.getText().substring(0,2));
		
		int anno1 = Integer.parseInt(datafine.getText().substring(6,10));   ///23-12-1965
		int mese1 = Integer.parseInt(datafine.getText().substring(3,5));
		int giorno1 = Integer.parseInt(datafine.getText().substring(0,2));
		
		GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
		long millisecondi = data.getTimeInMillis();
		Date dataInizio = new Date(millisecondi);
		Date dataFine = new Date(millisecondi);
		
		//System.out.println(millisecondi);
		
		
		boolean ok = EventoBusiness.getInstance().registraEvento(dataInizio,turno.getText(),dataFine);
		if(ok) {
			JOptionPane.showMessageDialog(null, "Inserimento avvenuto correttamente!");
			new AreaIstruttore(istruttore);
			frame.dispose();
			frame1.dispose();
			}
		else
			JOptionPane.showMessageDialog(null, "C'è qualche errore.Riprova");	
	}
}