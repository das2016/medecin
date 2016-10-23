package com.rdvmedecin.dao;

import com.rdvmedecin.entity.Medecin;

/**
 * 
 * @author SKAN
 * 
 */
public interface MedecinDao extends DaoBaseMethod<Medecin> {
	/**
	 * 
	 * @param paramLong
	 * @return
	 */
	Medecin findById(long paramLong);
}
