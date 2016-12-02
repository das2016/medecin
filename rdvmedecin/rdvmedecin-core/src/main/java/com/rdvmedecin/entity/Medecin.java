package com.rdvmedecin.entity;

import javax.persistence.Column;
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
	
	@Column(name="TELEPHONE")
	private Long numTel;

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
	
	/*
	 * Getter and setter
	 */

	/**
	 * @return the numTel
	 */
	public Long getNumTel() {
		return numTel;
	}

	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(Long numTel) {
		this.numTel = numTel;
	}
	
}
