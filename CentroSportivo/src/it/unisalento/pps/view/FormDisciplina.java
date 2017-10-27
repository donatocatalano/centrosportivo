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

import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreConfermaCorso;
import it.unisalento.pps.listener.AscoltatoreConfermaDisciplina;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Responsabile;

public class FormDisciplina extends JFrame {
	
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
	
	JPanel cost= new JPanel(new FlowLayout());
	JLabel costo= new JLabel("COSTO MENSILE");
	public JTextField costo_field= new JTextField(15);
	
	JPanel period= new JPanel(new FlowLayout());
	JLabel descrizione= new JLabel("BREVE DESCRIZIONE");
	public JTextField descrizione_field= new JTextField(15);
		
	JPanel image= new JPanel(new FlowLayout());
	JLabel immagine= new JLabel("CARICA IMMAGINE DA COMPLETARE");
	
	JPanel appartenenza = new JPanel(new FlowLayout());
	JLabel disciplina = new JLabel("");
	
	JPanel dateend= new JPanel(new FlowLayout());
	JLabel datafine= new JLabel("");
	
	
	
	JButton indietro= new JButton("INDIETRO");
	JButton inserimento= new JButton("CONFERMA DATI INSERITI");
	
	
	public FormDisciplina(Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+responsabile.getNome()+" "+responsabile.getCognome());
		
		compilaform.setFont(new Font("sansserif",Font.BOLD,34));
		compilaform.setHorizontalAlignment(JLabel.CENTER);
		paginareg.add(compilaform);
		paginareg.add(vuoto);
		nordPnl.add(paginareg);
		
		
		name.add(nome);
		nome.setFont(new Font("sansserif",Font.BOLD,25));
		name.add(nome_field);
		nome_field.setFont(myfont);
		nome_field.setPreferredSize(mysize);
		centroPnl.add(name);
		cost.add(costo);
		costo.setFont(new Font("sansserif",Font.BOLD,25));
		cost.add(costo_field);
		costo_field.setFont(myfont);
		costo_field.setPreferredSize(mysize);
		centroPnl.add(cost);
		period.add(descrizione);
		descrizione.setFont(new Font("sansserif",Font.BOLD,25));
		period.add(descrizione_field);
		descrizione_field.setFont(myfont);
		descrizione_field.setPreferredSize(mysize);
		centroPnl.add(period);
		image.add(immagine);
		immagine.setFont(new Font("sansserif",Font.BOLD,25));
		centroPnl.add(image);
		appartenenza.add(disciplina);
		disciplina.setFont(new Font("sansserif",Font.BOLD,25));
		centroPnl.add(appartenenza);
		dateend.add(datafine);
		datafine.setFont(new Font("sansserif",Font.BOLD,25));
		centroPnl.add(dateend);


		indietro.addActionListener(new AscoltatoreBackResp(this, responsabile));
		inserimento.addActionListener(new AscoltatoreConfermaDisciplina(this, responsabile));
		sudPnl.add(indietro);
		sudPnl.add(inserimento);
		
		
		
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