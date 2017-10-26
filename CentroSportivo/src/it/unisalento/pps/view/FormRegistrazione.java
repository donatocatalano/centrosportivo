package it.unisalento.pps.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import it.unisalento.pps.listener.*;

public class FormRegistrazione extends JFrame {
	
	Font myfont = new Font("sansserif",Font.PLAIN,20);  
	Dimension mysize = new Dimension (200,30);
	
	JPanel nordPnl=new JPanel(new GridLayout (2,1));
	JPanel centroPnl=new JPanel(new GridLayout (3,3));
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
	public JPanel sex= new JPanel(new FlowLayout());
	public JLabel sesso= new JLabel("SESSO");
	public JRadioButton maschio= new JRadioButton();
	public JRadioButton femmina= new JRadioButton();

	ButtonGroup group = new ButtonGroup();
	
	
	JPanel date= new JPanel(new FlowLayout());
	JLabel data= new JLabel("DATA (nel formato aaaa/mm/gg)");

	public JTextField data_field= new JTextField(15);

	
	JPanel username= new JPanel(new FlowLayout());
	JLabel user= new JLabel("USERNAME");
	public JTextField user_field= new JTextField(15);
	
	JPanel password= new JPanel(new FlowLayout());
	JLabel pass= new JLabel("PASSWORD");


	public JPasswordField pass_field= new JPasswordField(15);
	
	JButton indietro= new JButton("INDIETRO");
	JButton registrazione= new JButton("CONFERMA DATI INSERITI");
	
	
	public FormRegistrazione() {
		super("Pagina di Registrazione");
		
		compilaform.setFont(new Font("sansserif",Font.BOLD,34));
		compilaform.setHorizontalAlignment(JLabel.CENTER);
		paginareg.add(compilaform);
		paginareg.add(vuoto);
		nordPnl.add(paginareg);
		
		
		name.add(nome);
		name.add(nome_field);
		nome.setFont(new Font("sansserif",Font.BOLD,25));
		//nome.setHorizontalAlignment(JLabel.CENTER);
		nome_field.setPreferredSize(mysize);
		nome_field.setFont(myfont);
		//nome_field.setHorizontalAlignment(JTextField.CENTER);
		nome_field.requestFocusInWindow();
		centroPnl.add(name);
		
		surname.add(cognome);
		surname.add(cognome_field);
		//surname.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		cognome.setFont(new Font("sansserif",Font.BOLD,25));
		cognome_field.setPreferredSize(mysize);
		cognome_field.setFont(myfont);
		centroPnl.add(surname);
		
		sex.add(sesso);
		maschio.setText("M");
		group.add(maschio);
		sex.add(maschio);
		femmina.setText("F");
		group.add(femmina);
		sex.add(femmina);
		//sex.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		sesso.setFont(new Font("sansserif",Font.BOLD,25));
		maschio.setFont(new Font("sansserif",Font.BOLD,25));
		femmina.setFont(new Font("sansserif",Font.BOLD,25));
		centroPnl.add(sex);
		
		date.add(data);
		date.add(data_field);
		data.setFont(new Font("sansserif",Font.BOLD,25));
		data_field.setPreferredSize(mysize);
		data_field.setFont(myfont);
		centroPnl.add(date);
		
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


		indietro.addActionListener(new AscoltatoreBackHome(this));
		registrazione.addActionListener(new AscoltatoreConfermaRegistrazione(this));
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