package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.model.Responsabile;

public class ElencoAutorizzazioni extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	
	JButton indietro= new JButton("INDIETRO");
	JLabel 	titolo = new JLabel();
	AscoltatoreBackResp ascoltatoreBackResp; 
	Responsabile responsabile;

	public ElencoAutorizzazioni(Responsabile responsabile) {
		super("Autorizzazioni pendenti");
		
		titolo.setText(" AUTORIZZAZIONI PENDENTI : "); // inserire collegamento a database
		titolo.setFont(new Font("sansserif",Font.BOLD,20));
		nordPnl.add(titolo);
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
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
