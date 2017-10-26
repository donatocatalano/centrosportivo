package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.business.TestimonianzaBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreFeedback;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Testimonianza;


public class Feedback extends JFrame{
	
	private JPanel nordPnl=new JPanel();
	private JPanel centroPnl=new JPanel(new GridLayout(4,1));
	private JPanel sudPnl=new JPanel();
	
	private JLabel testimonianza= new JLabel();
	
	
	private JButton indietro= new JButton("TORNA ALL'HOMEPAGE");
	
	
	//private AscoltatoreBackHome ascoltatoreBackHome; 
	//private AscoltatoreFeedback ascoltatoreFeedback;
	//private Disciplina disciplina;
	ArrayList<Testimonianza> testimonianze = new ArrayList<Testimonianza>();
	
	public Feedback (Disciplina disciplina) {
		super("Feedback " + disciplina.getNome());
		
		testimonianze = TestimonianzaBusiness.getInstance().getTestimonianzeByIdDisciplina(disciplina.getIdDisciplina());
		centroPnl.setLayout(new GridLayout(testimonianze.size(),1));
		if(testimonianze.size()>0) {
		for(int i=0;i<testimonianze.size();i++) {
			JLabel contenuto = new JLabel(testimonianze.get(i).getContenuto());			  
			centroPnl.add(contenuto);		
				}
			}
		else {
			JLabel contenuto = new JLabel("Nessuna Testimonianza");			  
			centroPnl.add(contenuto);		
		}
		testimonianza.setText(" TESTIMONIANZE : "); // inserire collegamento a database
		testimonianza.setFont(new Font("sansserif",Font.BOLD,20));
		nordPnl.add(testimonianza);
		
		
		indietro.addActionListener(new AscoltatoreBackHome(this));
		sudPnl.add(indietro);
		
		
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

