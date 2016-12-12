package com.rdvmedecin.entity;

import java.io.IOException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	}
	
	 public Client(String stringJSON){
		 ObjectMapper mapper = new ObjectMapper();
		 try {
			Client client = mapper.readValue(stringJSON, this.getClass());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	 } 

	/**
	 * @param titre
	 * @param nom
	 * @param prenom
	 */
	public Client(String adresse, String nom, String prenom) {
		super(adresse, nom, prenom);
	}
	

	/**
	 * @param dateNaissance
	 */
	public Client(Date dateNaissance) {
		super();
		this.dateNaissance = dateNaissance;
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
