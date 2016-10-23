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

	public Personne() {
	}

	public Personne(Long id, Long version) {
		super(id, version);
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(String titre, String nom, String prenom) {
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
