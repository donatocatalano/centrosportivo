package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreLivelli;
import it.unisalento.pps.listener.AscoltatoreEliminaDisciplina;
import it.unisalento.pps.listener.AscoltatoreFormDisciplina;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;

public class CatalogoDiscipline extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	JPanel contenutoVuoto = new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	
	JButton modifica = new JButton ("MODIFICA");

	JButton indietro= new JButton("INDIETRO");
	JButton nuovadisciplina = new JButton("AGGIUNGI DISCIPLINA");
	JButton nuovolivello = new JButton("GESTISCI LIVELLI");
	
	AscoltatoreBackResp ascoltatoreBackResp; 
	AscoltatoreFormDisciplina ascoltatoreModDisciplina;
	AscoltatoreFormDisciplina ascoltatoreNuovaDisciplina;
	AscoltatoreEliminaDisciplina ascoltatoreElimina;
	Responsabile responsabile;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();

	public CatalogoDiscipline(Responsabile responsabile, Disciplina disciplina) {
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());
		
		titolo.setText("CATALOGO DISCIPLINE"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		
		
		discipline = DisciplinaBusiness.getInstance().getDiscipline();
		centroPnl.setLayout(new GridLayout(discipline.size(),1));
		
		if(discipline.size()>0) {
			for(int i=0;i<discipline.size();i++) {
				JLabel campo_disciplina = new JLabel(discipline.get(i).getNome()+"     COSTO MENSILE: "+discipline.get(i).getCostoMensile()+"0      DESCRIZIONE: "+discipline.get(i).getDescrizione()+"   ");	
				campo_disciplina.setFont(new Font("sansserif",Font.BOLD,20));
				JButton modifica = new JButton ("MODIFICA");
				JButton elimina = new JButton ("ELIMINA");
				JPanel contenuto = new JPanel(new FlowLayout());
				contenuto.setAlignmentX(LEFT_ALIGNMENT);
				contenuto.add(campo_disciplina);				
				contenuto.add(modifica);
				contenuto.add(elimina);
				centroPnl.add(contenuto);
				ascoltatoreModDisciplina = new AscoltatoreFormDisciplina(this, responsabile, discipline.get(i));
				modifica.addActionListener(ascoltatoreModDisciplina);
				modifica.setActionCommand(AscoltatoreFormDisciplina.D1);
				ascoltatoreElimina = new AscoltatoreEliminaDisciplina(this,responsabile,discipline.get(i));
				elimina.addActionListener(ascoltatoreElimina);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessuna Disciplina nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}			
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		indietro.setFont(new Font("sansserif",Font.BOLD,20));
		sudPnl.add(indietro);
		ascoltatoreNuovaDisciplina = new AscoltatoreFormDisciplina(this, responsabile, disciplina);
		nuovadisciplina.addActionListener(ascoltatoreNuovaDisciplina);
		nuovadisciplina.setFont(new Font("sansserif",Font.BOLD,20));
		sudPnl.add(nuovadisciplina);
		nuovolivello.addActionListener(new AscoltatoreLivelli(this, responsabile));
		nuovolivello.setFont(new Font("sansserif",Font.BOLD,20));
		sudPnl.add(nuovolivello);
		
		this.getContentPane().add(nordPnl,BorderLayout.NORTH);
		this.getContentPane().add(centroPnl,BorderLayout.WEST);
		this.getContentPane().add(sudPnl,BorderLayout.SOUTH);
		this.pack();
		
		
		int height=Toolkit.getDefaultToolkit().getScreenSize().getSize().height;  // prende la dimensione(risoluzione) dello schermo
		int width=Toolkit.getDefaultToolkit().getScreenSize().getSize().width;  // prende la dimensione(risoluzione) dello schermo
		this.setSize(width, height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}