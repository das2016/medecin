package com.rdvmedecin.service;

import java.util.List;

import com.rdvmedecin.entity.Creneau;

/**
 * 
 * @author SKAN
 * 
 */
public interface CreneauService {
	/**
	 * Get ALL Crenau By Medecin Id
	 * 
	 * @param paramLong
	 * @return
	 */
	List<Creneau> getAllCrenauByMedecin(long idMedecin);

	/**
	 * Find Creneau By Id
	 * 
	 * @param idCreneau
	 * @return
	 */
	Creneau findCrenauById(long idCreneau);

	/**
	 * Add Crenau
	 * 
	 * @param creneau
	 * @return
	 */
	Creneau addCReneau(Creneau creneau);
}
