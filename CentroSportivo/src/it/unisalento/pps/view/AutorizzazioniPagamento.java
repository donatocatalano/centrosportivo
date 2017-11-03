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

import it.unisalento.pps.business.IscrizioneBusiness;
<<<<<<< HEAD
import it.unisalento.pps.business.PagamentoBusiness;
import it.unisalento.pps.business.TipoPagamentoBusiness;
=======
import it.unisalento.pps.business.LivelloBusiness;
import it.unisalento.pps.business.PagamentoBusiness;
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
import it.unisalento.pps.business.UtenteBusiness;
<<<<<<< HEAD
import it.unisalento.pps.listener.AscoltatoreAutorizzaPagamento;
=======
import it.unisalento.pps.listener.AscoltatoreAutPag;
import it.unisalento.pps.listener.AscoltatoreAutorizzaIscrizione;
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
import it.unisalento.pps.listener.AscoltatoreAutorizzazioni;
import it.unisalento.pps.model.Iscrizione;
<<<<<<< HEAD
=======
import it.unisalento.pps.model.Livello;
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
import it.unisalento.pps.model.Pagamento;
import it.unisalento.pps.model.Responsabile;
import it.unisalento.pps.model.TipoPagamento;
import it.unisalento.pps.model.Utente;

public class AutorizzazioniPagamento extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel nordPnl=new JPanel(new GridLayout(2,1));
	JPanel centroPnl=new JPanel();
	JPanel sudPnl=new JPanel();
	
	
	JLabel titolo = new JLabel();
	JLabel spazio = new JLabel();
	
	JPanel contenuto = new JPanel();
		
	JButton indietro= new JButton("INDIETRO");
	
		
	AscoltatoreAutorizzazioni ascoltatoreAutorizzazioni;
	ArrayList<Pagamento> pagamentiDaAutorizzare = new ArrayList<Pagamento>();
		
	public AutorizzazioniPagamento(Responsabile responsabile){
		super("Area privata RESPONSABILE : "+ responsabile.getNome()+" "+responsabile.getCognome());	
		
		titolo.setText("PAGAMENTI IN ATTESA DI CONFERMA"); 
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setFont(new Font("sansserif",Font.BOLD,34));
		nordPnl.add(titolo);
		nordPnl.add(spazio);
			
		pagamentiDaAutorizzare = PagamentoBusiness.getInstance().getPagamentiDaAutorizzare();
		
		TipoPagamento tipo;
		Utente utente;
		Iscrizione iscrizione;
			  
		if(pagamentiDaAutorizzare.size()>0) {	
			
			contenuto.setLayout(new GridLayout(pagamentiDaAutorizzare.size(),1));
			centroPnl.add(contenuto);
			
			for(int i=0;i<pagamentiDaAutorizzare.size();i++) {
<<<<<<< HEAD
				tipo = TipoPagamentoBusiness.getInstance().getTipoPagamentoById(pagamentiDaAutorizzare.get(i).getTipo());
=======
				disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(pagamentiDaAutorizzare.get(i).getIscrizione());
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
				utente = UtenteBusiness.getInstance().getUtenteById(pagamentiDaAutorizzare.get(i).getUtente());
<<<<<<< HEAD
				iscrizione = IscrizioneBusiness.getInstance().getIscrizioneById(pagamentiDaAutorizzare.get(i).getIscrizione());
=======
				//livello = LivelloBusiness.getInstance().getLivelloById(pagamentiDaAutorizzare.get(i).getTotale());
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
				
<<<<<<< HEAD
			//	String giorno= pagamentiDaAutorizzare.get(i).getData_Pagamento().toString().substring(8,10);
			//	String mese = pagamentiDaAutorizzare.get(i).getData_Pagamento().toString().substring(5,7);
			//	String anno = pagamentiDaAutorizzare.get(i).getData_Pagamento()).toString().substring(0,4);	
				
=======
						
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
				JPanel contenuto1 = new JPanel(new FlowLayout());
<<<<<<< HEAD
				JLabel pagamento = new JLabel("Richiesta di pagamento per "+utente.getNome()+" "+utente.getCognome()+" CON "+tipo.getTipo());	
=======
				JLabel pagamento = new JLabel("PROVA LABEL");
				//JLabel pagamento = new JLabel("Richiesta di pagamento per "+disciplina.getNome()+",   Livello: "+livello.getNome()+",   UTENTE: "+utente.getNome()+" "+utente.getCognome()+"   del " +giorno+"/"+mese+"/"+anno+"   ");	
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
				pagamento.setFont(new Font("sansserif",Font.BOLD,20));
				JButton autorizzapagamento = new JButton("AUTORIZZA PAGAMENTO");
				contenuto1.add(pagamento);
				contenuto1.add(autorizzapagamento);
				contenuto.add(contenuto1);
				
				JPanel contenuto2 = new JPanel();
				contenuto.add(contenuto2);
				
<<<<<<< HEAD
				ascoltatoreAutorizzaPagamento = new AscoltatoreAutorizzaPagamento(this, responsabile, pagamentiDaAutorizzare.get(i));
				autorizzapagamento.addActionListener(ascoltatoreAutorizzaPagamento);
=======
				//ascoltatoreAutorizzaPagamento = new AscoltatoreAutPag(this, responsabile, pagamentiDaAutorizzare.get(i));
				//autorizzapagamenti.addActionListener(ascoltatoreAutorizzaPagamento);
>>>>>>> branch 'master' of https://github.com/donatocatalano/centrosportivo
			}
		}
		else {
			JLabel nessunaoccorrenza = new JLabel("Nessun pagamento pendente!");	
			nessunaoccorrenza.setFont(new Font("sansserif",Font.BOLD,20));
			contenuto.add(nessunaoccorrenza);
			centroPnl.add(contenuto);		
		}
			
		ascoltatoreAutorizzazioni = new AscoltatoreAutorizzazioni(this, responsabile);
		indietro.addActionListener(ascoltatoreAutorizzazioni);
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
