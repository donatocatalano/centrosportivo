package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.model.Disciplina;

public class InfoDisciplina extends JFrame{
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	JPanel titolo= new JPanel(new FlowLayout());
	JLabel nomeDisciplina= new JLabel();
	JLabel costoMensile= new JLabel();
	JLabel descrizioneDisciplina= new JLabel();
	JLabel immagineDisciplina= new JLabel();
	
	JButton indietro= new JButton("INDIETRO");
	
	
	public InfoDisciplina(Disciplina disciplina) {
		super(disciplina.getNome());
		
		
		nomeDisciplina.setText(disciplina.getNome());
		nomeDisciplina.setFont(new Font("sansserif",Font.BOLD,34));
		titolo.add(nomeDisciplina);
		nordPnl.add(titolo);
		
		costoMensile.setText(" COSTO MENSILE "+disciplina.getCostoMensile()+ "$");
		costoMensile.setFont(new Font("sansserif",Font.BOLD,20));
		centroPnl.add(costoMensile);
		
		
		indietro.addActionListener(new AscoltatoreBackHome(this));
		sudPnl.add(indietro);
		
		
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		this.getContentPane().add(centroPnl,BorderLayout.CENTER);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
	
	
	
		this.setSize(1500, 750);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();  // prende la dimensione(risoluzione) dello schermo
		this.setLocation((int)((dim.getWidth()-this.getWidth())/2),(int)((dim.getHeight()-this.getHeight())/2));
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}

