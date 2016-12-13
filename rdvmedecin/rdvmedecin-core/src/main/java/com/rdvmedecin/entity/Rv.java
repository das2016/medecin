package com.rdvmedecin.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author SKAN
 * 
 */
@Entity
@Table(name = "RV")
public class Rv extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date jour;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "ID_CLIENT", nullable = true)
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "ID_CRENEAU", nullable = true)
	private Creneau creneau;
	// @Column(name = "ID_CLIENT", insertable = false)
	// private long idClient;
	// @Column(name = "ID_CRENEAU", insertable = false)
	// private long idCreneau;

	/**
	 * 
	 */
	public Rv() {
	}

	/**
	 * 
	 * @param jour
	 * @param client
	 * @param creneau
	 */
	public Rv(Date jour, Client client, Creneau creneau) {
		this.jour = jour;
		this.client = client;
		this.creneau = creneau;
	}
	
	/*
	 * Getter and setter
	 */

	/**
	 * @return the jour
	 */
	public Date getJour() {
		return jour;
	}

	/**
	 * @param jour the jour to set
	 */
	public void setJour(Date jour) {
		this.jour = jour;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the creneau
	 */
	public Creneau getCreneau() {
		return creneau;
	}

	/**
	 * @param creneau the creneau to set
	 */
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

}
