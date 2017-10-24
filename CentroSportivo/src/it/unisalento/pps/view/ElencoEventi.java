package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.model.Istruttore;

public class ElencoEventi extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JScrollPane centroPnl=new JScrollPane();
	JPanel sudPnl=new JPanel();
	
	
	JButton indietro= new JButton("INDIETRO");

	AscoltatoreBackIst ascoltatoreBackIst; 
	Istruttore istruttore;

	public ElencoEventi(Istruttore istruttore) {
		super("Elenco Eventi");
		
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
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