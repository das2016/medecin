package com.rdvmedecin.entity;

import java.io.IOException;

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
@Table(name = "MEDECIN")
public class Medecin extends Personne {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="TELEPHONE")
	private Long numTel;

	/**
	 * 
	 */
	public Medecin() {
	}

	/**
	 * 
	 * @param titre
	 * @param nom
	 * @param prenom
	 */
	public Medecin(String titre, String nom, String prenom) {
		super(titre, nom, prenom);
	}
//	
//	/**
//	 * 
//	 * @param json
//	 */
//	public Medecin(String json){
//		System.err.println("Invoke Medecin Constructor");
//	}
	
	/**
	 * 
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@JsonCreator
	public static Medecin Create(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Medecin medecin = null;
		medecin = mapper.readValue(jsonString, Medecin.class);
		return medecin;
	}

	
	/*
	 * Getter and setter
	 */

	/**
	 * @return the numTel
	 */
	public Long getNumTel() {
		return numTel;
	}

	/**
	 * @param numTel the numTel to set
	 */
	public void setNumTel(Long numTel) {
		this.numTel = numTel;
	}
	
}
