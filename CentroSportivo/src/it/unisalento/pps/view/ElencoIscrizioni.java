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
import it.unisalento.pps.business.IscrizioneBusiness;
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreEliminaEvento;
import it.unisalento.pps.listener.AscoltatoreFormEvento;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Utente;

public class ElencoIscrizioni extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	JPanel contenutoVuoto = new JPanel();
	
	JButton indietro = new JButton("INDIETRO");

	AscoltatoreBackIst ascoltatoreBackIst; 
	AscoltatoreFormEvento ascoltatoreNuovoCorso;
	AscoltatoreEliminaEvento ascoltatoreElimina;
	ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
	

	public ElencoIscrizioni(Istruttore istruttore) {
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
		
		titolo.setText("ELENCO ISCRIZIONI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		iscrizioni = IscrizioneBusiness.getInstance().getIscrizioniAutorizzate();
		centroPnl.setLayout(new GridLayout(5*iscrizioni.size(),1));
		Disciplina disciplina;
		Utente utente;
		
		if(iscrizioni.size()>0) {
			for(int i=0;i<iscrizioni.size();i++) {
				if(iscrizioni.get(i).getDataConferma()!=null) {
			
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(iscrizioni.get(i).getDisciplina());
				utente = UtenteBusiness.getInstance().getUtenteById(iscrizioni.get(i).getUtente());
				
				String giorno = iscrizioni.get(i).getDataConferma().toString().substring(8,10);
				String mese = iscrizioni.get(i).getDataConferma().toString().substring(5,7);
				String anno = iscrizioni.get(i).getDataConferma().toString().substring(0,4);				
				
				JLabel iscrizione = new JLabel("Iscrizione del " +giorno+"/"+mese+"/"+anno+ "   Disciplina" +disciplina.getNome()+ "   di   " +utente.getNome()+"   " +utente.getCognome());
				iscrizione.setFont(new Font("sansserif",Font.BOLD,20));
				iscrizione.setHorizontalAlignment(JLabel.LEFT);
				contenuto.add(iscrizione);
				centroPnl.add(contenuto);
				}
				else {
					JLabel nessunaoccorrenza = new JLabel("Nessuna Iscrizione al momento!");	
					nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
					contenutoVuoto.add(nessunaoccorrenza);
					centroPnl.add(contenutoVuoto);		
				}	
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessuna Iscrizione al momento!");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}	
		
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
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

