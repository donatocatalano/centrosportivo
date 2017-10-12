package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;
import it.unisalento.pps.view.InfoDisciplina;
import it.unisalento.pps.view.IstruttoreInizio;


	public class AscoltatoreBackHome implements ActionListener{
	
		private InfoDisciplina infodisciplinawindow;
		private IstruttoreInizio istruttoreinizio;
		private	FormRegistrazione formregistrazione;
		
	public AscoltatoreBackHome(InfoDisciplina infodisciplinawindow) {
		super();
		this.infodisciplinawindow = infodisciplinawindow;
	}
	
	public AscoltatoreBackHome(IstruttoreInizio istruttoreinizio) {
		super();
		this.istruttoreinizio = istruttoreinizio;
	}
	
	public AscoltatoreBackHome(FormRegistrazione formregistrazione) {
		super();
		this.formregistrazione = formregistrazione;
	}



	public void actionPerformed(ActionEvent e) {
	
	new Homepage();
	infodisciplinawindow.dispose();	
	istruttoreinizio.dispose();
	formregistrazione.dispose();
	}
}
