package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreDisGinr;

public class InfoDisciplina extends JFrame{
	
	JPanel nordPnl=new JPanel();
	//JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	JPanel titolo= new JPanel(new FlowLayout());
	JLabel disciplina= new JLabel("NOME DISCIPLINA SELEZIONATA");
	
	JButton indietro= new JButton("INDIETRO");
	
	
	public InfoDisciplina() {
		super("NOME DISCIPLINA");
		
	
		nordPnl.add(titolo);
		titolo.add(disciplina);
		
		indietro.addActionListener(new AscoltatoreBackHome(this));
		sudPnl.add(indietro);
		
		
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		//this.getContentPane().add(centroPnl,BorderLayout.CENTER);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
	
	
	
		this.setSize(1500, 750);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();  // prende la dimensione(risoluzione) dello schermo
		this.setLocation((int)((dim.getWidth()-this.getWidth())/2),(int)((dim.getHeight()-this.getHeight())/2));
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//System.out.println(dim);
	}

	public static void main(String[] args) {
	
		new InfoDisciplina();
	}
}

