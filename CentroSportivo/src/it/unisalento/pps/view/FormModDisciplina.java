package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.listener.AscoltatoreBackHome;
import it.unisalento.pps.listener.AscoltatoreBackResp;
import it.unisalento.pps.listener.AscoltatoreConfermaDisciplina;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Responsabile;

public class FormModDisciplina extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Font myfont = new Font("sansserif",Font.PLAIN,25);  
	private Dimension mysize = new Dimension (200,30);
	
	private JPanel nordPnl=new JPanel(new GridLayout (2,1));
	private JPanel centroPnl=new JPanel(new GridLayout (3,3));
	private JPanel sudPnl=new JPanel();
	
	
	private JPanel paginareg= new JPanel();
	private JLabel compilaform= new JLabel("INSERISCI I DATI RICHIESTI");
	private JPanel vuoto= new JPanel();
	
	
	private JPanel name= new JPanel(new FlowLayout());
	private JLabel nome= new JLabel("NOME");
	public JTextField nome_field;
	
	private JPanel cost= new JPanel(new FlowLayout());
	private JLabel costo= new JLabel("COSTO MENSILE");
	public JTextField costo_field;
	
	private JPanel period= new JPanel(new FlowLayout());
	private JLabel descrizione= new JLabel("BREVE DESCRIZIONE");
	public JTextArea descrizione_field;
		
	private JPanel image= new JPanel(new FlowLayout());
	private JLabel immagine= new JLabel("INSERISCI NOME FILE IMMAGINE");
	public JTextField immagine_field;
	
	private JPanel appartenenza = new JPanel(new FlowLayout());
	private JLabel campo_disciplina = new JLabel("");
	

	private JButton indietro= new JButton("INDIETRO");
	private JButton inserimento= new JButton("CONFERMA DATI INSERITI");
	
	private AscoltatoreConfermaDisciplina ascoltatoreConfermaDisciplina;
	private ArrayList<Disciplina> discipline = new ArrayList<Disciplina>();
	
	public FormModDisciplina(Responsabile responsabile, Disciplina disciplina) {
		super("Area privata RESPONSABILE : "+responsabile.getNome()+" "+responsabile.getCognome());
		
		compilaform.setFont(new Font("sansserif",Font.BOLD,34));
		compilaform.setHorizontalAlignment(JLabel.CENTER);
		paginareg.add(compilaform);
		paginareg.add(vuoto);
		nordPnl.add(paginareg);
		
		disciplina = DisciplinaBusiness.getInstance().getDisciplinaById(disciplina.getIdDisciplina());
		
		nome.setFont(new Font("sansserif",Font.BOLD,25));
		nome_field = new JTextField(disciplina.getNome());
		nome_field.setFont(myfont);
		nome_field.setPreferredSize(mysize);
		name.add(nome_field);
		name.add(nome);
		centroPnl.add(name);
		cost.add(costo);
		costo.setFont(new Font("sansserif",Font.BOLD,25));
		costo_field = new JTextField(Double.toString(disciplina.getCostoMensile()));
		costo_field.setFont(myfont);
		costo_field.setPreferredSize(mysize);
		cost.add(costo_field);
		centroPnl.add(cost);
		period.add(descrizione);
		descrizione.setFont(new Font("sansserif",Font.BOLD,25));
		descrizione_field = new JTextArea(disciplina.getDescrizione(),5,20);
		period.add(descrizione_field);
		descrizione_field.setFont(myfont);
		descrizione_field.setPreferredSize(mysize);
		centroPnl.add(period);
		immagine_field= new JTextField(disciplina.getImmagine(),15);
		image.add(immagine);
		immagine.setFont(new Font("sansserif",Font.BOLD,25));
		immagine_field.setFont(myfont);
		immagine_field.setPreferredSize(mysize);
		image.add(immagine_field);
		centroPnl.add(image);
		appartenenza.add(campo_disciplina);
		campo_disciplina.setFont(new Font("sansserif",Font.BOLD,25));
		centroPnl.add(appartenenza);


		indietro.addActionListener(new AscoltatoreBackResp(this, responsabile));
		ascoltatoreConfermaDisciplina = new AscoltatoreConfermaDisciplina(this, responsabile, disciplina);
		inserimento.addActionListener(ascoltatoreConfermaDisciplina);
		inserimento.setActionCommand(AscoltatoreBackHome.D1);	
		sudPnl.add(indietro);
		sudPnl.add(inserimento);
		
		
		
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