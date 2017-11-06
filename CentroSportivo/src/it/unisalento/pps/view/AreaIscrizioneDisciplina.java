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
import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreBackInfoDisciplina;
import it.unisalento.pps.listener.AscoltatoreConfermaIscrizioni;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;
import it.unisalento.pps.model.Utente;

public class AreaIscrizioneDisciplina extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new GridLayout(3,1));
	JPanel sudPnl=new JPanel(new GridLayout(1,1));
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel scelta = new JLabel();
	
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
	JButton indietro = new JButton("TORNA ALL'HOMEPAGE");
	JButton iscrizione = new JButton("INVIA ISCRIZIONE E STAMPA RICEVUTA");
	
		
	AscoltatoreBackHome  ascoltatoreBackHome; 
	Utente tesserato;
	Istruttore istruttore;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	ArrayList<Evento> corsi = new ArrayList<Evento>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	
	public AreaIscrizioneDisciplina(Utente tesserato, Disciplina disciplina) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		
		scelta.setText("Iscrizione ai  CORSI  ed agli EVENTI di "+disciplina.getNome().toUpperCase());
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		centroPnl.add(titolo);
		
		//corsi = EventoBusiness.getInstance().getCorsiByIdDisciplina(disciplina.getIdDisciplina());
		livelli = LivelloBusiness.getInstance().getLivelli();
		
		/*Spazio spazio;
		TipoEvento tipoevento;
		
		
		if(corsi.size()>0) {
			for(int i=0;i<corsi.size();i++) {
				System.out.println(corsi.size());
				
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(corsi.get(i).getDisciplina());
				spazio = SpazioBusiness.getInstance().getSpazioById(corsi.get(i).getSpazio());
				tipoevento = TipoEventoBusiness.getInstance().getTipoEventoById(corsi.get(i).getTipo());
			
				String giorno_inizio= corsi.get(i).getDataInizio().toString().substring(8,10);
				String mese_inizio = corsi.get(i).getDataInizio().toString().substring(5,7);
				String anno_inizio =corsi.get(i).getDataInizio().toString().substring(0,4);	
			
				String giorno_fine= corsi.get(i).getDataFine().toString().substring(8,10);
				String mese_fine = corsi.get(i).getDataFine().toString().substring(5,7);
				String anno_fine =corsi.get(i).getDataFine().toString().substring(0,4);
			
				campo_evento = new JRadioButton(corsi.get(i).getIdEvento()+"  "+disciplina.getNome()+ ": INIZIA IL:  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   ORARI:  " +corsi.get(i).getTurno()+ "   TERMINA IL:  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome() +"  TIPO:  "+tipoevento.getTipo()+ "  COSTO:  € "+disciplina.getCostoMensile()+"0");	
				campo_evento.setFont(new Font("sansserif",Font.BOLD,20));
				
				JPanel contenuto1=new JPanel(new GridLayout(2,1));
				contenuto1.add(contenutoVuoto);
				contenuto1.add(campo_evento);
				contenuto.setLayout(new GridLayout(corsi.size(),1));
				contenuto.add(contenuto1);
				
				group_evento.add(campo_evento);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Corso nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}			
		
		centroPnl.add(contenuto);*/

		
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
		centroPnl.add(contenutopagamento);
		
		
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
		iscrizione.addActionListener(new AscoltatoreConfermaIscrizioni(this, tesserato));
		contenutotasti.add(iscrizione);
		centroPnl.add(contenutolivello);
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


