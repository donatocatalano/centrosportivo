package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

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

public class AreaIscrizioniEventi extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new FlowLayout());
	JPanel sudPnl=new JPanel(new GridLayout(3,1));
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel scelta = new JLabel("SCEGLI LA DISCIPLINA, IL LIVELLO, IL TURNO E IL METODO DI PAGAMENTO");
	
	JPanel contenuto = new JPanel(new GridLayout(2,1));
	
	JPanel contenutoVuoto = new JPanel();
	
	public JPanel contenutopagamento = new JPanel(new FlowLayout());
	JLabel selPagamento = new JLabel("SELEZIONA METODO DI PAGAMENTO   ");
	public JRadioButton carta = new JRadioButton();
	public JRadioButton paypal = new JRadioButton();
	public JRadioButton contanti = new JRadioButton();
	ButtonGroup group_pagamento = new ButtonGroup();
	ButtonGroup group_livello = new ButtonGroup();
	
	public JRadioButton livello;
	
	public JRadioButton campo_evento;
	ButtonGroup group_evento = new ButtonGroup();
	
	
	JPanel contenutolivello=new JPanel(new FlowLayout());
	JPanel contenutotasti = new JPanel(new FlowLayout());
	JButton indietro = new JButton("INDIETRO");
	JButton iscrizione = new JButton("INVIA ISCRIZIONE E STAMPA RICEVUTA");
	
		
	AscoltatoreBackHome ascoltatoreBackHome; 
	Utente tesserato;
	Istruttore istruttore;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	ArrayList<Evento> eventi = new ArrayList<Evento>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
	
	public AreaIscrizioniEventi(Utente tesserato) {
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
					eventi = EventoBusiness.getInstance().getEventi();
					livelli = LivelloBusiness.getInstance().getLivelli();
						if(eventi.size()>0) {                                     
							for(int i=0;i<eventi.size();i++) {
								System.out.println(eventi.size());
								
								disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(eventi.get(i).getDisciplina());
								spazio = SpazioBusiness.getInstance().getSpazioById(eventi.get(i).getSpazio());
								tipoevento = TipoEventoBusiness.getInstance().getTipoEventoById(eventi.get(i).getTipo());
			
								String giorno_inizio= eventi.get(i).getDataInizio().toString().substring(8,10);
								String mese_inizio = eventi.get(i).getDataInizio().toString().substring(5,7);
								String anno_inizio =eventi.get(i).getDataInizio().toString().substring(0,4);	
			
								String giorno_fine= eventi.get(i).getDataFine().toString().substring(8,10);
								String mese_fine = eventi.get(i).getDataFine().toString().substring(5,7);
								String anno_fine =eventi.get(i).getDataFine().toString().substring(0,4);
			
								campo_evento = new JRadioButton(eventi.get(i).getIdEvento()+"  "+disciplina.getNome()+ ": INIZIA IL:  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   ORARI:  " +eventi.get(i).getTurno()+ "   TERMINA IL:  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome() +"  TIPO:  "+tipoevento.getTipo()+ "  COSTO:  � "+disciplina.getCostoMensile()+"0");	
								campo_evento.setFont(new Font("sansserif",Font.BOLD,20));
				
								JPanel contenuto1=new JPanel(new GridLayout(2,1));
								contenuto1.add(contenutoVuoto);
								contenuto1.add(campo_evento);
								contenuto.setLayout(new GridLayout(eventi.size(),1));
								contenuto.add(contenuto1);
				
								group_evento.add(campo_evento);
							}
							selPagamento.setFont(new Font("sansserif",Font.BOLD,22));
							contenutopagamento.add(selPagamento);
							carta.setText("Carta di credito");
							paypal.setText("Paypal");
							contanti.setText("Contanti");
							group_pagamento.add(carta);
							group_pagamento.add(paypal);
							group_pagamento.add(contanti);
							carta.setFont(new Font("sansserif",Font.BOLD,20));
							paypal.setFont(new Font("sansserif",Font.BOLD,20));
							contanti.setFont(new Font("sansserif",Font.BOLD,20));
							contenutopagamento.add(carta);
							contenutopagamento.add(paypal);
							contenutopagamento.add(contanti);
							sudPnl.add(contenutopagamento);
							
							
							if(livelli.size()>0) {
								JLabel titolo = new JLabel ("SELEZIONA LIVELLO   ");
								contenutolivello.add(titolo);
								titolo.setFont(new Font("sansserif",Font.BOLD,22));
								for(int i=0;i<livelli.size();i++) {
									livello = new JRadioButton(livelli.get(i).getNome());
									livello.setFont(new Font("sansserif",Font.BOLD,20));
									contenutolivello.add(livello);
									
									group_livello.add(livello);
								}
							}	
							
							ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
							indietro.addActionListener(ascoltatoreBackHome);
							indietro.setActionCommand(AscoltatoreBackHome.D1);
							contenutotasti.add(indietro);
							//iscrizione.addActionListener(new AscoltatoreConfermaIscrizioni(this, tesserato));
							contenutotasti.add(iscrizione);
						}
						else {
							JLabel nessunaoccorrenza = new JLabel("Nessun Evento nel sistema");	
							nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
							contenutoVuoto.add(nessunaoccorrenza);
							centroPnl.add(contenutoVuoto);		
						}
				}
				else { 
					JLabel nessunaoccorrenza = new JLabel("Non sei abilitato a visualizzare gli eventi! Iscriviti prima ad un corso!");	
					nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
					contenutoVuoto.add(nessunaoccorrenza);
					centroPnl.add(contenutoVuoto);		
				}	
			}
		}
		centroPnl.add(contenuto);
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);
		contenutotasti.add(indietro);
		
		sudPnl.add(contenutolivello);
		sudPnl.add(contenutotasti);
		
		
		
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


