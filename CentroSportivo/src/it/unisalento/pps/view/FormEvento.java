package it.unisalento.pps.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.unisalento.pps.business.DisciplinaBusiness;
import it.unisalento.pps.listener.AscoltatoreBackIst;
import it.unisalento.pps.listener.AscoltatoreConfermaCorso;
import it.unisalento.pps.listener.AscoltatoreConfermaEvento;
import it.unisalento.pps.model.Disciplina;
import it.unisalento.pps.model.Istruttore;

public class FormEvento extends JFrame {
	
	Font myfont = new Font("sansserif",Font.PLAIN,20);  
	Dimension mysize = new Dimension (200,30);
	
	JPanel nordPnl=new JPanel(new GridLayout (2,1));
	JPanel centroPnl=new JPanel(new GridLayout (3,3));
	JPanel sudPnl=new JPanel();
	
	
	JPanel paginareg= new JPanel();
	JLabel compilaform= new JLabel("INSERISCI I DATI RICHIESTI");
	JPanel vuoto= new JPanel();
	
	
	JPanel datestart= new JPanel(new FlowLayout());
	JLabel datainizio= new JLabel("DATA INIZIO (nel formato gg-mm-aaaa)");
	public JTextField datainizio_field= new JTextField(15);
	
	JPanel turn= new JPanel(new FlowLayout());
	JLabel orario= new JLabel("TURNI");
	public JTextField orario_field= new JTextField(15);
	
	JPanel spazio= new JPanel(new FlowLayout());
	JLabel luogo= new JLabel("DOVE");
	JComboBox combo_luogo = new JComboBox();
	
		
	JPanel tipo= new JPanel(new FlowLayout());
	JLabel tipoevento= new JLabel("TIPO EVENTO");   
	JComboBox combo_evento = new JComboBox();
	
	JPanel appartenenza = new JPanel(new FlowLayout());
	JLabel disciplina = new JLabel("DISCIPLINA");   
	JComboBox combo_disciplina = new JComboBox();
	
	JPanel dateend= new JPanel(new FlowLayout());
	JLabel datafine= new JLabel("DATA FINE (nel formato gg-mm-aaaa)");
	public JTextField datafine_field= new JTextField(15);
	
	
	JButton indietro= new JButton("INDIETRO");
	JButton inserimento= new JButton("CONFERMA DATI INSERITI");
	
	
	public FormEvento(Istruttore istruttore) {
		super("Area privata ISTRUTTORE : "+istruttore.getNome()+" "+istruttore.getCognome());
		
		ArrayList<Disciplina> discipline = DisciplinaBusiness.getInstance().getDiscipline();
		
		compilaform.setFont(new Font("sansserif",Font.BOLD,34));
		compilaform.setHorizontalAlignment(JLabel.CENTER);
		paginareg.add(compilaform);
		paginareg.add(vuoto);
		nordPnl.add(paginareg);
		
		
		datestart.add(datainizio);
		datainizio.setFont(new Font("sansserif",Font.BOLD,25));
		datestart.add(datainizio_field);
		datainizio_field.setFont(myfont);
		datainizio_field.setPreferredSize(mysize);
		centroPnl.add(datestart);
		turn.add(orario);
		orario.setFont(new Font("sansserif",Font.BOLD,25));
		turn.add(orario_field);
		orario_field.setFont(myfont);
		orario_field.setPreferredSize(mysize);
		centroPnl.add(turn);
		spazio.add(luogo);
		luogo.setFont(new Font("sansserif",Font.BOLD,25));
		combo_luogo.addItem("PISCINA");
		combo_luogo.addItem("PALESTRA");
		combo_luogo.addItem("SALAPESI");
		combo_luogo.setEditable(true);
		combo_luogo.setFont(myfont);
		combo_luogo.setPreferredSize(mysize);
		spazio.add(combo_luogo);
		centroPnl.add(spazio);
		tipo.add(tipoevento);
		tipoevento.setFont(new Font("sansserif",Font.BOLD,25));
		combo_evento.addItem("GARA");
		combo_evento.addItem("STAGE");
		combo_evento.setEditable(true);
		combo_evento.setFont(myfont);
		combo_evento.setPreferredSize(mysize);
		tipo.add(combo_evento);
		centroPnl.add(tipo);
		appartenenza.add(disciplina);
		disciplina.setFont(new Font("sansserif",Font.BOLD,25));
		for(int i=0;i<discipline.size();i++) {
			combo_disciplina.addItem(discipline.get(i).getNome());
			combo_disciplina.setEditable(true);
			combo_disciplina.setFont(myfont);
			combo_disciplina.setPreferredSize(mysize);
			}
		appartenenza.add(combo_disciplina);
		centroPnl.add(appartenenza);
		dateend.add(datafine);
		datafine.setFont(new Font("sansserif",Font.BOLD,25));
		dateend.add(datafine_field);
		datafine_field.setFont(myfont);
		datafine_field.setPreferredSize(mysize);
		centroPnl.add(dateend);


		indietro.addActionListener(new AscoltatoreBackIst(this, istruttore));
		//
		inserimento.addActionListener(new AscoltatoreConfermaEvento(this, istruttore));
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