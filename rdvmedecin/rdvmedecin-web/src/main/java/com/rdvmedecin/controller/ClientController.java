package com.rdvmedecin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.service.ClientService;
import com.rdvmedecin.web.model.ApplicationModel;

/**
 * 
 * @author SKAN
 * 
 */
@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private ApplicationModel applicationModel;

	/**
	 * Get All client
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/clients" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public List<Client> getAllClient() {
		return this.clientService.getAllClient();
	}
}
