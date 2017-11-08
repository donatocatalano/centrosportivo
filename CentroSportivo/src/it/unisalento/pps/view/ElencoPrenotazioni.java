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
import it.unisalento.pps.business.EventoBusiness;
import it.unisalento.pps.business.PrenotazioneBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.business.UtenteBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreEliminaEvento;
import it.unisalento.pps.listener.AscoltatoreFormEvento;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Iscrizione;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Prenotazione;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;
import it.unisalento.pps.model.Utente;

public class ElencoPrenotazioni extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	JPanel contenutoVuoto = new JPanel();
	
	
	JLabel titolo = new JLabel();
		
	JButton indietro = new JButton("INDIETRO");

	AscoltatoreBackIst ascoltatoreBackIst; 
	AscoltatoreFormEvento ascoltatoreNuovoCorso;
	AscoltatoreEliminaEvento ascoltatoreElimina;
	ArrayList<Iscrizione> iscrizioni = new ArrayList<Iscrizione>();
	ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	
	

	public ElencoPrenotazioni(Istruttore istruttore) {
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
		
		titolo.setText("ELENCO PRENOTAZIONI"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);		
		
		Evento evento;
		Utente utente;
		Disciplina disciplina;
		Spazio luogo;
		TipoEvento tipo;
		
		prenotazioni = PrenotazioneBusiness.getInstance().getPrenotazioni();
		centroPnl.setLayout(new GridLayout(prenotazioni.size(),1));
		
		if(prenotazioni.size()>0) {
			
			for(int i=0;i<prenotazioni.size();i++) {
				
				evento = EventoBusiness.getInstance().getEventoById(prenotazioni.get(i).getEvento());
				utente = UtenteBusiness.getInstance().getUtenteById(prenotazioni.get(i).getUtente());
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(evento.getDisciplina());
				luogo = SpazioBusiness.getInstance().getSpazioById(evento.getSpazio());
				tipo = TipoEventoBusiness.getInstance().getTipoEventoById(evento.getTipo());
				
				String giorno = prenotazioni.get(i).getDataPrenotazione().toString().substring(8,10);
				String mese = prenotazioni.get(i).getDataPrenotazione().toString().substring(5,7);
				String anno = prenotazioni.get(i).getDataPrenotazione().toString().substring(0,4);	
				
				JLabel prenotazione = new JLabel();				
				prenotazione.setText(+(i+1)+"  Prenotazione del " +giorno+"/"+mese+"/"+anno+ "   di   " +utente.getNome().toUpperCase()+"   " +utente.getCognome().toUpperCase()+" per la "+tipo.getTipo().toUpperCase()+ " di "+disciplina.getNome().toUpperCase()+ " in "+luogo.getNome().toUpperCase()+ " orari :"+evento.getTurno());
				prenotazione.setFont(new Font("sansserif",Font.BOLD,20));
				JPanel contenuto = new JPanel(new FlowLayout());
				contenuto.add(prenotazione, BorderLayout.CENTER);
				centroPnl.add(contenuto, BorderLayout.CENTER);
					}
				}
				else {
					JLabel nessunaoccorrenza = new JLabel("Nessuna Prenotazione al momento!");	
					nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
					contenutoVuoto.add(nessunaoccorrenza);
					centroPnl.add(contenutoVuoto);		
				}	
			
		
		ascoltatoreBackIst = new AscoltatoreBackIst(this, istruttore);
		indietro.addActionListener(ascoltatoreBackIst);
		indietro.setFont(new Font("sansserif",Font.BOLD,20));
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

