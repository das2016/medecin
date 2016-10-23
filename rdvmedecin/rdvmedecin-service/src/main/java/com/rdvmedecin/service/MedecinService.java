package com.rdvmedecin.service;

import java.util.Date;
import java.util.List;

import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.model.AgendaMedecinJour;

/**
 * 
 * @author SKAN
 * 
 */
public interface MedecinService {

	/**
	 * Get All Medecin
	 * 
	 * @return
	 */
	List<Medecin> getAllMedecin();

	/**
	 * Add Medecin
	 * 
	 * @param paramMedecin
	 * @return
	 */
	Medecin addMedecin(Medecin paramMedecin);

	/**
	 * Delete medecin
	 * 
	 * @param paramMedecin
	 */
	void deleteMedecin(Medecin paramMedecin);

	/**
	 * Get Medecin By Id
	 * 
	 * @param paramLong
	 * @return
	 */
	Medecin getMedecinById(long paramLong);

	/**
	 * Get Agenda by Medecin Id and date
	 * 
	 * @param paramLong
	 * @param paramDate
	 * @return
	 */
	AgendaMedecinJour getAgendaMedecinJour(long medecinId, Date date);
}
