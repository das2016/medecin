package com.rdvmedecin.entity;

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

	public Client() {
	}

	public Client(String titre, String nom, String prenom) {
		super(titre, nom, prenom);
	}
}
