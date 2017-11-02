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
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel nomeDisciplina = new JLabel();
	
	private JPanel sup = new JPanel(new GridLayout(3,1));
	private JPanel inf = new JPanel(new GridLayout(2,1));
	private JLabel descrizioneDisciplina= new JLabel();
	private JLabel spazio = new JLabel();
	private JLabel costoMensile= new JLabel();
	private ImageIcon immagine;
	private JLabel immagineDisciplina= new JLabel();
	
	private JButton indietro= new JButton("INDIETRO");
	private JButton feedback = new JButton("VEDI FEEDBACK");
	
	
	AscoltatoreBackHome ascoltatoreBackHome; 
	AscoltatoreVediFeed ascoltatoreVediFeed;
	Utente tesserato;
	
	public InfoDisciplinaTesserato(Disciplina disciplina,Utente tesserato) {
		super(disciplina.getNome());
		
		nomeDisciplina.setText(disciplina.getNome());
		nomeDisciplina.setFont(new Font("sansserif",Font.BOLD,34));
		titolo.add(nomeDisciplina);
		nordPnl.add(titolo);
		
		
		descrizioneDisciplina.setText(" DESCRIZIONE: "+disciplina.getDescrizione() );
		descrizioneDisciplina.setFont(new Font("sansserif",Font.BOLD,20));
		sup.add(descrizioneDisciplina);
		
		sup.add(spazio);
		
		costoMensile.setText(" COSTO MENSILE "+disciplina.getCostoMensile()+ "0 €");
		costoMensile.setFont(new Font("sansserif",Font.BOLD,20));
		costoMensile.setHorizontalAlignment(JLabel.CENTER);
		sup.add(costoMensile);
		
		immagine = new ImageIcon("./img/"+disciplina.getImmagine());
		immagineDisciplina.setIcon(immagine);
		inf.add(immagineDisciplina);
		centroPnl.add(sup);
		centroPnl.add(inf);
		
		
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

