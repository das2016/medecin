package com.rdvmedecin.controller;

import java.util.Date;
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

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Rv;
import com.rdvmedecin.model.PostAjoutRv;
import com.rdvmedecin.service.CreneauService;
import com.rdvmedecin.service.MedecinService;
import com.rdvmedecin.service.RvService;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@RequestMapping("/rv")
@RestController
public class RvController {

	private static Logger LOGGER = LoggerFactory.getLogger(RvController.class);

	@Autowired
	RvService rvService;
	@Autowired
	MedecinService medecinService;
	@Autowired
	CreneauService creneauService;

	// /**
	// * Add new rv
	// *
	// * @param rv
	// */
	// @RequestMapping(value = "/addRv", method = RequestMethod.POST)
	// public @ResponseBody void ajouterRv(@RequestBody Rv rv) {
	// try {
	// if (rv != null) {
	// rvService.addRendezVous(rv);
	// } else {
	// throw new Exception("Cannot add a null rv");
	// }
	// } catch (Exception e) {
	// LOGGER.error(" " + e.getMessage());
	// }
	// }

	/**
	 * Add new rv
	 * 
	 * @param rv
	 */
	@RequestMapping(value = "/addRv", method = RequestMethod.POST, produces = { "application/json" })
	public @ResponseBody void ajouterRv(@RequestBody PostAjoutRv rv) {
		try {
			if (rv != null) {
				Creneau creneau = new Creneau(rv.gethDebut(), rv.getmDebut(), rv.gethFin(), rv.getmFin(),
						rv.getMedecin());
				Client client = rv.getClient();
				rvService.addRendezVous(new Date(), creneau, client);
			} else {
				throw new Exception("Cannot add a null rv");
			}
		} catch (Exception e) {
			LOGGER.error(" " + e.getMessage());
		}
	}

	/**
	 * Get all rv
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rvs", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody List<Rv> getAllRv() {
		LOGGER.info("Get All Medecin");
		return rvService.getAllRv();
	}

	/**
	 * update rv
	 * 
	 * @param rv
	 */
	@RequestMapping(value = "/updateRv", method = RequestMethod.PUT)
	public @ResponseBody void modifierRv(@RequestBody Rv rv) {
		// same here saveOrUpdate
		// ajouterRv(rv);
	}

	/**
	 * delete rv
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/deleteRv/{id}", method = RequestMethod.DELETE)
	public void supprimerRv(@PathVariable long id) {
		try {
			Rv rv = rvService.getRvById(id);
			if (rv != null) {
				rvService.deleteRendezVous(rv);
			} else {
				throw new Exception("cannot delete null rv");
			}
		} catch (Exception e) {
			LOGGER.error(" " + e.getMessage());
		}
	}
}