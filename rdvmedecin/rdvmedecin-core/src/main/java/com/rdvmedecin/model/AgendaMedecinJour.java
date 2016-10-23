package com.rdvmedecin.model;

import java.io.Serializable;
import java.util.Date;

import com.rdvmedecin.entity.Medecin;

/**
 * 
 * @author SKAN
 * 
 */
public class AgendaMedecinJour implements Serializable {
	private static final long serialVersionUID = 1L;
	private Medecin medecin;
	private Date jour;
	private CreneauMedecinJour[] creneauxMedecinJours;

	public AgendaMedecinJour() {
	}

	public AgendaMedecinJour(Medecin medecin, Date jour,
			CreneauMedecinJour[] creneauMedecinJours) {
		this.medecin = medecin;
		this.jour = jour;
		this.creneauxMedecinJours = creneauMedecinJours;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Date getJour() {
		return this.jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public CreneauMedecinJour[] getCreneauxMedecinJours() {
		return this.creneauxMedecinJours;
	}

	public void setCreneauxMedecinJours(
			CreneauMedecinJour[] creneauxMedecinJours) {
		this.creneauxMedecinJours = creneauxMedecinJours;
	}
}
