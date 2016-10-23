package com.rdvmedecin.dao;

import com.rdvmedecin.entity.Client;

/**
 * 
 * @author SKAN
 * 
 */
public interface ClientDao extends DaoBaseMethod<Client> {
	/**
	 * Find Client By Id
	 * 
	 * @param paramLong
	 * @return
	 */
	Client findById(long paramLong);
}
