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
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreNuovaDisciplina;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Testimonianza;

public class CatalogoDiscipline extends JFrame {
	
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	JLabel titolo = new JLabel();


	JButton indietro= new JButton("INDIETRO");
	JButton nuovadisciplina = new JButton("AGGIUNGI DISCIPLINA");
	
	AscoltatoreBackResp ascoltatoreBackResp; 
	AscoltatoreNuovaDisciplina ascoltatoreNuovaDisciplina;
	Responsabile responsabile;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();

	public CatalogoDiscipline(Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());
		
		titolo.setText("CATALOGO DISCIPLINE"); 
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		
		discipline = DisciplinaBusiness.getInstance().getDiscipline();
		centroPnl.setLayout(new GridLayout(discipline.size(),1));
		
		if(discipline.size()>0) {
			for(int i=0;i<discipline.size();i++) {
			JLabel IdDisciplina = new JLabel(discipline.get(i).getNome()+"     COSTO MENSILE: "+discipline.get(i).getCostoMensile()+"0      DESCRIZIONE: "+discipline.get(i).getDescrizione());	
			IdDisciplina.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(IdDisciplina);
			
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessuna Disciplina nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			centroPnl.add(nessunaoccorrenza);		
		}			
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		sudPnl.add(indietro);
		ascoltatoreNuovaDisciplina = new AscoltatoreNuovaDisciplina(this, responsabile);
		nuovadisciplina.addActionListener(ascoltatoreNuovaDisciplina);
		sudPnl.add(nuovadisciplina);
		
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