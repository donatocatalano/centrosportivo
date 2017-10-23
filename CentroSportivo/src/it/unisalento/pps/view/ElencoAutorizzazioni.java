package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.model.Responsabile;

public class ElencoAutorizzazioni extends JFrame {
	
	JPanel nordPnl=new JPanel(new GridLayout(1,3));
	JPanel centroPnl=new JPanel(new GridLayout(3,4));
	JPanel sudPnl=new JPanel();
	
	
	
	JButton indietro= new JButton("INDIETRO");
	
	AscoltatoreBackResp ascoltatoreBackResp; 
	Responsabile responsabile;

	public ElencoAutorizzazioni(Responsabile responsabile) {
		super("Autorizzazioni pendenti");
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		sudPnl.add(indietro);
		
		
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