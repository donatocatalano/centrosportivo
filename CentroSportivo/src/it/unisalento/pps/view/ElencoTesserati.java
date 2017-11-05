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

import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreEliminaTesserato;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.Utente;

public class ElencoTesserati extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	JPanel contenutoVuoto = new JPanel();
	
	JButton indietro = new JButton("INDIETRO");

	AscoltatoreBackResp ascoltatoreBackResp;
	AscoltatoreEliminaTesserato ascoltatoreEliminaTesserato;
	ArrayList<Utente> tesserati = new ArrayList<Utente>();
	

	public ElencoTesserati(Responsabile responsabile) {
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());
		
		titolo.setText("ELENCO TESSERATI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		tesserati = UtenteBusiness.getInstance().getTesserati();
		
		
		if(tesserati.size()>0) {
			
			contenuto.setLayout(new GridLayout(5*tesserati.size(),1));
			centroPnl.add(contenuto);
			
			for(int i=0;i<tesserati.size();i++) {
				
				String giorno = tesserati.get(i).getDataNascita().toString().substring(8,10);
				String mese = tesserati.get(i).getDataNascita().toString().substring(5,7);
				String anno = tesserati.get(i).getDataNascita().toString().substring(0,4);	
				
				JPanel contenuto1 = new JPanel(new FlowLayout());
				JLabel tesserato = new JLabel("ID TESSERATO: " +tesserati.get(i).getIdUtente()+"    NOME: " +tesserati.get(i).getCognome()+"    COGNOME: " +tesserati.get(i).getNome()+"    DATA DI NASCITA: "+giorno+"/"+mese+"/"+anno+ "    USERNAME: "+tesserati.get(i).getUsername()+"    PASSWORD: "+tesserati.get(i).getPassword()+"     ");
				tesserato.setFont(new Font("sansserif",Font.BOLD,20));
				JButton eliminatesserato = new JButton ("CANCELLA TESSERATO");
				contenuto1.add(tesserato);
				contenuto1.add(eliminatesserato);
				contenuto.add(contenuto1);
				
				JPanel contenuto2 = new JPanel();
				contenuto.add(contenuto2);
				
				ascoltatoreEliminaTesserato= new AscoltatoreEliminaTesserato(this, responsabile, tesserati.get(i));
				eliminatesserato.addActionListener(ascoltatoreEliminaTesserato);
				}	
			}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Tesserato al momento!");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}	
		
		
		ascoltatoreBackResp = new AscoltatoreBackResp(this, responsabile);
		indietro.addActionListener(ascoltatoreBackResp);
		sudPnl.add(indietro);
		
		
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

