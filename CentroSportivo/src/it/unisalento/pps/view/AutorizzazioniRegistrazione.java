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

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreAutorizzazioni;
import it.unisalento.pps.listener.AscoltatoreConfermaRegistrazione;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;

public class AutorizzazioniRegistrazione extends JFrame{
	
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel(new GridLayout(2,1));
		
	JButton indietro = new JButton("INDIETRO");
		
	
	AscoltatoreAutorizzazioni ascoltatoreAutorizzazioni;
	AscoltatoreConfermaRegistrazione ascoltatoreConfermaRegistrazione;
	Responsabile responsabile;	
	ArrayList<Utente> utentiDaAutorizzare = new ArrayList<Utente>();
		
	public AutorizzazioniRegistrazione(Responsabile responsabile){
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());	
		
		titolo.setText("REGISTRAZIONI IN ATTESA DI CONFERMA"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		 
		
		utentiDaAutorizzare = UtenteBusiness.getInstance().getUtentiDaAutorizzare();
		
		
		if(utentiDaAutorizzare.size()>0) {	
			
			centroPnl.add(contenuto);
			
			for(int i=0;i<utentiDaAutorizzare.size();i++) {
				
				JPanel contenuto1 = new JPanel();
				contenuto1.setLayout(new GridLayout(utentiDaAutorizzare.size(),1));
				JLabel nomeUtente = new JLabel(utentiDaAutorizzare.get(i).getNome()+" "+utentiDaAutorizzare.get(i).getCognome()+" nato il " +utentiDaAutorizzare.get(i).getDataNascita()+" USERNAME: "+utentiDaAutorizzare.get(i).getUsername());	
				nomeUtente.setFont(new Font("sansserif",Font.BOLD,20));
				contenuto1.add(nomeUtente);
				contenuto.add(contenuto1);
				
				JPanel contenuto2 = new JPanel();
				JButton confermaregistrazione = new JButton("CONFERMA REGISTRAZIONE");
				ascoltatoreConfermaRegistrazione = new AscoltatoreConfermaRegistrazione(this, responsabile);
				confermaregistrazione.addActionListener(ascoltatoreConfermaRegistrazione);
				contenuto2.add(confermaregistrazione);
				contenuto.add(contenuto2);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Utente in attesa di autorizzazione all'Iscrizione");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenuto.add(nessunaoccorrenza);
			centroPnl.add(contenuto);		
		}			
		
			  
		ascoltatoreAutorizzazioni = new AscoltatoreAutorizzazioni(this, responsabile);
		indietro.addActionListener(ascoltatoreAutorizzazioni);
		sudPnl.add(indietro);


			
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		this.getContentPane().add(centroPnl,BorderLayout.WEST);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
			
			
		int height=Toolkit.getDefaultToolkit().getScreenSize().getSize().height;  // prende la dimensione(risoluzione) dello schermo
		int width=Toolkit.getDefaultToolkit().getScreenSize().getSize().width;  // prende la dimensione(risoluzione) dello schermo
		this.setSize(width, height);
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}	
}