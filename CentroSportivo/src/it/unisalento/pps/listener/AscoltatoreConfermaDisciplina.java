package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AreaResponsabile;
import it.unisalento.pps.view.FormDisciplina;
import it.unisalento.pps.view.FormModDisciplina;

public class AscoltatoreConfermaDisciplina implements ActionListener {
	
	private FormDisciplina frame;
	private FormModDisciplina frame1;
	private Responsabile responsabile;
	private Disciplina disciplina;
	public final static String D1="d1";
	
	public AscoltatoreConfermaDisciplina(FormDisciplina frame, Responsabile responsabile) {
		this.frame = frame;
		this.responsabile = responsabile;
	}
	
	public AscoltatoreConfermaDisciplina(FormModDisciplina frame, Responsabile responsabile, Disciplina disciplina) {
		this.frame1 = frame;
		this.responsabile = responsabile;
		this.disciplina = disciplina;
	}

	public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
		
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();	
		else {
			JTextField nome = frame.nome_field;
			JTextField costo = frame.costo_field;
			JTextArea descrizione = frame.descrizione_field;
			JTextField immagine = frame.immagine_field;
			
	
			boolean ok = DisciplinaBusiness.getInstance().registraDisciplina(nome.getText(),Double.parseDouble(costo.getText()),immagine.getText(), descrizione.getText());
			if(ok) {
				JOptionPane.showMessageDialog(null, "Inserimento avvenuto correttamente!");
				new AreaResponsabile(responsabile);
				frame.dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "C'� qualche errore.Riprova");	
		}
	}
	
	private void d1launch() {
		JTextField nome = frame1.nome_field;
		JTextField costo = frame1.costo_field;
		JTextArea descrizione = frame1.descrizione_field;
		JTextField immagine = frame1.immagine_field;
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi modificare la disciplina?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		if(n==0) {
			boolean ok = DisciplinaBusiness.getInstance().aggiornaDisciplina(disciplina.getIdDisciplina(),nome.getText(),Double.parseDouble(costo.getText()),immagine.getText(), descrizione.getText());
				if (ok) {
					JOptionPane.showMessageDialog(null, "Aggiornamento avvenuto correttamente!");
					new AreaResponsabile(responsabile);
					frame1.dispose();			
				}
				else
					JOptionPane.showMessageDialog(null, "C'� qualche errore. Riprova");
		}
		else JOptionPane.showMessageDialog(null, "Disciplina non modificata!");
	}
}