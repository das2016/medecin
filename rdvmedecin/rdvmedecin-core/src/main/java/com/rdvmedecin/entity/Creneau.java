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
	@ManyToOne(fetch = FetchType.LAZY, cascade={CascadeType.MERGE})
	@JoinColumn(name = "ID_MEDECIN",nullable=false)
	private Medecin medecin;

	/*
	 * Constructor
	 */
	
	/**
	 * 
	 */
	public Creneau() {
		
	}

	/**
	 * 
	 * @param hDebut
	 * @param mDebut
	 * @param hFin
	 * @param mFin
	 * @param medecin
	 */
	public Creneau(int hDebut, int mDebut, int hFin, int mFin, Medecin medecin) {
		this.hDebut = hDebut;
		this.mDebut = mDebut;
		this.hFin = hFin;
		this.mFin = mFin;
		this.medecin = medecin;
	}
	
	/*
	 * Getter and setter
	 */

	/**
	 * @return the hDebut
	 */
	public int gethDebut() {
		return hDebut;
	}

	/**
	 * @param hDebut the hDebut to set
	 */
	public void sethDebut(int hDebut) {
		this.hDebut = hDebut;
	}

	/**
	 * @return the mDebut
	 */
	public int getmDebut() {
		return mDebut;
	}

	/**
	 * @param mDebut the mDebut to set
	 */
	public void setmDebut(int mDebut) {
		this.mDebut = mDebut;
	}

	/**
	 * @return the hFin
	 */
	public int gethFin() {
		return hFin;
	}

	/**
	 * @param hFin the hFin to set
	 */
	public void sethFin(int hFin) {
		this.hFin = hFin;
	}

	/**
	 * @return the mFin
	 */
	public int getmFin() {
		return mFin;
	}

	/**
	 * @param mFin the mFin to set
	 */
	public void setmFin(int mFin) {
		this.mFin = mFin;
	}

	/**
	 * @return the medecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}

	/**
	 * @param medecin the medecin to set
	 */
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
}
