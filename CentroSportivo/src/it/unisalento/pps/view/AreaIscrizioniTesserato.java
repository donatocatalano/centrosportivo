package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Utente;

public class AreaIscrizioniTesserato extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JScrollPane centroPnl=new JScrollPane();
	JPanel estPnl=new JPanel(new GridLayout(2,1));
	JPanel sudPnl=new JPanel();
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel scelta = new JLabel("SCEGLI DISCIPLINE, LIVELLI, TURNO E METODO DI PAGAMENTO");
	
	
	public JPanel pagamento = new JPanel(new FlowLayout());
	JLabel selPagamento = new JLabel("<html><p align=\"center\"><b>SELEZIONA METODO</b><br>DI PAGAMENTO</p></html>");
	public JRadioButton carta = new JRadioButton();
	public JRadioButton paypal = new JRadioButton();
	public JRadioButton contanti = new JRadioButton();
	ButtonGroup group = new ButtonGroup();
	
	JButton indietro = new JButton("INDIETRO");
	JButton iscrizione = new JButton("INVIA ISCRIZIONE");

	
	
	AscoltatoreBackHome ascoltatoreBackHome; 
	Utente tesserato;
	
	public AreaIscrizioniTesserato(Utente tesserato) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		
		
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		nordPnl.add(titolo);
		
		selPagamento.setFont(new Font("sansserif",Font.BOLD,22));
		estPnl.add(selPagamento);
		carta.setText("Carta di credito");
		paypal.setText("Paypal");
		contanti.setText("Contanti");
		group.add(carta);
		group.add(paypal);
		group.add(contanti);
		carta.setFont(new Font("sansserif",Font.BOLD,18));
		paypal.setFont(new Font("sansserif",Font.BOLD,18));
		contanti.setFont(new Font("sansserif",Font.BOLD,18));
		pagamento.add(carta);
		pagamento.add(paypal);
		pagamento.add(contanti);
		estPnl.add(pagamento);
		
		
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);
		sudPnl.add(indietro);
		sudPnl.add(iscrizione);
		
		
		
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		this.getContentPane().add(centroPnl,BorderLayout.CENTER);
		this.getContentPane().add(estPnl,BorderLayout.EAST);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
	
	
	
		int height=Toolkit.getDefaultToolkit().getScreenSize().getSize().height;  // prende la dimensione(risoluzione) dello schermo
		int width=Toolkit.getDefaultToolkit().getScreenSize().getSize().width;  // prende la dimensione(risoluzione) dello schermo
		this.setSize(width, height);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}


