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
	
	JLabel titolo = new JLabel();
		
	JButton indietro= new JButton("INDIETRO");
		
	
	AscoltatoreAutorizzazioni ascoltatoreAutorizzazioni;
	Responsabile responsabile;	
	ArrayList<Utente> utentiDaAutorizzare = new ArrayList<Utente>();
		
	public AutorizzazioniRegistrazione(Responsabile responsabile){
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());	
		
		titolo.setText("REGISTRAZIONI IN ATTESA DI CONFERMA"); 
		titolo.setFont(new Font("sansserif",Font.BOLD,20));
		nordPnl.add(titolo);
		 
		
		utentiDaAutorizzare = UtenteBusiness.getInstance().getUtentiDaAutorizzare();
		centroPnl.setLayout(new GridLayout(utentiDaAutorizzare.size(),1));
		
		if(utentiDaAutorizzare.size()>0) {
			for(int i=0;i<utentiDaAutorizzare.size();i++) {
			JLabel nomeUtente = new JLabel(utentiDaAutorizzare.get(i).getNome());	//qui oltre al nome bisogna aggiungere cognome, username, password ...	
			nomeUtente.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(nomeUtente);		
			}
		}
		else {
			JLabel nomeUtente = new JLabel("Nessun Utente in attesa di autorizzazione all'Iscrizione");	
			nomeUtente.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(nomeUtente);		
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
