package it.unisalento.pps.view;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.listener.*;
import it.unisalento.pps.model.Istruttore;



public class AreaIstruttore extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(1,3));
	JPanel centroPnl=new JPanel(new GridLayout(3,4));
	JPanel sudPnl=new JPanel();
	
	
	JLabel vuoto00 = new JLabel ("");
	JLabel titolo = new JLabel ("");
	JLabel vuoto000 = new JLabel ("");
        
	JPanel vuoto0 = new JPanel ();
	JPanel vuoto1 = new JPanel ();
	JPanel vuoto2 = new JPanel ();
	JPanel vuoto3 = new JPanel ();
	JPanel vuoto4 = new JPanel ();
	JButton corsi = new JButton("<html><p align=\"center\"><b>GESTIONE</b><br>CORSI</p></html>");
	JButton eventi = new JButton("<html><p align=\"center\"><b>GESTIONE</b><br>EVENTI</p></html>");
	JPanel vuoto7 = new JPanel ();
	JPanel vuoto8 = new JPanel ();
	JPanel vuoto9 = new JPanel ();
	JPanel vuoto10 = new JPanel ();
	JPanel vuoto11 = new JPanel ();
		
	JButton indietro= new JButton("LOGOUT");
		
	AscoltatoreEventi ascoltatoreEventi;
	AscoltatoreCorsi ascoltatoreCorsi;
	Istruttore istruttore;
		
	public AreaIstruttore(Istruttore istruttore){
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
			
			
		nordPnl.add(vuoto00);
		nordPnl.add(titolo);
		nordPnl.add(vuoto000);
			
			
		centroPnl.add(vuoto0);
		centroPnl.add(vuoto1);
		centroPnl.add(vuoto2);
		centroPnl.add(vuoto3);
		centroPnl.add(vuoto4);
		ascoltatoreCorsi = new AscoltatoreCorsi(this, istruttore);
		corsi.addActionListener(ascoltatoreCorsi);
		corsi.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(corsi);
		ascoltatoreEventi = new AscoltatoreEventi(this, istruttore);
		eventi.addActionListener(ascoltatoreEventi);
		eventi.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(eventi);
		centroPnl.add(vuoto7);
		centroPnl.add(vuoto8);
		centroPnl.add(vuoto9);
		centroPnl.add(vuoto10);
		centroPnl.add(vuoto11);
			  
			
		indietro.addActionListener(new AscoltatoreBackHome(this));
		sudPnl.add(indietro);
			
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
