package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.model.Responsabile;

public class CatalogoDiscipline extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JScrollPane centroPnl=new JScrollPane();
	JPanel sudPnl=new JPanel();


	JButton indietro= new JButton("INDIETRO");
	
	AscoltatoreBackResp ascoltatoreBackResp; 
	Responsabile responsabile;

	public CatalogoDiscipline(Responsabile responsabile) {
		super("Catalogo Discipline");
		
		
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