package com.rdvmedecin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author SKAN
 *
 */
@Entity
@Table(name = "CRENEAU")
public class Creneau extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "H_DEBUT")
	private int hDebut;
	@Column(name = "M_DEBUT")
	private int mDebut;
	@Column(name = "H_FIN")
	private int hFin;
	@Column(name = "M_FIN")
	private int mFin;
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name = "ID_MEDECIN",nullable=true)
	private Medecin medecin;

	public Creneau() {
	}

	public Creneau(int hDebut, int mDebut, int hFin, int mFin, Medecin medecin) {
		this.hDebut = hDebut;
		this.mDebut = mDebut;
		this.hFin = hFin;
		this.mFin = mFin;
		this.medecin = medecin;
	}

	public int gethDebut() {
		return this.hDebut;
	}

	public void sethDebut(int hDebut) {
		this.hDebut = hDebut;
	}

	public int getmDebut() {
		return this.mDebut;
	}

	public void setmDebut(int mDebut) {
		this.mDebut = mDebut;
	}

	public int gethFin() {
		return this.hFin;
	}

	public void sethFin(int hFin) {
		this.hFin = hFin;
	}

	public int getmFin() {
		return this.mFin;
	}

	public void setmFin(int mFin) {
		this.mFin = mFin;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
}
