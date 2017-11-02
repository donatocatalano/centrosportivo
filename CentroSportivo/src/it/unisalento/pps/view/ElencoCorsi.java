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
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreEliminaEvento;
import it.unisalento.pps.listener.AscoltatoreFormEvento;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Spazio;

public class ElencoCorsi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
	JPanel contenutoVuoto = new JPanel();
	
	
	JButton indietro = new JButton("INDIETRO");
	JButton nuovocorso = new JButton("AGGIUNGI CORSO");

	AscoltatoreBackIst ascoltatoreBackIst; 
	AscoltatoreFormEvento ascoltatoreNuovoCorso;
	AscoltatoreEliminaEvento ascoltatoreElimina;
	Istruttore istruttore;
	ArrayList<Evento> corsi = new ArrayList<Evento>();


	public ElencoCorsi(Istruttore istruttore) {
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
		
		titolo.setText("ELENCO CORSI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		corsi = EventoBusiness.getInstance().getCorsiByIdIstruttore(istruttore.getIdIstruttore());
		centroPnl.setLayout(new GridLayout(5*corsi.size(),1));
		Disciplina disciplina;
		Spazio spazio;
		
		if(corsi.size()>0) {
			for(int i=0;i<corsi.size();i++) {
			
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(corsi.get(i).getDisciplina());
				spazio = SpazioBusiness.getInstance().getSpazioById(corsi.get(i).getSpazio());
			
				String giorno_inizio= corsi.get(i).getDataInizio().toString().substring(8,10);
				String mese_inizio = corsi.get(i).getDataInizio().toString().substring(5,7);
				String anno_inizio =corsi.get(i).getDataInizio().toString().substring(0,4);	
			
				String giorno_fine= corsi.get(i).getDataFine().toString().substring(8,10);
				String mese_fine = corsi.get(i).getDataFine().toString().substring(5,7);
				String anno_fine =corsi.get(i).getDataFine().toString().substring(0,4);		
			
				JLabel corso = new JLabel("CORSO di " +disciplina.getNome()+ ": INIZIA IL:  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   ORARI:  " +corsi.get(i).getTurno()+ "   TERMINA IL:  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome()+"   ");
				corso.setFont(new Font("sansserif",Font.BOLD,20));
				corso.setHorizontalAlignment(JLabel.LEFT);
				JButton elimina = new JButton ("ELIMINA");
				contenuto.add(corso);
				contenuto.add(elimina);
				centroPnl.add(contenuto);
			
				ascoltatoreElimina = new AscoltatoreEliminaEvento(this,istruttore,corsi.get(i));
				elimina.setActionCommand(AscoltatoreEliminaEvento.D1);
				elimina.addActionListener(ascoltatoreElimina);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Corso nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}	
		
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
		sudPnl.add(indietro);
		ascoltatoreNuovoCorso = new AscoltatoreFormEvento (this, istruttore);
		nuovocorso.addActionListener(ascoltatoreNuovoCorso);
		nuovocorso.setActionCommand(AscoltatoreFormEvento.D1);
		sudPnl.add(nuovocorso);
		
		
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

