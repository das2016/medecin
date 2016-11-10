package com.rdvmedecin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.service.MedecinService;

/**
 * 
 * @author SKAN
 * 
 */
@RequestMapping("/medecin")
@RestController
public class MedecinController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MedecinController.class);

	@Autowired
	private MedecinService medecinService;

	/**
	 * Get All Medecin
	 * 
	 * @return
	 */
	@RequestMapping(value = "/medecins", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody
	List<Medecin> getAllMedecin() {
		LOGGER.info("Get All Medecin");
		return medecinService.getAllMedecin();
	}

	/**
	 * Add Medecin Service
	 * 
	 * @param medecin
	 */
	@RequestMapping(value = "/addMedecin", method = RequestMethod.POST, produces = { "application/json" })
	public @ResponseBody
	void addMedecin(@RequestBody Medecin medecin) {
		if (medecin != null) {
			medecinService.addMedecin(medecin);
		}else{
			LOGGER.error("Cannot add medecin with null params");
		}
	}

	/**
	 * Update medecin
	 * 
	 * @param medecin
	 */
	@RequestMapping(value = "/updateMedecin", method = RequestMethod.PUT, produces = { "application/json" })
	public @ResponseBody
	void updateMedecin(@RequestBody Medecin medecin) {
		if (medecin != null) {
			medecinService.addMedecin(medecin);
		}else{
			LOGGER.error("Cannot update medecin with null params");
		}
	}

	/**
	 * Delete medecin
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/deleteMedecin/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public void deleteMedecin(@PathVariable int id) {
		Medecin medecin = medecinService.getMedecinById(id);
		if (medecin != null) {
			medecinService.deleteMedecin(medecin);
		} else {
			LOGGER.error("Cannot delete medecin with null param");
		}
	}

}
