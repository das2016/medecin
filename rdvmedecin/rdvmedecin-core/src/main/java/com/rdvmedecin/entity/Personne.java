package com.rdvmedecin.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 * 
 * @author SKAN
 *
 */
@MappedSuperclass
public class Personne extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "ADRESSE")
	private String adresse;

	/*
	 * Constructor
	 */
	
	/**
	 * 
	 */
	public Personne() {
	}

	/**
	 * 
	 * @param id
	 * @param version
	 */
	public Personne(Long id, Long version) {
		super(id, version);
	}

	/**
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * 
	 * @param titre
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom,String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	/*
	 * Getter and setter
	 */

	/**
	 * @return the titre
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
