package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.CatalogoDiscipline;

public class AscoltatoreEliminaDisciplina implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;
	private Disciplina disciplina;
	
	public AscoltatoreEliminaDisciplina(CatalogoDiscipline frame, Responsabile responsabile, Disciplina disciplina) {
		super();
		this.frame = frame;
		this.responsabile = responsabile;
		this.disciplina = disciplina;
	}

	public void actionPerformed(ActionEvent e) {
		
		boolean ok = DisciplinaBusiness.getInstance().cancellaDisciplina(disciplina);
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
				"Vuoi eliminare la disciplina "+disciplina.getNome(),
				"ATTENZIONE !!",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
		//System.out.println(n);
		
		if(ok && n==0) {
			JOptionPane.showMessageDialog(null, "Disciplina eliminata!");
			new CatalogoDiscipline(responsabile);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Disciplina non eliminata!");
		}
			
	}
}