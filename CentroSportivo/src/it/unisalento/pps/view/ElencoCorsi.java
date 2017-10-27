package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreNuovoCorso;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;

public class ElencoCorsi extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	JLabel titolo = new JLabel();
	
	
	JButton indietro = new JButton("INDIETRO");
	JButton nuovocorso = new JButton("AGGIUNGI CORSO");

	AscoltatoreBackIst ascoltatoreBackIst; 
	AscoltatoreNuovoCorso ascoltatoreNuovoCorso;
	Istruttore istruttore;
	ArrayList<Evento> corsi = new ArrayList<Evento>();

	public ElencoCorsi(Istruttore istruttore) {
		super("Elenco Corsi");
		
		titolo.setText(" ELENCO CORSI "); 
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		
		corsi = EventoBusiness.getInstance().getCorsiByIdIstruttore(istruttore.getIdIstruttore());
		
		for(int i=0;i<corsi.size();i++) {
			JLabel corso = new JLabel("CORSO " +(i+1)+ ": INIZIO IN DATA:  " +corsi.get(i).getDataInizio()+ "   ORARI:  " +corsi.get(i).getTurno()+ "   TERMINA IL:  " +corsi.get(i).getDataFine());
			corso.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(corso);
			//disciplina.addActionListener(ascoltatoreDisciplina);
				}
		
		
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
		sudPnl.add(indietro);
		ascoltatoreNuovoCorso = new AscoltatoreNuovoCorso (this, istruttore);
		nuovocorso.addActionListener(ascoltatoreNuovoCorso);
		sudPnl.add(nuovocorso);
		
		
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		this.getContentPane().add(centroPnl,BorderLayout.CENTER);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
		
		
		int height=Toolkit.getDefaultToolkit().getScreenSize().getSize().height;  // prende la dimensione(risoluzione) dello schermo
		int width=Toolkit.getDefaultToolkit().getScreenSize().getSize().width;  // prende la dimensione(risoluzione) dello schermo
		this.setSize(width, height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

