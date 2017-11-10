package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;
import it.unisalento.pps.model.Utente;

public class AreaPrenotazioni extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel nordPnl=new JPanel();
	private JPanel centroPnl=new JPanel();  
	private JPanel sudPnl=new JPanel();
	
	private JPanel noEventi = new JPanel();
	
	
	private JPanel titolo = new JPanel(new FlowLayout());
	private JLabel scelta = new JLabel("SELEZIONA I CORSI E GLI EVENTI PER CUI TI VUOI PRENOTARE");
	
	
	
	
	JButton indietro = new JButton("INDIETRO");
	JButton iscrizione = new JButton("INVIA PRENOTAZIONE");
	JButton distinta = new JButton("STAMPA DISTINTA");
		
	AscoltatoreBackHome ascoltatoreBackHome; 
	Istruttore istruttore;
	ArrayList<Evento> eventi = new ArrayList<Evento>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
	
	public AreaPrenotazioni(Utente tesserato) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		//centroPnl.setLayout(new GridLayout(3,1));
			
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		nordPnl.add(titolo);
		
		
		iscrizioni = IscrizioneBusiness.getInstance().getIscrizioniAutorizzate();
		livelli = LivelloBusiness.getInstance().getLivelli();
		
		
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
			
								JCheckBox campo_evento = new JCheckBox( tipoevento.getTipo().toUpperCase()+" di "+disciplina.getNome().toUpperCase()+ " dal  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"  al  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+" orario "+eventi.get(j).getTurno()+ " in  "+spazio.getNome().toUpperCase());	
								campo_evento.setFont(new Font("sansserif",Font.BOLD,20));
				
																
								
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
			contenutotasti.add(iscrizione);
			distinta.setFont(new Font("sansserif",Font.BOLD,20));
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
}


