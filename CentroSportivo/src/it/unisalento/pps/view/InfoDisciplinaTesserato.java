package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreVediFeed;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;

public class InfoDisciplinaTesserato extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new GridLayout(4,1));
	JPanel sudPnl=new JPanel();
	
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel nomeDisciplina = new JLabel();
	
	JLabel descrizioneDisciplina= new JLabel();
	JLabel costoMensile= new JLabel();
	ImageIcon immagine;
	JLabel immagineDisciplina = new JLabel();
	JLabel testimonianza = new JLabel();
	
	JButton indietro= new JButton("INDIETRO");
	JButton feedback = new JButton("VEDI FEEDBACK");
	
	
	AscoltatoreBackHome ascoltatoreBackHome; 
	AscoltatoreVediFeed ascoltatoreVediFeed;
	Utente tesserato;
	
	public InfoDisciplinaTesserato(Disciplina disciplina,Utente tesserato) {
		super(disciplina.getNome());
		
		nomeDisciplina.setText(disciplina.getNome());
		nomeDisciplina.setFont(new Font("sansserif",Font.BOLD,34));
		titolo.add(nomeDisciplina);
		nordPnl.add(titolo);
		
		
		descrizioneDisciplina.setText(" DESCRIZIONE : "+disciplina.getDescrizione() );
		descrizioneDisciplina.setFont(new Font("sansserif",Font.BOLD,20));
		centroPnl.add(descrizioneDisciplina);
		
		costoMensile.setText(" COSTO MENSILE "+disciplina.getCostoMensile()+ "0 €");
		costoMensile.setFont(new Font("sansserif",Font.BOLD,20));
		centroPnl.add(costoMensile);
		
		immagine = new ImageIcon("./img/"+disciplina.getImmagine());
		immagineDisciplina.setIcon(immagine);
		centroPnl.add(immagineDisciplina);
		
		testimonianza.setText(" TESTIMONIANZA : "+disciplina.getDescrizione() );
		testimonianza.setFont(new Font("sansserif",Font.BOLD,20));
		centroPnl.add(testimonianza);
		
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);	
		sudPnl.add(indietro);
		ascoltatoreVediFeed = new AscoltatoreVediFeed(this, disciplina,tesserato);
		feedback.setActionCommand(AscoltatoreVediFeed.D1);
		feedback.addActionListener(ascoltatoreVediFeed);
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

