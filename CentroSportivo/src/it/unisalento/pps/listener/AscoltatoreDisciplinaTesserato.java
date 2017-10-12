package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unisalento.pps.view.HomepageTesserato;
import it.unisalento.pps.view.InfoDisciplinaTesserato;

public class AscoltatoreDisciplinaTesserato implements ActionListener {
	
	public final static String D1="d1";
	public final static String D2="d2";
	public final static String D3="d3";
	public final static String D4="d4";
	public final static String D5="d5";
	private JFrame frame;
	
	public AscoltatoreDisciplinaTesserato (HomepageTesserato frame) {
		super();
		this.frame = frame; 		
	}

	public void actionPerformed(ActionEvent e) {
		
		String com = e.getActionCommand();
		if (com==D1)
			d1launch();	
		else if (com==D2)
			d1launch();	
		else if (com==D3)
			d1launch();	
		else if (com==D4)
			d1launch();	
		else if (com==D5)
			d1launch();		
	}
	
	private void d1launch() {
		new InfoDisciplinaTesserato();
		frame.dispose();
	}
}
