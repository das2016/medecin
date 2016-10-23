package com.rdvmedecin.dao;

import java.util.List;

import com.rdvmedecin.entity.Creneau;
/**
 * 
 * @author SKAN
 *
 */
public interface CreneauDao extends DaoBaseMethod<Creneau> {
	
	/**
	 * 
	 * @param paramLong
	 * @return
	 */
	List<Creneau> getAllCreneaux(long paramLong);

	/**
	 * 
	 * @param paramLong
	 * @return
	 */
	Creneau findById(long paramLong);
}
