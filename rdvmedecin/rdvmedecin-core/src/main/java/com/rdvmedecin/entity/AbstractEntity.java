package com.rdvmedecin.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
/**
 * 
 * @author SKAN
 *
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Version
	private Long version;

	/*
	 * Constructor
	 */
	
	/**
	 * 
	 */
	public AbstractEntity() {
		super();
	}
	
	
	/**
	 * @param id
	 * @param version
	 */
	public AbstractEntity(Long id, Long version) {
		super();
		this.id = id;
		this.version = version;
	}
	

	/*
	 * Getter and setter
	 */
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

}
