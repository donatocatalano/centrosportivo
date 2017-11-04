package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreConfermaIstruttore;
import it.unisalento.pps.model.Responsabile;

public class FormIstruttore extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Font myfont = new Font("sansserif",Font.PLAIN,20);  
	Dimension mysize = new Dimension (200,30);
	
	JPanel nordPnl=new JPanel(new GridLayout (2,1));
	JPanel centroPnl=new JPanel(new GridLayout (2,2));
	JPanel sudPnl=new JPanel();
	
	
	JPanel paginareg= new JPanel();
	JLabel compilaform= new JLabel("INSERISCI I DATI RICHIESTI");
	JPanel vuoto= new JPanel();
	
	
	JPanel name= new JPanel(new FlowLayout());
	JLabel nome= new JLabel("NOME");
	public JTextField nome_field= new JTextField(15);
	
	public JPanel surname= new JPanel(new FlowLayout());
	public JLabel cognome= new JLabel("COGNOME");
	public JTextField cognome_field= new JTextField(15);
	
	JPanel username= new JPanel(new FlowLayout());
	JLabel user= new JLabel("USERNAME");
	public JTextField user_field= new JTextField(15);
	
	JPanel password= new JPanel(new FlowLayout());
	JLabel pass= new JLabel("PASSWORD");
	public JPasswordField pass_field= new JPasswordField(15);

	
	JButton indietro= new JButton("INDIETRO");
	JButton registrazione= new JButton("CONFERMA DATI INSERITI");
	
	
	public FormIstruttore (Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+responsabile.getNome()+" "+responsabile.getCognome());
		
		compilaform.setFont(new Font("sansserif",Font.BOLD,34));
		compilaform.setHorizontalAlignment(JLabel.CENTER);
		paginareg.add(compilaform);
		paginareg.add(vuoto);
		nordPnl.add(paginareg);
		
		
		name.add(nome);
		name.add(nome_field);
		nome.setFont(new Font("sansserif",Font.BOLD,25));
		nome_field.setPreferredSize(mysize);
		nome_field.setFont(myfont);
		nome_field.requestFocusInWindow();
		centroPnl.add(name);
		
		surname.add(cognome);
		surname.add(cognome_field);
		cognome.setFont(new Font("sansserif",Font.BOLD,25));
		cognome_field.setPreferredSize(mysize);
		cognome_field.setFont(myfont);
		centroPnl.add(surname);
		
		username.add(user);
		username.add(user_field);
		user.setFont(new Font("sansserif",Font.BOLD,25));
		user_field.setPreferredSize(mysize);
		user_field.setFont(myfont);
		centroPnl.add(username);
		
		password.add(pass);
		password.add(pass_field);
		pass.setFont(new Font("sansserif",Font.BOLD,25));
		pass_field.setPreferredSize(mysize);
		pass_field.setFont(myfont);
		centroPnl.add(password);


		indietro.addActionListener(new AscoltatoreBackResp(this, responsabile));
		registrazione.addActionListener(new AscoltatoreConfermaIstruttore(this, responsabile));
		sudPnl.add(indietro);
		sudPnl.add(registrazione);
		
		
		
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