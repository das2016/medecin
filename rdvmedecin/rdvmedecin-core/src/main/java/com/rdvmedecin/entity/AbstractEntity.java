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

	public AbstractEntity() {
	}

	public AbstractEntity(Long id, Long version) {
		this.id = id;
		this.version = version;
	}

	public AbstractEntity build(Long id, Long version) {
		this.id = id;
		this.version = version;
		return this;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
