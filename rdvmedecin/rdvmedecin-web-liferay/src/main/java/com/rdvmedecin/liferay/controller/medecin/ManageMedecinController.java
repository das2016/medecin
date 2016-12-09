package com.rdvmedecin.liferay.controller.medecin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.service.MedecinService;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@Controller(value = "manageMedecinController")
@Scope("view")
public class ManageMedecinController implements Serializable {

	/**
	 * static field
	 */
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = LoggerFactory.getLogger(ManageMedecinController.class);
	/**
	 * instance var
	 */
	private Medecin medecin;
	private List<Medecin> medecins;
	/**
	 * @autowiring
	 */
	@Autowired
	private MedecinService medecinService;

	/**
	 * Constructor
	 */
	public ManageMedecinController() {
		super();
	}

	/**
	 * init method
	 */
	@PostConstruct
	public void init() {
		medecin = new Medecin();
		medecins = medecinService.getAllMedecin();
		LOGGER.info("Size of Medecin List : " + medecins.size());
	}

	/*
	 * Getter and Setter
	 */
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
	 * @return the medecins
	 */
	public List<Medecin> getMedecins() {
		return medecins;
	}

	/**
	 * @param medecins
	 *            the medecins to set
	 */
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

}
