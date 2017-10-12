package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.listener.AscoltatoreDisciplina;
import it.unisalento.pps.listener.AscoltatoreDisciplinaTesserato;
import it.unisalento.pps.listener.AscoltatoreReg;
import it.unisalento.pps.listener.LoginBtnListener;

public class HomepageTesserato extends JFrame {
	
	JPanel nordPnl=new JPanel(new GridLayout(1,2));
	JPanel centroPnl=new JPanel(new GridLayout(3,2));
	JPanel sudPnl=new JPanel();
	
	
	JPanel titolo= new JPanel();
	JLabel centrosportivo= new JLabel("CENTRO SPORTIVO");
	
	
	JPanel norddestra= new JPanel(new GridLayout(2,2));	
	JPanel vuoto1 = new JPanel();
	JPanel login= new JPanel(new GridLayout(3,2));	
	JLabel nomeutente = new JLabel("nomeutente");
	JPanel vuoto3 =new JPanel();
	JPanel vuoto4 =new JPanel();
	
	
	JButton disciplina1= new JButton("Fitness");
	JButton disciplina2= new JButton("Pesistica");
	JButton disciplina3= new JButton("Nuoto");
	JButton disciplina4= new JButton("Ginnastica Artistica");
	JButton disciplina5= new JButton("Ginnastica Ritmica");
	JButton disciplina6= new JButton("In lavorazione");
	
	JLabel informazioni= new JLabel("Centro Sportivo di Pinco Pallino - Via di Principi di Progettazione, 88 - 73100 Lecce");
	
	AscoltatoreDisciplinaTesserato ascoltatoreDisciplina = new AscoltatoreDisciplinaTesserato(this);
	
	public HomepageTesserato() {
		super("Catalogo Centro Sportivo");
		
		
		titolo.add(centrosportivo);
		nordPnl.add(titolo);		
		norddestra.add(vuoto1);
		login.add(nomeutente);
		norddestra.add(login);
		norddestra.add(vuoto3);
		norddestra.add(vuoto4);
		nordPnl.add(norddestra);
		
		
		disciplina1.addActionListener(ascoltatoreDisciplina);
		disciplina1.setActionCommand(AscoltatoreDisciplina.D1);
		centroPnl.add(disciplina1);
		disciplina2.addActionListener(ascoltatoreDisciplina);
		disciplina2.setActionCommand(AscoltatoreDisciplina.D2);
		centroPnl.add(disciplina2);
		disciplina3.addActionListener(ascoltatoreDisciplina);
		disciplina3.setActionCommand(AscoltatoreDisciplina.D3);
		centroPnl.add(disciplina3);
		disciplina4.addActionListener(ascoltatoreDisciplina);
		disciplina4.setActionCommand(AscoltatoreDisciplina.D4);
		centroPnl.add(disciplina4);
		disciplina5.addActionListener(ascoltatoreDisciplina);
		disciplina5.setActionCommand(AscoltatoreDisciplina.D5);
		centroPnl.add(disciplina5);
		centroPnl.add(disciplina6);
		
		
		sudPnl.add(informazioni);
		
		
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

	public int getKeyCode() {		
		return 0;
	}
	
}