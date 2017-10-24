package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;

public class AreaIscrizioniTesserato extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new GridLayout(4,1));
	JPanel sudPnl=new JPanel();
	
	
	JButton indietro = new JButton("INDIETRO");
	JButton iscrizione = new JButton("INVIA ISCRIZIONE AI CORSI");

	
	
	AscoltatoreBackHome ascoltatoreBackHome; 
	Utente tesserato;
	
	public AreaIscrizioniTesserato(Utente tesserato) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		
		
		
		
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);
		sudPnl.add(indietro);
		sudPnl.add(iscrizione);
		
		
		
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		this.getContentPane().add(centroPnl,BorderLayout.CENTER);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
	
	
	
		this.setSize(1500, 750);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();  // prende la dimensione(risoluzione) dello schermo
		this.setLocation((int)((dim.getWidth()-this.getWidth())/2),(int)((dim.getHeight()-this.getHeight())/2));
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}


