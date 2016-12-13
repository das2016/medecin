package com.rdvmedecin.entity;

import java.io.IOException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
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
	public Client(String nom, String prenom, String adresse, Date dateNaissance) {
		super(nom, prenom, adresse);
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Json Create Method
	 * 
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@JsonCreator
	public static Client Create(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Client client = null;
		client = mapper.readValue(jsonString, Client.class);
		return client;
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
