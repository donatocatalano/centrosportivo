package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import it.unisalento.pps.listener.*;


public class IstruttoreInizio extends JFrame{
	
	    JPanel nordPnl=new JPanel(new GridLayout(1,3));
        JPanel centroPnl=new JPanel(new GridLayout(3,4));
        JPanel sudPnl=new JPanel();
	
        JLabel vuoto00 = new JLabel ("");
        JLabel titolo = new JLabel ("                                                       DECIDI L'AREA DA GESTIRE");
        JLabel vuoto000 = new JLabel ("");
        
        JPanel vuoto0 = new JPanel ();
        JPanel vuoto1 = new JPanel ();
        JPanel vuoto2 = new JPanel ();
        JPanel vuoto3 = new JPanel ();
        JPanel vuoto4 = new JPanel ();
		JButton corsi = new JButton("AREA CORSI");
		JButton eventi = new JButton("AREA EVENTI");
		JPanel vuoto7 = new JPanel ();
		JPanel vuoto8 = new JPanel ();
		JPanel vuoto9 = new JPanel ();
		JPanel vuoto10 = new JPanel ();
		JPanel vuoto11 = new JPanel ();
		
		JButton indietro= new JButton("INDIETRO");
		
		
		
		public IstruttoreInizio(){
			super("Area privata ISTRUTTORE");
			
			
			nordPnl.add(vuoto00);
			nordPnl.add(titolo);
			nordPnl.add(vuoto000);
			
			
			centroPnl.add(vuoto0);
			centroPnl.add(vuoto1);
			centroPnl.add(vuoto2);
			centroPnl.add(vuoto3);
			centroPnl.add(vuoto4);
			corsi.addActionListener(new AscoltatoreCorsi(this));
			centroPnl.add(corsi);
			eventi.addActionListener(new AscoltatoreEventi(this));
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
			
			
			this.setSize(1500, 750);
			Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();  // prende la dimensione(risoluzione) dello schermo
			this.setLocation((int)((dim.getWidth()-this.getWidth())/2),(int)((dim.getHeight()-this.getHeight())/2));
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			
		}
		

	}
