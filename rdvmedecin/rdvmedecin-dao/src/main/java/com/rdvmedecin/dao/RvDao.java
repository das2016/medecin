package com.rdvmedecin.dao;

import java.util.Date;

import com.rdvmedecin.entity.Rv;

/**
 * 
 * @author SKAN
 * 
 */
public interface RvDao extends DaoBaseMethod<Rv> {
	
	/**
	 * 
	 * @param paramLong
	 * @param paramDate
	 * @return
	 */
	Iterable<Rv> getRvMedecinJour(long paramLong, Date paramDate);

	/**
	 * 
	 * @param paramLong
	 * @return
	 */
	Rv findById(long paramLong);
}