package com.rdvmedecin.service;

import java.util.Date;
import java.util.List;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Rv;

/**
 * 
 * @author SKAN
 * 
 */
public interface RvService {

	/**
	 * Get all Rendez Vous
	 * 
	 * @return
	 */
	List<Rv> getAllRv();

	/**
	 * Add Rendez Vous
	 * 
	 * @param paramRv
	 * @return
	 */
	Rv addRendezVous(Rv paramRv);

	/**
	 * Add Rendez vous (override)
	 * 
	 * @param paramDate
	 * @param paramCreneau
	 * @param paramClient
	 * @return
	 */
	Rv addRendezVous(Date paramDate, Creneau paramCreneau, Client paramClient);

	/**
	 * Delete rendez Vous
	 * 
	 * @param paramRv
	 */
	void deleteRendezVous(Rv paramRv);

	/**
	 * Get rendez vous by medecin Id and date
	 * 
	 * @param paramLong
	 * @param paramDate
	 * @return
	 */
	List<Rv> getRvMedecinJour(long medecinId, Date date);

	/**
	 * Get Rv By Id
	 * 
	 * @param paramLong
	 * @return
	 */
	Rv getRvById(long paramLong);
}
