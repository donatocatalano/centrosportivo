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
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreFeedback;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Testimonianza;
import it.unisalento.pps.model.Utente;


public class FeedbackTesserato extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel nordPnl=new JPanel(new GridLayout(2,1));
	private JPanel centroPnl=new JPanel();
	private JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JPanel spazio = new JPanel();
	
	JPanel contenuto = new JPanel();
	
	JButton indietro= new JButton("TORNA ALL'HOMEPAGE");
	JButton feedback = new JButton("LASCIA FEEDBACK");
	
	
	AscoltatoreBackHome ascoltatoreBackHome; 
	AscoltatoreFeedback ascoltatoreFeedback;
	Disciplina disciplina;
	Utente tesserato;
	ArrayList<Testimonianza> testimonianze = new ArrayList<Testimonianza>();
	
	public FeedbackTesserato (Disciplina disciplina, Utente tesserato) {
		super("Feedback " + disciplina.getNome());
		
		
		titolo.setText("TESTIMONIANZE: " +disciplina.getNome()); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		
		testimonianze = TestimonianzaBusiness.getInstance().getTestimonianzeByIdDisciplina(disciplina.getIdDisciplina());
		contenuto.setLayout(new GridLayout(3*testimonianze.size(),1));
		Utente utente;
		
		if(testimonianze.size()>0) {			
			for(int i=0;i<testimonianze.size();i++) {
				utente = UtenteBusiness.getInstance().getUtenteById(testimonianze.get(i).getUtente());
				
				String giorno= testimonianze.get(i).getData().toString().substring(8,10);
				String mese = testimonianze.get(i).getData().toString().substring(5,7);
				String anno =testimonianze.get(i).getData().toString().substring(0,4);	
				
				
				
				JLabel testo = new JLabel((i+1)+")  FEEDBACK del   " +giorno+ ":"+mese+ ":" +anno+" , "+ utente.getNome()+" " + utente.getCognome()+ ":   " +testimonianze.get(i).getContenuto());		
				testo.setFont(new Font("sansserif",Font.BOLD,20));
				JLabel vuoto1 = new JLabel();
				JLabel vuoto2 = new JLabel();
				contenuto.add(vuoto1);
				contenuto.add(testo);
				contenuto.add(vuoto2);
				centroPnl.add(contenuto);		
			}
		}
		else {
			JLabel contenuto = new JLabel("Nessuna Testimonianza");	
			contenuto.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(contenuto);		
		}
		
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);	
		sudPnl.add(indietro);
		ascoltatoreFeedback = new AscoltatoreFeedback(this, disciplina,tesserato);
		feedback.addActionListener(ascoltatoreFeedback);
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
