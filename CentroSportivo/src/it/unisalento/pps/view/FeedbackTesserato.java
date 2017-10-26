package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreFeedback;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;


public class FeedbackTesserato extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new GridLayout(4,1));
	JPanel sudPnl=new JPanel();
	
	private JLabel testimonianza= new JLabel();
	
	
	JButton indietro= new JButton("TORNA ALL'HOMEPAGE");
	JButton feedback = new JButton("LASCIA FEEDBACK");
	
	
	AscoltatoreBackHome ascoltatoreBackHome; 
	AscoltatoreFeedback ascoltatoreFeedback;
	Disciplina disciplina;
	Utente tesserato;
	
	public FeedbackTesserato (Disciplina disciplina, Utente tesserato) {
		super("Feedback " + disciplina.getNome());
		
		testimonianza.setText(" TESTIMONIANZE : ");//+disciplina.getDescrizione() );
		testimonianza.setFont(new Font("sansserif",Font.BOLD,20));
		nordPnl.add(testimonianza);
		
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);	
		sudPnl.add(indietro);
		ascoltatoreFeedback = new AscoltatoreFeedback(this, disciplina,tesserato);
		feedback.addActionListener(ascoltatoreFeedback);
		//feedback.setActionCommand(AscoltatoreFeedback.D1);
		sudPnl.add(feedback);
		
		
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
