package com.rdvmedecin.web.model;

/**
 * 
 * @author SKAN
 * 
 */
public class PostAjouterRv {

	private String jour;
	private int idCreneau;
	private int idClient;

	/*
	 * Constructor
	 */

	/**
	 * 
	 */
	public PostAjouterRv() {
		super();
	}

	/**
	 * @param jour
	 * @param idCreneau
	 * @param idClient
	 */
	public PostAjouterRv(String jour, int idCreneau, int idClient) {
		super();
		this.jour = jour;
		this.idCreneau = idCreneau;
		this.idClient = idClient;
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
	 * @return the idCreneau
	 */
	public int getIdCreneau() {
		return idCreneau;
	}

	/**
	 * @param idCreneau
	 *            the idCreneau to set
	 */
	public void setIdCreneau(int idCreneau) {
		this.idCreneau = idCreneau;
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient
	 *            the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
