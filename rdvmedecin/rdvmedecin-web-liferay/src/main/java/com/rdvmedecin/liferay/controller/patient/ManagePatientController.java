package com.rdvmedecin.liferay.controller.patient;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.service.ClientService;
/**
 * 
 * @author Skander.Bachouche
 *
 */
@Controller("managePatientController")
@Scope("view")
public class ManagePatientController implements Serializable {

	/**
	 * static var
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagePatientController.class);
	/**
	 * instance var
	 */
	private Client patient;
	private List<Client> clients;
	/**
	 * autowiring mode
	 */
	@Autowired
	private ClientService clientService;
	
	/*
	 * constructor
	 */
	public ManagePatientController(){
		super();
	}
	
	/**
	 * init method
	 */
	public void init(){
		patient = new Client();
		clients = clientService.getAllClient();
	}
	/**
	 * method for jsf action
	 */

	
	/**
	 * public method
	 */
	
	/**
	 * private method
	 */
	
	/*
	 * Getter and setter
	 */
	
	/**
	 * @return the patient
	 */
	public Client getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Client patient) {
		this.patient = patient;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
