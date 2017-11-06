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
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new FlowLayout());
	JPanel sudPnl=new JPanel();
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel scelta = new JLabel("SELEZIONA I CORSI E GLI EVENTI A CUI SEI INTERESSATO");
	
	JPanel contenuto = new JPanel(new GridLayout(2,1));
	
	JPanel contenutoVuoto = new JPanel();
	
	
	public JCheckBox campo_evento;
	ButtonGroup group_evento = new ButtonGroup();
	
	
	JPanel contenutolivello=new JPanel(new FlowLayout());
	JButton indietro = new JButton("INDIETRO");
	JButton iscrizione = new JButton("INVIA ISCRIZIONE");
	JButton ricevuta = new JButton("STAMPA RICEVUTA");
		
	AscoltatoreBackHome ascoltatoreBackHome; 
	Istruttore istruttore;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	ArrayList<Evento> eventi = new ArrayList<Evento>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
	
	public AreaPrenotazioni(Utente tesserato) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		
		
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		nordPnl.add(titolo);
		
		
		iscrizioni = IscrizioneBusiness.getInstance().getIscrizioniAutorizzate();
		
		
		Disciplina disciplina;
		Spazio spazio;
		TipoEvento tipoevento;
		
		
		if(iscrizioni.size()>0) {
			for(int j=0;j<iscrizioni.size();j++) {
				if(iscrizioni.get(j).getUtente()==tesserato.getIdUtente()){
					disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(iscrizioni.get(j).getDisciplina());
					eventi = EventoBusiness.getInstance().getEventiCorsiByIdDisciplina(disciplina.getIdDisciplina());
					livelli = LivelloBusiness.getInstance().getLivelli();
						if(eventi.size()>0) {                    
							for(int i=0;i<eventi.size();i++) {					
								spazio = SpazioBusiness.getInstance().getSpazioById(eventi.get(i).getSpazio());
								tipoevento = TipoEventoBusiness.getInstance().getTipoEventoById(eventi.get(i).getTipo());
			
								String giorno_inizio= eventi.get(i).getDataInizio().toString().substring(8,10);
								String mese_inizio = eventi.get(i).getDataInizio().toString().substring(5,7);
								String anno_inizio =eventi.get(i).getDataInizio().toString().substring(0,4);	
			
								String giorno_fine= eventi.get(i).getDataFine().toString().substring(8,10);
								String mese_fine = eventi.get(i).getDataFine().toString().substring(5,7);
								String anno_fine =eventi.get(i).getDataFine().toString().substring(0,4);
			
								campo_evento = new JCheckBox(disciplina.getNome()+ ": INIZIA IL:  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   ORARI:  " +eventi.get(i).getTurno()+ "   TERMINA IL:  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome() +"  TIPO:  "+tipoevento.getTipo());	
								campo_evento.setFont(new Font("sansserif",Font.BOLD,20));
				
								JPanel contenuto1=new JPanel(new GridLayout(2,1));
								contenuto1.add(contenutoVuoto);
								contenuto1.add(campo_evento);
								contenuto.setLayout(new GridLayout(eventi.size(),1));
								contenuto.add(contenuto1);
								
								group_evento.add(campo_evento);
							}
						}
						else {
							JLabel nessunaoccorrenza = new JLabel("Nessun Evento nel sistema");	
							nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
							contenutoVuoto.add(nessunaoccorrenza);
							centroPnl.add(contenutoVuoto);	
							ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
							indietro.addActionListener(ascoltatoreBackHome);
							indietro.setActionCommand(AscoltatoreBackHome.D2);
							sudPnl.add(indietro);
						}
				}
				else { 
					JLabel nessunaoccorrenza = new JLabel("Non sei abilitato a visualizzare gli eventi! Iscriviti prima ad una disciplina!");	
					nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
					contenutoVuoto.add(nessunaoccorrenza);
					centroPnl.add(contenutoVuoto);	
					ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
					indietro.addActionListener(ascoltatoreBackHome);
					indietro.setActionCommand(AscoltatoreBackHome.D2);
					sudPnl.add(indietro);
				}	
			}// chiude il for
			
			JPanel contenutotasti = new JPanel(new FlowLayout());
			ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
			indietro.addActionListener(ascoltatoreBackHome);
			indietro.setActionCommand(AscoltatoreBackHome.D1);
			contenutotasti.add(indietro);
			contenutotasti.add(iscrizione);
			contenutotasti.add(ricevuta);
			//iscrizione.addActionListener(new AscoltatoreConfermaIscrizioni(this, tesserato));
			
			sudPnl.add(contenutotasti);
		}
		else { 
			JLabel nessunaoccorrenza = new JLabel("Non sei abilitato a visualizzare gli eventi! Iscriviti prima ad una disciplina!");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);	
			ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
			indietro.addActionListener(ascoltatoreBackHome);
			indietro.setActionCommand(AscoltatoreBackHome.D2);
			sudPnl.add(indietro);
		}
		centroPnl.add(contenuto);
		
		
		
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


