package it.unisalento.pps.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unisalento.pps.view.AreaResponsabile;

public class AscoltatoreAutorizzazioni implements ActionListener {
	
private AreaResponsabile areaResponsabile;
	
	public AscoltatoreAutorizzazioni(AreaResponsabile areaResponsabile) {
		super();
		this.areaResponsabile = areaResponsabile;
	}

	public void actionPerformed(ActionEvent e) {
	}
}