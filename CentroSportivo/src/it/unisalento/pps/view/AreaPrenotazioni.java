package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unisalento.pps.business.*;
import it.unisalento.pps.listener.*;
import it.unisalento.pps.model.*;


public class AreaPrenotazioni extends JFrame implements ItemListener{
	
	private static final long serialVersionUID = 1L;
	private JPanel nordPnl=new JPanel();
	private JPanel centroPnl=new JPanel();  
	private JPanel sudPnl=new JPanel();
	
	private JPanel noEventi = new JPanel();
	
	
	private JPanel titolo = new JPanel(new FlowLayout());
	private JLabel scelta = new JLabel("SELEZIONA I CORSI E GLI EVENTI PER CUI TI VUOI PRENOTARE. SE GIA' PRENOTATI COMPARE LA SPUNTA");
	
	
	
	
	JButton indietro = new JButton("INDIETRO");
	JButton iscrizione = new JButton("INVIA PRENOTAZIONE");
	JButton distinta = new JButton("STAMPA DISTINTA");
		
	AscoltatoreBackHome ascoltatoreBackHome; 
	AscoltatorePrenotazioni ascoltatorePrenotazioni;
	AscoltatoreStampa ascoltatoreStampa;
	
	Istruttore istruttore;
	ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	ArrayList<Evento> eventi = new ArrayList<Evento>();
	ArrayList<Integer> idEventiSelezionati = new ArrayList<Integer>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
	JCheckBox campo_evento;
	ArrayList<JCheckBox> checkbox = new ArrayList<JCheckBox>();
	ArrayList<Integer> idEventiSelezionabili = new ArrayList<Integer>();
	
	
	public AreaPrenotazioni(Utente tesserato) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
					
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		nordPnl.add(titolo);
		
		
		iscrizioni = IscrizioneBusiness.getInstance().getIscrizioniAutorizzate();
		livelli = LivelloBusiness.getInstance().getLivelli();
		prenotazioni =PrenotazioneBusiness.getInstance().getPrenotazioni();
		
		
		Disciplina disciplina;
		Spazio spazio;
		TipoEvento tipoevento;
		boolean nonIscritto = true;
		int count=0;
		
		for(int i=0;i<iscrizioni.size();i++) {
				if(iscrizioni.get(i).getUtente()==tesserato.getIdUtente()){
					count++;
					
					disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(iscrizioni.get(i).getDisciplina());
					eventi = EventoBusiness.getInstance().getEventiCorsiByIdDisciplina(disciplina.getIdDisciplina());
					JPanel contenuto = new JPanel(new GridLayout(eventi.size(),1));
					 
						if(eventi.size()>0) {    
							
								
							for(int j=0;j<eventi.size();j++) {					
								spazio = SpazioBusiness.getInstance().getSpazioById(eventi.get(j).getSpazio());
								tipoevento = TipoEventoBusiness.getInstance().getTipoEventoById(eventi.get(j).getTipo());
			
								String giorno_inizio= eventi.get(j).getDataInizio().toString().substring(8,10);
								String mese_inizio = eventi.get(j).getDataInizio().toString().substring(5,7);
								String anno_inizio =eventi.get(j).getDataInizio().toString().substring(0,4);	
			
								String giorno_fine= eventi.get(j).getDataFine().toString().substring(8,10);
								String mese_fine = eventi.get(j).getDataFine().toString().substring(5,7);
								String anno_fine =eventi.get(j).getDataFine().toString().substring(0,4);
			
								campo_evento = new JCheckBox( tipoevento.getTipo().toUpperCase()+" di "+disciplina.getNome().toUpperCase()+ " dal  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"  al  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+" orario "+eventi.get(j).getTurno()+ " in  "+spazio.getNome().toUpperCase());	
								campo_evento.setFont(new Font("sansserif",Font.BOLD,20));
								campo_evento.addItemListener(this);
								for(int k=0;k<prenotazioni.size();k++) {
								if(eventi.get(j).getIdEvento() == prenotazioni.get(k).getEvento() && prenotazioni.get(k).getUtente() == tesserato.getIdUtente()) {
									campo_evento.setSelected(true);
									idEventiSelezionati.add(eventi.get(j).getIdEvento());
									
										}
								}
								checkbox.add(campo_evento);
								idEventiSelezionabili.add(eventi.get(j).getIdEvento());
															
								contenuto.add(campo_evento);								
								nonIscritto =false;								
									}
							
							centroPnl.add(contenuto);
								}
						else {
							
							JLabel nessunaoccorrenza = new JLabel("Nessun Corso o Evento disponibile per "+disciplina.getNome().toUpperCase());	
							nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
							noEventi.add(nessunaoccorrenza);
							
						}
						
					}
				}
		
			if(nonIscritto){
				
				JLabel nessunaoccorrenza = new JLabel("Non sei iscritto a nessuna Disciplina ! Iscriviti !");	
				nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
				noEventi.add(nessunaoccorrenza);
				
		}
					
			centroPnl.setLayout(new GridLayout(count+1,1));
			centroPnl.add(noEventi);
			JPanel contenutotasti = new JPanel(new FlowLayout());
			ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
			indietro.addActionListener(ascoltatoreBackHome);
			indietro.setActionCommand(AscoltatoreBackHome.D1);
			indietro.setFont(new Font("sansserif",Font.BOLD,20));
			contenutotasti.add(indietro);
			iscrizione.setFont(new Font("sansserif",Font.BOLD,20));
			ascoltatorePrenotazioni = new AscoltatorePrenotazioni(this,tesserato,idEventiSelezionati);
			iscrizione.addActionListener(ascoltatorePrenotazioni);
			contenutotasti.add(iscrizione);
			distinta.setFont(new Font("sansserif",Font.BOLD,20));
			ascoltatoreStampa = new AscoltatoreStampa(this,tesserato,idEventiSelezionati);
			distinta.addActionListener(ascoltatoreStampa);
			contenutotasti.add(distinta);
			
			
			sudPnl.add(contenutotasti);
			
		
				
		
		
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		 Object source = e.getItemSelectable();
	        for(int i=0;i<checkbox.size();i++) {
	        if (source == checkbox.get(i)) {
	        	 if (e.getStateChange() == ItemEvent.SELECTED ) {
	        		 
	        		 boolean si = idEventiSelezionati.add(idEventiSelezionabili.get(i));
	           /*if (si)   {       
	            	System.out.println(idEventiSelezionati.size());
	            
	        		} */
	            } 
	       

	        	 else if (e.getStateChange() == ItemEvent.DESELECTED)
	        	 	{
	        		boolean no = idEventiSelezionati.remove(idEventiSelezionabili.get(i));
	        		/* if(no) {
	        			 System.out.println(idEventiSelezionati.size());
	        		 
	        		 }
	        		 else {

	        			 System.out.println("non cancella");
	        		 }*/
	        	 		}
	        	 	}
	        	}
		
	}
}


