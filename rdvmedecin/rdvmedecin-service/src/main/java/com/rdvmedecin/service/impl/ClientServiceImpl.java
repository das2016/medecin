package com.rdvmedecin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.service.ClientService;
import com.rdvmedecin.springdatajpa.SpringDataClientDao;

/**
 * 
 * @author SKAN
 * 
 */
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	@Autowired
	SpringDataClientDao clientDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.ClientService#getAllClient()
	 */
	public List<Client> getAllClient() {
		List<Client> clients = this.clientDao.findAll();
		LOGGER.debug("All Client List : " + clients.size());
		return clients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.ClientService#addClient(com.rdvmedecin.entity.
	 * Client)
	 */
	public Client addClient(Client client) {
		LOGGER.debug("saveOrUpdate Client : " + client.getNom() + " " + client.getPrenom());
		return (Client) this.clientDao.save(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.ClientService#deleteClient(com.rdvmedecin.entity
	 * .Client)
	 */
	public void deleteClient(Client client) {
		LOGGER.debug("Delete Client : " + client.getNom() + " " + client.getPrenom());
		this.clientDao.delete(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.ClientService#findById(long)
	 */
	public Client findById(long id) {
		return this.clientDao.findById(id);
	}
}
