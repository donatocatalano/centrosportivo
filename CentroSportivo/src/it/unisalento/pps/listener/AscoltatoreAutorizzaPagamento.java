package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.business.PagamentoBusiness;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Pagamento;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.view.AutorizzazioniPagamento;

public class AscoltatoreAutorizzaPagamento implements ActionListener {
	
	private JFrame frame;
	private Responsabile responsabile;	
	private Pagamento pagamento;

	public AscoltatoreAutorizzaPagamento(AutorizzazioniPagamento frame, Responsabile responsabile, Pagamento pagamento) {
		this.frame = frame;
		this.responsabile = responsabile;
		this.pagamento = pagamento;
	}
	
	public void actionPerformed(ActionEvent e){
		
		Object[] options = {"SI","NO"};
		int n = JOptionPane.showOptionDialog(frame,   // restituisce 0 se clicco il primo tasto, 1 se premo il secondo
			"Vuoi autorizzare il pagamento?",
			"ATTENZIONE !!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
		
		
		if(n==0) {
			boolean ok = PagamentoBusiness.getInstance().autorizzaPagamento(pagamento.getIdPagamento(), responsabile.getIdResponsabile());
			JOptionPane.showMessageDialog(null, "Pagamento autorizzato!");
			new AutorizzazioniPagamento(responsabile);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(null, "Pagamento non autorizzato!");
		}
	}
}