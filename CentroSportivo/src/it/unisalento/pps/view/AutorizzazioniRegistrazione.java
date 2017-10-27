package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.business.TestimonianzaBusiness;
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreAutorizzazioni;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreCatalogoDiscipline;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Testimonianza;
import it.unisalento.pps.model.Utente;

public class AutorizzazioniRegistrazione extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
		
	JButton indietro= new JButton("INDIETRO");
		
	
	AscoltatoreAutorizzazioni ascoltatoreAutorizzazioni;
	Responsabile responsabile;	
	ArrayList<Utente> registrazioni = new ArrayList<Utente>();
		
	public AutorizzazioniRegistrazione(Responsabile responsabile){
		super("Registrazioni in attesa di conferma");	
		 
		registrazioni = UtenteBusiness.getInstance().getUtenteByIdUtente(utente.getIdUtente());
		centroPnl.setLayout(new GridLayout(registrazioni.size(),1));
		if(registrazioni.size()>0) {
			for(int i=0;i<registrazioni.size();i++) {
			JLabel contenuto = new JLabel(registrazioni.get(i).getContenuto());		
			contenuto.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(contenuto);		
			}
		}
		else {
			JLabel contenuto = new JLabel("Nessuna Testimonianza");	
			contenuto.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(contenuto);		
		}			
		
			  
		ascoltatoreAutorizzazioni = new AscoltatoreAutorizzazioni(this, responsabile);
		indietro.addActionListener(ascoltatoreAutorizzazioni);
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
