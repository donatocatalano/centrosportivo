package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.AreaGestore;

public class AscoltatoreCatalogo implements ActionListener {
	
	private AreaGestore areaGestore;
	
	public AscoltatoreCatalogo(AreaGestore areaGestore) {
		super();
		this.areaGestore = areaGestore;
	}

	public void actionPerformed(ActionEvent e) {
	}
}