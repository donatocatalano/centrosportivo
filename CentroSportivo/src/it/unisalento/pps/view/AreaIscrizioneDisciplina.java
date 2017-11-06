package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreConfermaIscrizioni;
import it.unisalento.pps.listener.RadioButtonActionListener;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Utente;

public class AreaIscrizioneDisciplina extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel nordPnl=new JPanel();
	private JPanel centroPnl=new JPanel(new GridLayout(3,1));
	private JPanel sudPnl=new JPanel(new GridLayout(1,1));
	private JPanel titolo = new JPanel(new FlowLayout());
	private JLabel scelta = new JLabel();
	
	//private JPanel contenuto = new JPanel(new GridLayout(2,1));
	
	//private JPanel contenutoVuoto = new JPanel();
	
	public JPanel contenutopagamento = new JPanel(new FlowLayout());
	private JLabel selPagamento = new JLabel("SELEZIONA METODO DI PAGAMENTO   ");
	public JRadioButton carta = new JRadioButton();
	public JRadioButton paypal = new JRadioButton();
	public JRadioButton contanti = new JRadioButton();
	ButtonGroup group_pagamento = new ButtonGroup();
	ButtonGroup group_livello = new ButtonGroup();
	public 	JRadioButton livello;
	String selectedButton;
	
	
	
	public JRadioButton campo_evento;
	ButtonGroup group_evento = new ButtonGroup();
	
	
	JPanel contenutolivello=new JPanel(new FlowLayout());
	JPanel contenutotasti = new JPanel(new FlowLayout());
	JButton indietro = new JButton("TORNA ALL'HOMEPAGE");
	JButton iscrizione = new JButton("INVIA ISCRIZIONE");
	JButton ricevuta = new JButton("STAMPA RICEVUTA");
		
	AscoltatoreBackHome  ascoltatoreBackHome; 
	Utente tesserato;
	Istruttore istruttore;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	ArrayList<Evento> corsi = new ArrayList<Evento>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	
	public AreaIscrizioneDisciplina(Utente tesserato, Disciplina disciplina) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		
		scelta.setText("Iscrizione ai CORSI ed agli EVENTI di "+disciplina.getNome().toUpperCase());
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		centroPnl.add(titolo);		
		
		livelli = LivelloBusiness.getInstance().getLivelli();		
		
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
				livello.setActionCommand("button " + i);
				
				try {
                    //method to call, after pressed a button
                    Method m = getClass().getDeclaredMethod("RadioButton" + (i+1), null);
                    ActionListener al = new RadioButtonActionListener(m, this);
                    livello.addActionListener(al);
                } catch (SecurityException e) {
                      e.printStackTrace();
                } catch (NoSuchMethodException e) {
                      e.printStackTrace();
                }
				
				contenutolivello.add(livello);				
				group_livello.add(livello);
			}
			
		}	
		
		 
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);
		contenutotasti.add(indietro);
		iscrizione.addActionListener(new AscoltatoreConfermaIscrizioni(this, tesserato,disciplina));
		contenutotasti.add(iscrizione);
		contenutotasti.add(ricevuta);
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
	
	
	
	public String getSelectedButton() {
		return selectedButton;
	}
		//Al massimo 6 livelli
	public void RadioButton1() {
	    selectedButton = "1";
	}

	public void RadioButton2() {
		selectedButton ="2";
	}

	public void RadioButton3() {
		selectedButton ="3";
	}
	
	public void RadioButton4() {
		selectedButton ="4";
	}
	public void RadioButton5() {
		selectedButton ="5";
	}
	public void RadioButton6() {
		selectedButton ="6";
	}

}

