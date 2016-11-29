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
	@Column(name = "TITRE")
	private String titre;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;

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
	public Personne(String titre, String nom, String prenom) {
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/*
	 * Getter and setter
	 */

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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
