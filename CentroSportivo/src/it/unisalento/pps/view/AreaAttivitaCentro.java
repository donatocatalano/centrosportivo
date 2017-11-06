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
import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.business.SpazioBusiness;
import it.unisalento.pps.business.TipoEventoBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Evento;
import it.unisalento.pps.model.Istruttore;
import it.unisalento.pps.model.Livello;
import it.unisalento.pps.model.Spazio;
import it.unisalento.pps.model.TipoEvento;
import it.unisalento.pps.model.Utente;

public class AreaAttivitaCentro extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel();
	JPanel centroPnl=new JPanel(new FlowLayout());
	JPanel sudPnl=new JPanel();
	
	JPanel titolo = new JPanel(new FlowLayout());
	JLabel scelta = new JLabel("TUTTI I CORSI E GLI EVENTI DEL CENTRO");
	
	JPanel contenuto = new JPanel(new GridLayout(2,1));
	
	JPanel contenutoVuoto = new JPanel();
	
	JButton indietro = new JButton("INDIETRO");
	
		
	AscoltatoreBackHome ascoltatoreBackHome; 
	Utente tesserato;
	Istruttore istruttore;
	ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	ArrayList<Evento> tuttiglieventi = new ArrayList<Evento>();
	ArrayList<Livello> livelli = new ArrayList<Livello>();
	
	public AreaAttivitaCentro(Utente tesserato) {
		super(tesserato.getNome()+" "+tesserato.getCognome());
		
		
		scelta.setFont(new Font("sansserif",Font.BOLD,30));
		titolo.add(scelta);
		nordPnl.add(titolo);
		
		tuttiglieventi = EventoBusiness.getInstance().getEventi();
		livelli = LivelloBusiness.getInstance().getLivelli();
		
		Disciplina disciplina;
		Spazio spazio;
		TipoEvento tipoevento;
		
		
		if(tuttiglieventi.size()>0) {
			for(int i=0;i<tuttiglieventi.size();i++) {
				System.out.println(tuttiglieventi.size());
				
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(tuttiglieventi.get(i).getDisciplina());
				spazio = SpazioBusiness.getInstance().getSpazioById(tuttiglieventi.get(i).getSpazio());
				tipoevento = TipoEventoBusiness.getInstance().getTipoEventoById(tuttiglieventi.get(i).getTipo());
			
				String giorno_inizio= tuttiglieventi.get(i).getDataInizio().toString().substring(8,10);
				String mese_inizio = tuttiglieventi.get(i).getDataInizio().toString().substring(5,7);
				String anno_inizio =tuttiglieventi.get(i).getDataInizio().toString().substring(0,4);	
			
				String giorno_fine= tuttiglieventi.get(i).getDataFine().toString().substring(8,10);
				String mese_fine = tuttiglieventi.get(i).getDataFine().toString().substring(5,7);
				String anno_fine =tuttiglieventi.get(i).getDataFine().toString().substring(0,4);
			
				JLabel campo_evento = new JLabel(disciplina.getNome()+ ": INIZIA IL:  " +giorno_inizio+ "/"+mese_inizio+ "/" +anno_inizio+"   ORARI:  " +tuttiglieventi.get(i).getTurno()+ "   TERMINA IL:  "+giorno_fine+ "/"+mese_fine+ "/" +anno_fine+"  LUOGO:  "+spazio.getNome() +"  TIPO:  "+tipoevento.getTipo()+ "  COSTO:  € "+disciplina.getCostoMensile()+"0");	
				campo_evento.setFont(new Font("sansserif",Font.BOLD,20));
				
				JPanel contenuto1=new JPanel(new GridLayout(2,1));
				contenuto1.add(contenutoVuoto);
				contenuto1.add(campo_evento);
				contenuto.setLayout(new GridLayout(tuttiglieventi.size(),1));
				contenuto.add(contenuto1);
				
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun Corso nel sistema");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenutoVuoto.add(nessunaoccorrenza);
			centroPnl.add(contenutoVuoto);		
		}			
		
		centroPnl.add(contenuto);
		
		
		ascoltatoreBackHome = new AscoltatoreBackHome(this,tesserato);
		indietro.addActionListener(ascoltatoreBackHome);
		indietro.setActionCommand(AscoltatoreBackHome.D1);
		sudPnl.add(indietro);
		
		
		
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