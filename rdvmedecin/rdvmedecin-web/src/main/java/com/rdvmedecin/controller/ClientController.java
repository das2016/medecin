package com.rdvmedecin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.service.ClientService;

/**
 * 
 * @author SKAN
 * 
 */
@RequestMapping("/client")
@RestController
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;

	/**
	 * Get All client
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/clients" }, method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Client>> getAllClient() {
		List<Client> clients = clientService.getAllClient();
		if (clients.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	/**
	 * Add New Client
	 * 
	 * @param client
	 * @throws Exception
	 */
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public @ResponseBody void addClient(@RequestBody Client client) {
		try {
			if (client != null) {
				clientService.addClient(client);
			} else {
				throw new Exception("Cannot add a null Client");
			}
		} catch (Exception e) {
			LOGGER.error(" " + e.getMessage());
		}
	}

	/**
	 * Delete Client
	 * 
	 * @param client
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable long id) throws Exception {
		Client client = clientService.findById(id);
		if (client != null) {
			clientService.deleteClient(client);
		} else {
			LOGGER.error("Cannot delet a null client");
			throw new Exception("Cannot delete a null client");
		}
	}

	/**
	 * Update Client
	 * 
	 * @param client
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateClient", method = RequestMethod.PUT)
	public @ResponseBody void updateClient(@RequestBody Client client) throws Exception {
		if (client != null) {
			/*
			 * we used saveOrUpdate method in the addClient method service
			 */
			LOGGER.info("Update Client ::::::::::::::::::> " + client.getId());
			clientService.addClient(client);
		} else {
			LOGGER.error("Cannot update a null client");
			throw new Exception("Cannot update a null Client");
		}
	}

}
