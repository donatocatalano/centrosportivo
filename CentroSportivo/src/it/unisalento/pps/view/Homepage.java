package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
import it.unisalento.pps.listener.AscoltatoreReg;
import it.unisalento.pps.listener.LoginBtnListener;

public class Homepage extends JFrame {
	
	JPanel nordPnl=new JPanel(new GridLayout(2,2));
	JPanel centroPnl=new JPanel(new GridLayout(3,2));
	JPanel sudPnl=new JPanel();
	
	
	JPanel titolo= new JPanel();
	JLabel centrosportivo= new JLabel("CENTRO SPORTIVO");
	
	
	JPanel norddestra= new JPanel(new GridLayout(2,2));	
	
	JPanel vuoto1 = new JPanel();
	JPanel login= new JPanel(new GridLayout(3,2));	
	JLabel user = new JLabel("            Inserisci username");
	public JTextField username = new JTextField();
    JLabel psw = new JLabel("             Inserisci password");
    public JPasswordField password = new JPasswordField();
	JButton loginBtn = new JButton("Effettua login");
	JButton registrazione = new JButton("Effettua registrazione");
	JPanel vuoto3 =new JPanel();
	JPanel vuoto4 =new JPanel();
	
	JPanel descrizione = new JPanel ();
	JLabel info = new JLabel ("<html><p align=\\\"center\\\"><b>L’attività fisica è alla base della Salute e del Benessere Psicofisico, per questo noi di Pinco Pallino,</b><br>che ci occupiamo del benessere e della salute delle persone a 360°, </b><br>mettiamo a disposizione dei nostri clienti una moderna Area Fitness attrezzata per l’allenamento individuale.</p></html>");
	JPanel apertura = new JPanel();
	JLabel orari = new JLabel ("<html><p align=\"center\"><b>ORARI DI APERTURA:</b><br>Lun - Ven: dalle 9.00 alle 22.00</b><br>Sab: dalle 14.30 alle 18.30</p></html>");
	
	
	JButton disciplina1= new JButton("Fitness");
	JButton disciplina2= new JButton("Pesistica");
	JButton disciplina3= new JButton("Nuoto");
	JButton disciplina4= new JButton("Ginnastica Artistica");
	JButton disciplina5= new JButton("Ginnastica Ritmica");
	JButton disciplina6= new JButton("In lavorazione");
	
	JLabel informazioni= new JLabel("Centro Sportivo di Pinco Pallino - Via di Principi di Progettazione, 88 - 73100 Lecce");
	
	AscoltatoreDisciplina ascoltatoreDisciplina = new AscoltatoreDisciplina(this);
	
	public Homepage() {
		super("Catalogo Centro Sportivo");
		
		centrosportivo.setFont(new Font("sansserif",Font.BOLD,75));
		//titolo.setBackground( Color.RED );
		titolo.add(centrosportivo);
		nordPnl.add(titolo);		
		norddestra.add(vuoto1);
		login.add(user);
		login.add(username);
		login.add(psw);
		login.add(password);
		password.addKeyListener(new LoginBtnListener (this));
		login.add(loginBtn);
		loginBtn.addActionListener(new LoginBtnListener(this));
		loginBtn.addKeyListener(new LoginBtnListener (this));
		login.add(registrazione);
		registrazione.addActionListener(new AscoltatoreReg(this));
		//loginBtn.setOpaque( true );
		//loginBtn.setBackground( Color.BLUE );
		norddestra.add(login);
		norddestra.add(vuoto3);
		norddestra.add(vuoto4);
		nordPnl.add(norddestra);
		
		info.setFont(new Font("sansserif",Font.BOLD,22));
		descrizione.add(info);
		nordPnl.add(descrizione);
		orari.setForeground(Color.BLUE);
		orari.setFont(new Font("sansserif",Font.BOLD,22));
		apertura.add(orari);
		nordPnl.add(apertura);
		
		
		
		
		disciplina1.addActionListener(ascoltatoreDisciplina);
		//disciplina1.setActionCommand(AscoltatoreDisciplina.D1);
		disciplina1.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(disciplina1);
		disciplina2.addActionListener(ascoltatoreDisciplina);
		//disciplina2.setActionCommand(AscoltatoreDisciplina.D2);
		disciplina2.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(disciplina2);
		disciplina3.addActionListener(ascoltatoreDisciplina);
		//disciplina3.setActionCommand(AscoltatoreDisciplina.D3);
		disciplina3.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(disciplina3);
		disciplina4.addActionListener(ascoltatoreDisciplina);
		//disciplina4.setActionCommand(AscoltatoreDisciplina.D4);
		disciplina4.setFont(new Font("sansserif",Font.BOLD,34));
		centroPnl.add(disciplina4);
		disciplina5.addActionListener(ascoltatoreDisciplina);
		//disciplina5.setActionCommand(AscoltatoreDisciplina.D5);
		disciplina5.setFont(new Font("sansserif",Font.BOLD,34));
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