package it.unisalento.pps.listener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import it.unisalento.pps.business.*;
import it.unisalento.pps.view.*;

public class LoginBtnListener implements ActionListener, KeyListener {

	private Homepage homepageWindow;
	
	public LoginBtnListener(Homepage homepageWindow) {
		super();
		this.homepageWindow = homepageWindow;
	}
	
	public void keyPressed(KeyEvent homepagewindow) {
		if (homepagewindow.getKeyCode() == KeyEvent.VK_ENTER) {
			
			String username = homepageWindow.username.getText();
			String password = homepageWindow.password.getText();
			
			
			boolean responsabileEsiste = ResponsabileBusiness.getInstance().verificaLogin(username, password);
			boolean istruttoreEsiste = IstruttoreBusiness.getInstance().verificaLogin(username, password);
			boolean utenteEsiste = UtenteBusiness.getInstance().verificaLogin(username, password);
			
					
			if(responsabileEsiste){
				JOptionPane.showMessageDialog(null, "<html><p align=\"center\">BENVENUTO RESPONSABILE!</p></html>");
				new AreaGestore();
				homepageWindow.dispose();
			}			    
			else if(istruttoreEsiste){
				JOptionPane.showMessageDialog(null, "<html><p align=\"center\">BENVENUTO ISTRUTTORE!</p></html>");
				new AreaIstruttore();
				homepageWindow.dispose();
			}
			else if(utenteEsiste){
				
				boolean tesseratoEsiste = UtenteBusiness.getInstance().verificaLoginTesserato(username, password);
				
				if (tesseratoEsiste){
					JOptionPane.showMessageDialog(null, "<html><p align=\"center\">BENVENUTO TESSERATO!</p></html>");
					new HomepageTesserato(username);
					homepageWindow.dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "<html><b>ATTENZIONE!!!</b><br>Registrazione in attesa di conferma!</html>");
			}
			else //if (!responsabileEsiste & !istruttoreEsiste & !utenteEsiste)
						JOptionPane.showMessageDialog(null, "<html><p align=\"center\">UTENTE NON RICONOSCIUTO!</p></html>");
		}
	}
		
	
	public void keyTyped(KeyEvent e) {
		}
	public void keyReleased(KeyEvent e) {
		}



	
	public void actionPerformed(ActionEvent e){		

		String username = homepageWindow.username.getText();
		String password = homepageWindow.password.getText();
		
		
		boolean responsabileEsiste = ResponsabileBusiness.getInstance().verificaLogin(username, password);
		boolean istruttoreEsiste = IstruttoreBusiness.getInstance().verificaLogin(username, password);
		boolean utenteEsiste = UtenteBusiness.getInstance().verificaLogin(username, password);
		
				
		if(responsabileEsiste){
			JOptionPane.showMessageDialog(null, "<html><p align=\\\"center\\\">BENVENUTO RESPONSABILE!</p></html>");
			new AreaGestore();
			homepageWindow.dispose();
		}
		else if(istruttoreEsiste){
			JOptionPane.showMessageDialog(null, "<html><p align=\\\"center\\\">BENVENUTO ISTRUTTORE!</p></html>");
			new AreaIstruttore();
			homepageWindow.dispose();
		}
		else if(utenteEsiste){
			
			boolean tesseratoEsiste = UtenteBusiness.getInstance().verificaLoginTesserato(username, password);
			
			if (tesseratoEsiste){
				JOptionPane.showMessageDialog(null, "<html><p align=\\\"center\\\">BENVENUTO TESSERATO!</p></html>");
				new HomepageTesserato(username);
				homepageWindow.dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "<html><b>ATTENZIONE!!!</b><br>Registrazione in attesa di conferma!</html>");
		}
		else //if (!responsabileEsiste & !istruttoreEsiste & !utenteEsiste)
					JOptionPane.showMessageDialog(null, "<html><p align=\\\"center\\\">UTENTE NON RICONOSCIUTO!</p></html>");
	}
}
