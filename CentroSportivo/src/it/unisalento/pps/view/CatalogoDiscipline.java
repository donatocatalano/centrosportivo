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

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreNuovaDisciplina;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;

public class CatalogoDiscipline extends JFrame {
	
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	JButton modifica = new JButton ("MODIFICA");

	JButton indietro= new JButton("INDIETRO");
	JButton nuovadisciplina = new JButton("AGGIUNGI DISCIPLINA");
	
	AscoltatoreBackResp ascoltatoreBackResp; 
	AscoltatoreNuovaDisciplina ascoltatoreNuovaDisciplina;
	Responsabile responsabile;
	Disciplina disciplina;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();

	public CatalogoDiscipline(Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());
		
		titolo.setText("CATALOGO DISCIPLINE"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		
		discipline = DisciplinaBusiness.getInstance().getDiscipline();
		centroPnl.setLayout(new GridLayout(3*discipline.size(),1));
		
		if(discipline.size()>0) {
			for(int i=0;i<discipline.size();i++) {
				JLabel IdDisciplina = new JLabel(discipline.get(i).getNome()+"     COSTO MENSILE: "+discipline.get(i).getCostoMensile()+"0      DESCRIZIONE: "+discipline.get(i).getDescrizione());	
				IdDisciplina.setFont(new Font("sansserif",Font.BOLD,20));
				contenuto.add(IdDisciplina);
				ascoltatoreNuovaDisciplina = new AscoltatoreNuovaDisciplina(this, responsabile);
				modifica.addActionListener(ascoltatoreNuovaDisciplina);
				modifica.setActionCommand(AscoltatoreBackHome.D1);
				JButton modifica = new JButton ("MODIFICA");
				JButton elimina = new JButton ("ELIMINA");
				contenuto.add(modifica);
				contenuto.add(elimina);
				centroPnl.add(contenuto);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessuna Disciplina nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenuto.add(nessunaoccorrenza);
			centroPnl.add(contenuto);		
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