package com.rdvmedecin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Medecin;

/**
 * 
 * @author SKAN
 * 
 */
public class PostAjoutRv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jour;
	private int hDebut;
	private int hFin;
	private int mDebut;
	private int mFin;
	private Client client;
	private Medecin medecin;

	/*
	 * Constructor
	 */

	/**
	 * 
	 */
	public PostAjoutRv() {
	}

	
	/**
	 * @param jour
	 * @param hDebut
	 * @param hFin
	 * @param mDebut
	 * @param mFin
	 * @param medecin
	 * @param client
	 */
	@JsonCreator
	public PostAjoutRv(@JsonProperty("jour")String jour,@JsonProperty("hDebut")int hDebut, @JsonProperty("hFin")int hFin, @JsonProperty("mDebut")int mDebut, @JsonProperty("mFin")int mFin,@JsonProperty("client") Client client,@JsonProperty("medecin")Medecin medecin) {
		super();
		this.jour = jour;
		this.hDebut = hDebut;
		this.hFin = hFin;
		this.mDebut = mDebut;
		this.mFin = mFin;
		this.medecin = medecin;
		this.client = client;
	}


	/*
	 * Getter and setter
	 */
	/**
	 * @return the jour
	 */
	public String getJour() {
		return jour;
	}

	/**
	 * @param jour
	 *            the jour to set
	 */
	public void setJour(String jour) {
		this.jour = jour;
	}

	/**
	 * @return the hDebut
	 */
	public int gethDebut() {
		return hDebut;
	}

	/**
	 * @param hDebut
	 *            the hDebut to set
	 */
	public void sethDebut(int hDebut) {
		this.hDebut = hDebut;
	}

	/**
	 * @return the hFin
	 */
	public int gethFin() {
		return hFin;
	}

	/**
	 * @param hFin
	 *            the hFin to set
	 */
	public void sethFin(int hFin) {
		this.hFin = hFin;
	}

	/**
	 * @return the mDebut
	 */
	public int getmDebut() {
		return mDebut;
	}

	/**
	 * @param mDebut
	 *            the mDebut to set
	 */
	public void setmDebut(int mDebut) {
		this.mDebut = mDebut;
	}

	/**
	 * @return the mFin
	 */
	public int getmFin() {
		return mFin;
	}

	/**
	 * @param mFin
	 *            the mFin to set
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
	 * @param medecin
	 *            the medecin to set
	 */
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
