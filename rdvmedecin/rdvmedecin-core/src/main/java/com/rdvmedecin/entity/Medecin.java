package com.rdvmedecin.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author SKAN
 * 
 */
@Entity
@Table(name = "MEDECIN")
public class Medecin extends Personne {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Medecin() {
	}

	/**
	 * 
	 * @param titre
	 * @param nom
	 * @param prenom
	 */
	public Medecin(String titre, String nom, String prenom) {
		super(titre, nom, prenom);
	}
}
