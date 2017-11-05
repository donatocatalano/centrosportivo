package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreAutorizzazioni;
import it.unisalento.pps.listener.AscoltatoreEliminaPrenotazione;
import it.unisalento.pps.listener.AscoltatoreAutorizzaModificaPrenotazione;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Prenotazione;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;

public class AutorizzazioniModifichePrenotazioni extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	
	JButton indietro= new JButton("INDIETRO");
		
	
	AscoltatoreAutorizzazioni ascoltatoreAutorizzazioni;
	AscoltatoreAutorizzaModificaPrenotazione ascoltatoreAutorizzaModificaPrenotazione;
	AscoltatoreEliminaPrenotazione ascoltatoreEliminaPrenotazione;
	Responsabile responsabile;
	ArrayList<Prenotazione> prenotazioniDaAutorizzare = new ArrayList<Prenotazione>();
		
	public AutorizzazioniModifichePrenotazioni(Responsabile responsabile, Prenotazione prenotazione){
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());	
		
		titolo.setText("RICHIESTE DI MODIFICA"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
			
		prenotazioniDaAutorizzare = PrenotazioneBusiness.getInstance().getPrenotazioniDaAutorizzare();
		
		Utente utente;
		Evento evento;
			  
		if(prenotazioniDaAutorizzare.size()>0) {	
			
			contenuto.setLayout(new GridLayout(prenotazioniDaAutorizzare.size(),1));
			centroPnl.add(contenuto);
			
			for(int i=0;i<prenotazioniDaAutorizzare.size();i++) {
				evento = EventoBusiness.getInstance().getEventoById(prenotazioniDaAutorizzare.get(i).getEvento());
				utente = UtenteBusiness.getInstance().getUtenteById(prenotazioniDaAutorizzare.get(i).getUtente());
				
				String giorno = prenotazioniDaAutorizzare.get(i).getDataPrenotazione().toString().substring(8,10);
				String mese = prenotazioniDaAutorizzare.get(i).getDataPrenotazione().toString().substring(5,7);
				String anno = prenotazioniDaAutorizzare.get(i).getDataPrenotazione().toString().substring(0,4);	
				
				JPanel contenuto1 = new JPanel(new FlowLayout());
				JLabel campo_prenotazione = new JLabel("Richiesta di modifica del "+giorno+"/"+mese+"/"+anno+" DI "+utente.getNome()+" "+utente.getCognome()+"   EVENTO: "+evento.getDisciplina()+"   ");	
				campo_prenotazione.setFont(new Font("sansserif",Font.BOLD,20));
				JButton autorizzaprenotazione = new JButton("AUTORIZZA MODIFICA");
				JButton eliminaprenotazione = new JButton ("CANCELLA PRENOTAZIONE");
				contenuto1.add(campo_prenotazione);
				contenuto1.add(autorizzaprenotazione);
				contenuto1.add(eliminaprenotazione);
				contenuto.add(contenuto1);
				
				JPanel contenuto2 = new JPanel();
				contenuto.add(contenuto2);
				
				ascoltatoreEliminaPrenotazione= new AscoltatoreEliminaPrenotazione(this, responsabile, prenotazioniDaAutorizzare.get(i));
				eliminaprenotazione.addActionListener(ascoltatoreEliminaPrenotazione);
				
				ascoltatoreAutorizzaModificaPrenotazione = new AscoltatoreAutorizzaModificaPrenotazione(this, responsabile, prenotazioniDaAutorizzare.get(i));
				autorizzaprenotazione.addActionListener(ascoltatoreAutorizzaModificaPrenotazione);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessuna modifica in attesa di autorizzazione");	
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
