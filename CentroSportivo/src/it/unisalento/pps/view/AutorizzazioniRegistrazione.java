package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreAutorizzazioni;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;

public class AutorizzazioniRegistrazione extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	JLabel titolo = new JLabel();
	
	
		
	JButton indietro = new JButton("INDIETRO");
	JButton invio = new JButton("INVIA");
		
	
	AscoltatoreAutorizzazioni ascoltatoreAutorizzazioni;
	Responsabile responsabile;	
	ArrayList<Utente> utentiDaAutorizzare = new ArrayList<Utente>();
	Dimension dim;
		
	public AutorizzazioniRegistrazione(Responsabile responsabile){
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());	
		
		titolo.setText("REGISTRAZIONI IN ATTESA DI CONFERMA"); 
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		 
		
		utentiDaAutorizzare = UtenteBusiness.getInstance().getUtentiDaAutorizzare();
		centroPnl.setLayout(new GridLayout(utentiDaAutorizzare.size(),6));
		
		if(utentiDaAutorizzare.size()>0) {
			for(int i=0;i<utentiDaAutorizzare.size();i++) {
			JLabel vuoto = new JLabel ();
			JLabel vuoto0 = new JLabel ();
			JLabel nomeUtente = new JLabel(utentiDaAutorizzare.get(i).getNome()+" "+utentiDaAutorizzare.get(i).getCognome()+" nato il " +utentiDaAutorizzare.get(i).getDataNascita());	
			nomeUtente.setFont(new Font("sansserif",Font.BOLD,20));
			JButton confermaregistrazione= new JButton("CONFERMA REGISTRAZIONE");
			JLabel vuoto00 = new JLabel ();
			JLabel vuoto000 = new JLabel ();
			centroPnl.add(vuoto);
			centroPnl.add(vuoto0);
			centroPnl.add(nomeUtente);
			centroPnl.add(confermaregistrazione);
			centroPnl.add(vuoto00);
			centroPnl.add(vuoto000);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Utente in attesa di autorizzazione all'Iscrizione");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(nessunaoccorrenza);		
		}			
		
			  
		ascoltatoreAutorizzazioni = new AscoltatoreAutorizzazioni(this, responsabile);
		indietro.addActionListener(ascoltatoreAutorizzazioni);
		sudPnl.add(indietro);
		sudPnl.add(invio);


			
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
