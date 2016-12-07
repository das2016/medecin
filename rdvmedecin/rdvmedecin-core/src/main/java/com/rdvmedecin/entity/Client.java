package com.rdvmedecin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author SKAN
 * 
 */
@Entity
@Table(name = "CLIENT")
public class Client extends Personne {

	private static final long serialVersionUID = 1L;
	@Column(name = "DATE_NAISSANCE")
	private Date dateNaissance;

	/*
	 * Constructor
	 */

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param titre
	 * @param nom
	 * @param prenom
	 */
	public Client(String titre, String nom, String prenom) {
		super(titre, nom, prenom);
	}

	/**
	 * @param dateNaissance
	 */
	public Client(String titre, String nom, String prenom, Date dateNaissance) {
		super(titre, nom, prenom);
		this.dateNaissance = dateNaissance;
	}

	/*
	 * Getter and setter
	 */

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
