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
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreEliminaEvento;
import it.unisalento.pps.listener.AscoltatoreFormEvento;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;

public class ElencoEventi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel nordPnl=new JPanel(new GridLayout(2,1));
	private JPanel centroPnl=new JPanel();
	private JPanel sudPnl=new JPanel();
	
	
	private JLabel titolo = new JLabel();
	private JLabel spazio = new JLabel();
	
	private JPanel contenuto = new JPanel();
	private JPanel contenutoVuoto = new JPanel();
	
	private JButton indietro = new JButton("INDIETRO");
	private JButton nuovoevento = new JButton("AGGIUNGI EVENTO");

	private AscoltatoreBackIst ascoltatoreBackIst; 
	private AscoltatoreFormEvento ascoltatoreNuovoEvento;
	private AscoltatoreEliminaEvento ascoltatoreElimina;
	private ArrayList<Evento> eventi = new ArrayList<Evento>();
	

	public ElencoEventi(Istruttore istruttore) {
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
		
		titolo.setText("ELENCO EVENTI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
		
		eventi = EventoBusiness.getInstance().getEventiByIdIstruttore(istruttore.getIdIstruttore());
		
		centroPnl.setLayout(new GridLayout(eventi.size(),1));
		Disciplina disciplina;
		Spazio spazio;
		TipoEvento tipo;
		
		if(eventi.size()>0) {
			for(int i=0;i<eventi.size();i++) {
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(eventi.get(i).getDisciplina());
				spazio = SpazioBusiness.getInstance().getSpazioById(eventi.get(i).getSpazio());
				tipo = TipoEventoBusiness.getInstance().getTipoEventoById(eventi.get(i).getTipo());
				
				String giorno_inizio = eventi.get(i).getDataInizio().toString().substring(8,10);
				String mese_inizio = eventi.get(i).getDataInizio().toString().substring(5,7);
				String anno_inizio = eventi.get(i).getDataInizio().toString().substring(0,4);	
			
				String giorno_fine = eventi.get(i).getDataFine().toString().substring(8,10);
				String mese_fine = eventi.get(i).getDataFine().toString().substring(5,7);
				String anno_fine = eventi.get(i).getDataFine().toString().substring(0,4);		
			
				JLabel evento = new JLabel(tipo.getTipo().toUpperCase()+" di " +disciplina.getNome()+ ": INIZIA IL:  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   ORARI:  " +eventi.get(i).getTurno()+ "   TERMINA IL:  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome()+"   ");
				evento.setFont(new Font("sansserif",Font.BOLD,20));
				JButton elimina = new JButton ("ELIMINA");
				contenuto.add(evento);
				contenuto.add(elimina);
				centroPnl.add(contenuto);
			
				ascoltatoreElimina = new AscoltatoreEliminaEvento(this,istruttore,eventi.get(i));
				elimina.addActionListener(ascoltatoreElimina);
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Evento nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}			
		
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
		indietro.setFont(new Font("sansserif",Font.BOLD,20));
		sudPnl.add(indietro);
		ascoltatoreNuovoEvento = new AscoltatoreFormEvento (this, istruttore);
		nuovoevento.addActionListener(ascoltatoreNuovoEvento);
		nuovoevento.setFont(new Font("sansserif",Font.BOLD,20));
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