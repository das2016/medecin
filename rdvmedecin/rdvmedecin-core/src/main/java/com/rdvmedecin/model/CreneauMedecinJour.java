package com.rdvmedecin.model;

import java.io.Serializable;

import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Rv;

/**
 * 
 * @author SKAN
 * 
 */
public class CreneauMedecinJour implements Serializable {
	private static final long serialVersionUID = 1L;
	private Creneau creneau;
	private Rv rv;

	public CreneauMedecinJour() {
	}

	public CreneauMedecinJour(Creneau creneau, Rv rv) {
		this.creneau = creneau;
		this.rv = rv;
	}

	public Creneau getCreneau() {
		return this.creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public Rv getRv() {
		return this.rv;
	}

	public void setRv(Rv rv) {
		this.rv = rv;
	}
}
