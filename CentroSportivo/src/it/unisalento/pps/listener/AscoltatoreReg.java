package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.FormRegistrazione;
import it.unisalento.pps.view.Homepage;

public class AscoltatoreReg implements ActionListener{
		
			private	Homepage homepagewindow;
			
		public AscoltatoreReg(Homepage homepagewindow) {
			super();
			this.homepagewindow = homepagewindow;
		}


		public void actionPerformed(ActionEvent e) {
			new FormRegistrazione();
			homepagewindow.dispose();
		}
	}