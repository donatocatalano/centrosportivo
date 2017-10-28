package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreNuovoEvento;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;

public class ElencoEventi extends JFrame {
	
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	
	JButton indietro = new JButton("INDIETRO");
	JButton nuovoevento = new JButton("AGGIUNGI EVENTO");

	AscoltatoreBackIst ascoltatoreBackIst; 
	AscoltatoreNuovoEvento ascoltatoreNuovoEvento;
	Istruttore istruttore;
	ArrayList<Evento> eventi = new ArrayList<Evento>();

	public ElencoEventi(Istruttore istruttore) {
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
		
		titolo.setText("ELENO EVENTI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		eventi = EventoBusiness.getInstance().getEventiByIdIstruttore(istruttore.getIdIstruttore());
		Disciplina disciplina;
		Spazio spazio;
		//Livello livello;
		TipoEvento tipo;
		
		for(int i=0;i<eventi.size();i++) {
			disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(eventi.get(i).getDisciplina());
			spazio = SpazioBusiness.getInstance().getSpazioById(eventi.get(i).getSpazio());
			tipo = TipoEventoBusiness.getInstance().getEventoById(eventi.get(i).getTipo());
			
			JLabel evento = new JLabel(tipo.getTipo()+" di " +disciplina.getNome()+ ": INIZIA IL:  " +eventi.get(i).getDataInizio()+ "   ORARI:  " +eventi.get(i).getTurno()+ "   TERMINA IL:  " +eventi.get(i).getDataFine()+"  LUOGO:  "+spazio.getNome());
			evento.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(evento);
			//disciplina.addActionListener(ascoltatoreDisciplina);
				}
		
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
		sudPnl.add(indietro);
		ascoltatoreNuovoEvento = new AscoltatoreNuovoEvento (this, istruttore);
		nuovoevento.addActionListener(ascoltatoreNuovoEvento);
		sudPnl.add(nuovoevento);
		
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