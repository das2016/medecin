package com.rdvmedecin.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENT", nullable=true)
	private Client client;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CRENEAU",nullable=true)
	private Creneau creneau;
//	@Column(name = "ID_CLIENT", insertable = false)
//	private long idClient;
//	@Column(name = "ID_CRENEAU", insertable = false)
//	private long idCreneau;

	public Rv() {
	}

	public Rv(Date jour, Client client, Creneau creneau) {
		this.jour = jour;
		this.client = client;
		this.creneau = creneau;
	}

	public Date getJour() {
		return this.jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Creneau getCreneau() {
		return this.creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

//	public long getIdClient() {
//		return this.idClient;
//	}
//
//	public void setIdClient(long idClient) {
//		this.idClient = idClient;
//	}
//
//	public long getIdCreneau() {
//		return this.idCreneau;
//	}
//
//	public void setIdCreneau(long idCreneau) {
//		this.idCreneau = idCreneau;
//	}
}
