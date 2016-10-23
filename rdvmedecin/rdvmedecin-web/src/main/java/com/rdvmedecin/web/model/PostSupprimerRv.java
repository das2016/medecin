package com.rdvmedecin.web.model;
/**
 * 
 * @author SKAN
 *
 */
public class PostSupprimerRv {

	private long idRv;

	/*
	 * Constructor
	 */
	
	/**
	 * 
	 */
	public PostSupprimerRv() {
		super();
	}


	/**
	 * @param idRv
	 */
	public PostSupprimerRv(long idRv) {
		super();
		this.idRv = idRv;
	}

	/*
	 * Getter and setter
	 */

	/**
	 * @return the idRv
	 */
	public long getIdRv() {
		return idRv;
	}


	/**
	 * @param idRv the idRv to set
	 */
	public void setIdRv(long idRv) {
		this.idRv = idRv;
	}
	
}
