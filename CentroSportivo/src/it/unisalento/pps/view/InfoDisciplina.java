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

public class InfoDisciplina extends JFrame{
	

	private JPanel nordPnl=new JPanel();
	private JPanel centroPnl=new JPanel();
	private JPanel sudPnl=new JPanel();
	
	

	private JPanel titolo= new JPanel(new FlowLayout());
	
	private JPanel sup = new JPanel(new GridLayout(2,1));
	private JPanel inf = new JPanel(new GridLayout(2,1));
	private JLabel nomeDisciplina= new JLabel();
	private JLabel costoMensile= new JLabel();
	private JLabel descrizioneDisciplina= new JLabel();
	private ImageIcon immagine;
	private JLabel immagineDisciplina= new JLabel();

		
	private JButton indietro= new JButton("INDIETRO");
	private JButton vedifeed= new JButton("VEDI FEEDBACK");
	
	 
	AscoltatoreVediFeed ascoltatoreVedifeed;
	
	public InfoDisciplina(Disciplina disciplina) {
		super(disciplina.getNome());
		
		
		nomeDisciplina.setText(disciplina.getNome());
		nomeDisciplina.setFont(new Font("sansserif",Font.BOLD,34));
		titolo.add(nomeDisciplina);
		nordPnl.add(titolo);
		

		descrizioneDisciplina.setText(" DESCRIZIONE : "+disciplina.getDescrizione());
		descrizioneDisciplina.setFont(new Font("sansserif",Font.BOLD,20));
		sup.add(descrizioneDisciplina);
		
		costoMensile.setText(" COSTO MENSILE "+disciplina.getCostoMensile()+ "0 €");
		costoMensile.setFont(new Font("sansserif",Font.BOLD,20));
		sup.add(costoMensile);
		
		immagine = new ImageIcon("./img/"+disciplina.getImmagine());
		immagineDisciplina.setIcon(immagine);
		inf.add(immagineDisciplina);
		centroPnl.add(sup);
		centroPnl.add(inf);
		
		
		indietro.addActionListener(new AscoltatoreBackHome(this));
		ascoltatoreVedifeed= new AscoltatoreVediFeed (this, disciplina);
		vedifeed.addActionListener(ascoltatoreVedifeed);
		sudPnl.add(indietro);
		sudPnl.add(vedifeed);
		
		
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

