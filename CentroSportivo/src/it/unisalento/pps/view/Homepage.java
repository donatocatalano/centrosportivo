package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.listener.AscoltatoreDisciplina;
import it.unisalento.pps.listener.AscoltatoreReg;
import it.unisalento.pps.listener.AscoltatoreLogin;
import it.unisalento.pps.model.Disciplina;

public class Homepage extends JFrame {
	
	JPanel nordPnl=new JPanel(new GridLayout(2,2));
	JPanel centroPnl=new JPanel(new GridLayout(3,2));
	JPanel sudPnl=new JPanel();
	
	
	JPanel titolo = new JPanel();
	JLabel centrosportivo = new JLabel("CENTRO SPORTIVO");
	
	
	JPanel norddestra = new JPanel(new GridLayout(2,2));	
	
	JPanel vuoto1 = new JPanel();
	JPanel login= new JPanel(new GridLayout(3,2));	
	JLabel user = new JLabel("             Inserisci username");
	public JTextField username = new JTextField();
    JLabel psw = new JLabel("             Inserisci password");
    public JPasswordField password = new JPasswordField();
	JButton loginBtn = new JButton("Effettua login");
	JButton registrazione = new JButton("Effettua registrazione");
	JPanel vuoto3 =new JPanel();
	JPanel vuoto4 =new JPanel();
	
	JPanel descrizione = new JPanel ();
	String testoInfo="<html><p align=\"justify\" style=\"padding-left: 1cm\" ><b>L’attività fisica è alla base della Salute e del Benessere Psicofisico, per questo noi di Pinco Pallino, che ci occupiamo del benessere e della salute delle persone a 360°, mettiamo a disposizione dei nostri clienti una moderna Area Fitness attrezzata per</b><br>l’allenamento individuale.</p></html>";
	JLabel info = new JLabel (testoInfo);
	JPanel apertura = new JPanel();
	JLabel orari = new JLabel ("<html><p align=\"center\"><b>ORARI DI APERTURA:</b><br>Lun - Ven: dalle 9.00 alle 22.00</b><br>Sab: dalle 9.00 alle 19.00</p></html>");
	
	
	JLabel informazioni= new JLabel("Centro Sportivo di Pinco Pallino - Via di Principi di Progettazione, 88 - 73100 Lecce");
	
	AscoltatoreDisciplina ascoltatoreDisciplina;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	
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
		password.addKeyListener(new AscoltatoreLogin (this));
		login.add(loginBtn);
		loginBtn.addActionListener(new AscoltatoreLogin(this));
		loginBtn.addKeyListener(new AscoltatoreLogin (this));
		login.add(registrazione);
		registrazione.addActionListener(new AscoltatoreReg(this));
		//loginBtn.setOpaque( true );
		//loginBtn.setBackground( Color.BLUE );
		norddestra.add(login);
		norddestra.add(vuoto3);
		norddestra.add(vuoto4);
		nordPnl.add(norddestra);
		
		info.setFont(new Font("sansserif",Font.BOLD,22));
		descrizione.setLayout(new BoxLayout(descrizione,BoxLayout.X_AXIS));
		descrizione.add(info);
		nordPnl.add(descrizione);
		orari.setForeground(Color.BLUE);
		orari.setFont(new Font("sansserif",Font.BOLD,22));
		apertura.add(orari);
		nordPnl.add(apertura);
		
		ascoltatoreDisciplina = new AscoltatoreDisciplina(this);
		discipline = DisciplinaBusiness.getInstance().getDiscipline();
		
		for(int i=0;i<discipline.size();i++) {
			JButton disciplina = new JButton(discipline.get(i).getNome());
			disciplina.setFont(new Font("sansserif",Font.BOLD,34));
			centroPnl.add(disciplina);
			disciplina.addActionListener(ascoltatoreDisciplina);
				}
		
		
	
		
		
		sudPnl.add(informazioni);
		
		
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

	public int getKeyCode() {
		return 0;
	}
}