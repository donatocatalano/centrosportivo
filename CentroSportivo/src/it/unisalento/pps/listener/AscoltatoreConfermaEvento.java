package it.unisalento.pps.listener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
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
		String spazio = frame.combo_luogo.getSelectedItem().toString();
		String tipo = frame.combo_evento.getSelectedItem().toString();
		String disciplina = frame.combo_disciplina.getSelectedItem().toString();
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
		
		
		int spazioId = SpazioBusiness.getInstance().getIdSpazioByNome(spazio);
		int tipoId = TipoEventoBusiness.getInstance().getIdTipoEventoByNome(tipo);
		int disciplinaId = DisciplinaBusiness.getInstance().getIdDisciplinaByNome(disciplina);
		
		
		
		boolean ok = EventoBusiness.getInstance().registraEvento(dataInizio,turno.getText(),istruttore.getIdIstruttore(),spazioId,tipoId,disciplinaId,dataFine);
		if(ok) {
			JOptionPane.showMessageDialog(null, "Inserimento avvenuto correttamente!");
			new AreaIstruttore(istruttore);
			frame.dispose();
			}
		else
			JOptionPane.showMessageDialog(null, "C'è qualche errore.Riprova");	
	}
}