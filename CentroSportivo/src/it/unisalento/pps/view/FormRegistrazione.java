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

import it.unisalento.pps.listener.AscoltatoreBackHome;

public class FormRegistrazione extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new GridLayout (6,0));
	JPanel sudPnl=new JPanel();
	
	
	JPanel paginareg= new JPanel(new FlowLayout());
	JLabel compilaform= new JLabel("Inserisci i dati richiesti");
	
	
	JPanel name= new JPanel(new FlowLayout());
	JLabel nome= new JLabel("NOME");
	JTextField nome_field= new JTextField("                 ");
	
	
	JPanel surname= new JPanel(new FlowLayout());
	JLabel cognome= new JLabel("COGNOME");
	JTextField cognome_field= new JTextField("                 ");
			
	
	JPanel sex= new JPanel(new FlowLayout());
	JLabel sesso= new JLabel("SESSO");
	JLabel maschio= new JLabel("M");
	JCheckBox m= new JCheckBox();
	JLabel femmina= new JLabel("F");
	JCheckBox f= new JCheckBox();
	
	
	
	JPanel date= new JPanel(new FlowLayout());
	JLabel data= new JLabel("DATA (nel formato aaaa/mm/gg)");
	JTextField data_field= new JTextField("                 ");
	
	
	JPanel username= new JPanel(new FlowLayout());
	JLabel user= new JLabel("USERNAME");
	JTextField user_field= new JTextField("                 ");
	
	
	JPanel password= new JPanel(new FlowLayout());
	JLabel pass= new JLabel("PASSWORD");
	JTextField pass_field= new JTextField("                 ");

	
	JButton indietro= new JButton("INDIETRO");
	JButton registrazione= new JButton("CONFERMA DATI INSERITI");
	
	
	public FormRegistrazione() {
		super("Pagina di Registrazione");
		
		
		nordPnl.add(paginareg);
		nordPnl.add(compilaform);
		
		centroPnl.add(name);
		name.add(nome);
		name.add(nome_field);
		name.setBounds(10, 50, 100,100);
		
		centroPnl.add(surname);
		surname.add(cognome);
		surname.add(cognome_field);
		surname.setBounds(10, 50, 100,100);
		
		centroPnl.add(sex);
		sex.add(sesso);
		sex.add(maschio);
		sex.add(m);
		sex.add(femmina);
		sex.add(f);
		
		centroPnl.add(date);
		date.add(data);
		date.add(data_field);
		date.setBounds(10, 50, 100,100);
		
		centroPnl.add(username);
		username.add(user);
		username.add(user_field);
		username.setBounds(10, 50, 100,100);
		
		centroPnl.add(password);
		password.add(pass);
		password.add(pass_field);
		password.setBounds(10, 50, 100,100);
		
		

		indietro.addActionListener(new AscoltatoreBackHome(this));
		sudPnl.add(indietro);
		sudPnl.add(registrazione);
		
		
		
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