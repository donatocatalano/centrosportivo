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
		
		boolean ok = DisciplinaBusiness.getInstance().cancellaDisciplina();
		if(ok) {
			JOptionPane.showMessageDialog(null, "Disciplina eliminata!");
			new CatalogoDiscipline(responsabile);
			frame.dispose();
		}
	}
}