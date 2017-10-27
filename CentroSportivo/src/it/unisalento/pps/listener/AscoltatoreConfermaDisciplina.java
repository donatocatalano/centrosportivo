package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AreaIstruttore;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.FormCorso;
import it.unisalento.pps.view.FormDisciplina;

public class AscoltatoreConfermaDisciplina implements ActionListener {
	
	private FormDisciplina frame;
	private Responsabile responsabile;
	
	public AscoltatoreConfermaDisciplina(FormDisciplina frame, Responsabile responsabile) {
		this.frame = frame;
		this.responsabile = responsabile;
	}

	public void actionPerformed(ActionEvent arg0) throws IllegalArgumentException{
		JTextField nome = frame.nome_field;
		JTextField costo = frame.costo_field;
		JTextField descrizione = frame.descrizione_field;
		
		
		boolean ok = DisciplinaBusiness.getInstance().registraDisciplina(nome.getText(),Double.parseDouble(costo.getText()), descrizione.getText());
		if(ok) {
			JOptionPane.showMessageDialog(null, "Inserimento avvenuto correttamente!");
			new AreaResponsabile(responsabile);
			frame.dispose();
			}
		else
			JOptionPane.showMessageDialog(null, "C'è qualche errore.Riprova");	
	}

}
