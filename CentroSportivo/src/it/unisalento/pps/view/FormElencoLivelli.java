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

import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreEliminaLivello;
import it.unisalento.pps.listener.AscoltatoreNuovoLivello;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Responsabile;

public class FormElencoLivelli extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenutoVuoto = new JPanel();
	JButton modifica = new JButton ("MODIFICA");

	JButton indietro= new JButton("INDIETRO");
	JButton nuovadisciplina = new JButton("AGGIUNGI DISCIPLINA");
	JButton nuovolivello = new JButton("AGGIUNGI LIVELLO");
	
	AscoltatoreBackResp ascoltatoreBackResp; 
	AscoltatoreEliminaLivello ascoltatoreElimina;
	Responsabile responsabile;
	ArrayList<Livello> livelli = new ArrayList<Livello>();

	public FormElencoLivelli(Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());
		
		titolo.setText("ELENCO LIVELLI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		JPanel contenutolivello=new JPanel(new FlowLayout());
		
		livelli = LivelloBusiness.getInstance().getLivelli();
		centroPnl.setLayout(new GridLayout(livelli.size(),1));
		
		if(livelli.size()>0) {
			for(int i=0;i<livelli.size();i++) {
				JLabel campo_livello = new JLabel("             "+livelli.get(i).getNome()+"   ");	
				campo_livello.setFont(new Font("sansserif",Font.BOLD,20));
				JButton elimina = new JButton ("ELIMINA");
				contenutolivello.add(campo_livello);
				contenutolivello.add(elimina);
				
				ascoltatoreElimina = new AscoltatoreEliminaLivello(this,responsabile,livelli.get(i));
				elimina.addActionListener(ascoltatoreElimina);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessuna Disciplina nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}			
		
		centroPnl.add(contenutolivello);
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		sudPnl.add(indietro);
		indietro.setFont(new Font("sansserif",Font.BOLD,20));
		nuovolivello.setFont(new Font("sansserif",Font.BOLD,20));
		nuovolivello.addActionListener(new AscoltatoreNuovoLivello(this, responsabile));
		sudPnl.add(nuovolivello);
		
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