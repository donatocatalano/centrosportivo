package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unisalento.pps.listener.AscoltatoreAutIsc;
import it.unisalento.pps.listener.AscoltatoreAutPag;
import it.unisalento.pps.listener.AscoltatoreAutReg;
import it.unisalento.pps.listener.AscoltatoreAutorizzazioni;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;

public class ElencoAutorizzazioni extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new GridLayout(3,3));
	JPanel sudPnl=new JPanel();
	
	JPanel vuoto0 = new JPanel ();
	JPanel vuoto1 = new JPanel ();
	JPanel vuoto2 = new JPanel ();
	JButton registrazioni = new JButton("<html><p align=\"center\"><b>AUTORIZZAZIONI</b><br>REGISTRAZIONE</p></html>");
	JButton iscrizioni = new JButton("<html><p align=\"center\"><b>AUTORIZZAZIONI</b><br>CORSI ED EVENTI</p></html>");
	JButton pagamenti = new JButton("<html><p align=\"center\"><b>AUTORIZZAZIONI</b><br>PAGAMENTI</p></html>");
	JPanel vuoto3 = new JPanel ();
	JPanel vuoto4 = new JPanel ();
	JPanel vuoto5 = new JPanel ();
	
	JButton indietro= new JButton("INDIETRO");
	
	AscoltatoreAutReg ascoltatoreAutReg;
	AscoltatoreAutIsc ascoltatoreAutIsc;
	AscoltatoreAutPag ascoltatoreAutPag;
	AscoltatoreBackResp ascoltatoreBackResp; 
	Responsabile responsabile;
	Utente utente;

	public ElencoAutorizzazioni(Responsabile responsabile) {
		super("Elenco Autorizzazioni");
		
		
		centroPnl.add(vuoto0);
		centroPnl.add(vuoto1);
		centroPnl.add(vuoto2);
		
		
		ascoltatoreAutReg = new AscoltatoreAutReg(this, responsabile);
		registrazioni.addActionListener(ascoltatoreAutReg);
		registrazioni.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(registrazioni);
		ascoltatoreAutIsc = new AscoltatoreAutIsc(this, responsabile);
		iscrizioni.addActionListener(ascoltatoreAutIsc);
		iscrizioni.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(iscrizioni);
		ascoltatoreAutPag = new AscoltatoreAutPag(this, responsabile);
		pagamenti.addActionListener(ascoltatoreAutPag);
		pagamenti.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(pagamenti);
		centroPnl.add(vuoto3);
		centroPnl.add(vuoto4);
		centroPnl.add(vuoto5);
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		sudPnl.add(indietro);
		
		
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
