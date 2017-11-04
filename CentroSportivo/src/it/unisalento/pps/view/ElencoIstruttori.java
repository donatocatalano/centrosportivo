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

import it.unisalento.pps.business.IstruttoreBusiness;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreEliminaIstruttore;
import it.unisalento.pps.listener.AscoltatoreFormIstruttore;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Responsabile;

public class ElencoIstruttori extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	JPanel contenutoVuoto = new JPanel();
	
	JButton indietro = new JButton("INDIETRO");
	JButton nuovoistruttore = new JButton("AGGIUNGI ISTRUTTORE");

	AscoltatoreBackResp ascoltatoreBackResp;
	AscoltatoreEliminaIstruttore ascoltatoreEliminaIstruttore;
	AscoltatoreFormIstruttore ascoltatoreNuovoIstruttore;
	ArrayList<Istruttore> istruttori = new ArrayList<Istruttore>();
	

	public ElencoIstruttori(Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());
		
		titolo.setText("ELENCO ISTRUTTORI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		istruttori = IstruttoreBusiness.getInstance().getIstruttori();
		
		
		if(istruttori.size()>0) {
			
			contenuto.setLayout(new GridLayout(5*istruttori.size(),1));
			centroPnl.add(contenuto);
			
			for(int i=0;i<istruttori.size();i++) {
				
				JPanel contenuto1 = new JPanel(new FlowLayout());
				JLabel istruttore = new JLabel("ID UTENTE: " +istruttori.get(i).getIdIstruttore()+"    NOME: " +istruttori.get(i).getCognome()+"    COGNOME: " +istruttori.get(i).getNome()+"    USERNAME: "+istruttori.get(i).getUsername()+"    PASSWORD: "+istruttori.get(i).getPassword()+"     ");
				istruttore.setFont(new Font("sansserif",Font.BOLD,20));
				JButton eliminaistruttore = new JButton ("CANCELLA ISTRUTTORE");
				contenuto1.add(istruttore);
				contenuto1.add(eliminaistruttore);
				contenuto.add(contenuto1);
				
				JPanel contenuto2 = new JPanel();
				contenuto.add(contenuto2);
				
				ascoltatoreEliminaIstruttore= new AscoltatoreEliminaIstruttore(this, responsabile, istruttori.get(i));
				eliminaistruttore.addActionListener(ascoltatoreEliminaIstruttore);
				}	
			}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Istruttore al momento!");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}	
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		sudPnl.add(indietro);
		ascoltatoreNuovoIstruttore = new AscoltatoreFormIstruttore(this, responsabile);
		nuovoistruttore.addActionListener(ascoltatoreNuovoIstruttore);
		sudPnl.add(nuovoistruttore);
		
		
		
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

