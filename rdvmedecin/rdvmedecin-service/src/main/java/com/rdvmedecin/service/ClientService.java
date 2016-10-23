package com.rdvmedecin.service;

import java.util.List;

import com.rdvmedecin.entity.Client;

/**
 * 
 * @author SKAN
 * 
 */
public interface ClientService {
	/**
	 * Get All Client
	 * 
	 * @return
	 */
	List<Client> getAllClient();

	/**
	 * Add Client
	 * 
	 * @param paramClient
	 * @return
	 */
	Client addClient(Client paramClient);

	/**
	 * delete client
	 * 
	 * @param paramClient
	 */
	void deleteClient(Client paramClient);

	/**
	 * Find Client By Id
	 * 
	 * @param paramLong
	 * @return
	 */
	Client findById(long paramLong);
}
