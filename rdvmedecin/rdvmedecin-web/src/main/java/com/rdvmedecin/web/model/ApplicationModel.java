package com.rdvmedecin.web.model;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.entity.Rv;
import com.rdvmedecin.model.AgendaMedecinJour;
import com.rdvmedecin.service.ClientService;
import com.rdvmedecin.service.CreneauService;
import com.rdvmedecin.service.MedecinService;
import com.rdvmedecin.service.RvService;
import com.rdvmedecin.web.util.Static;

/**
 * 
 * @author SKAN
 * 
 */
@Component("applicationModel")
public class ApplicationModel implements ClientService, MedecinService,
		RvService, CreneauService {

	private List<Medecin> medecins;
	private List<Client> clients;
	private List<String> messages;

	@Autowired
	ClientService clientService;
	@Autowired
	MedecinService medecinService;
	@Autowired
	RvService rvService;
	@Autowired
	CreneauService creneauService;

	/**
	 * Init Method
	 */
	@PostConstruct
	public void init() {
		try {
			this.medecins = this.medecinService.getAllMedecin();
			this.clients = this.clientService.getAllClient();
		} catch (Exception e) {
			this.messages = Static.getErreursForException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.CreneauService#getAllCrenauByMedecin(long)
	 */
	public List<Creneau> getAllCrenauByMedecin(long idMedecin) {
		return this.creneauService.getAllCrenauByMedecin(idMedecin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#getAllRv()
	 */
	public List<Rv> getAllRv() {
		return this.rvService.getAllRv();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.RvService#addRendezVous(com.rdvmedecin.entity.Rv)
	 */
	public Rv addRendezVous(Rv rv) {
		return this.rvService.addRendezVous(rv);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#addRendezVous(java.util.Date,
	 * com.rdvmedecin.entity.Creneau, com.rdvmedecin.entity.Client)
	 */
	public Rv addRendezVous(Date jour, Creneau creneau, Client client) {
		return this.rvService.addRendezVous(jour, creneau, client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.RvService#deleteRendezVous(com.rdvmedecin.entity
	 * .Rv)
	 */
	public void deleteRendezVous(Rv rv) {
		this.rvService.deleteRendezVous(rv);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#getRvMedecinJour(long,
	 * java.util.Date)
	 */
	public List<Rv> getRvMedecinJour(long idMedecin, Date jour) {
		return this.rvService.getRvMedecinJour(idMedecin, jour);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.MedecinService#getAllMedecin()
	 */
	public List<Medecin> getAllMedecin() {
		return this.medecins;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.MedecinService#addMedecin(com.rdvmedecin.entity
	 * .Medecin)
	 */
	public Medecin addMedecin(Medecin medecin) {
		return this.medecinService.addMedecin(medecin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.MedecinService#deleteMedecin(com.rdvmedecin.entity
	 * .Medecin)
	 */
	public void deleteMedecin(Medecin medecin) {
		this.medecinService.deleteMedecin(medecin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.MedecinService#getMedecinById(long)
	 */
	public Medecin getMedecinById(long id) {
		return this.medecinService.getMedecinById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.MedecinService#getAgendaMedecinJour(long,
	 * java.util.Date)
	 */
	public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour) {
		return this.medecinService.getAgendaMedecinJour(idMedecin, jour);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.ClientService#getAllClient()
	 */
	public List<Client> getAllClient() {
		return this.clients;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.ClientService#addClient(com.rdvmedecin.entity.
	 * Client)
	 */
	public Client addClient(Client client) {
		return this.clientService.addClient(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.ClientService#deleteClient(com.rdvmedecin.entity
	 * .Client)
	 */
	public void deleteClient(Client client) {
		this.clientService.deleteClient(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.ClientService#findById(long)
	 */
	public Client findById(long id) {
		return this.clientService.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.CreneauService#findCrenauById(long)
	 */
	public Creneau findCrenauById(long id) {
		return this.creneauService.findCrenauById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.CreneauService#addCReneau(com.rdvmedecin.entity
	 * .Creneau)
	 */
	public Creneau addCReneau(Creneau creneau) {
		return this.creneauService.addCReneau(creneau);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#getRvById(long)
	 */
	public Rv getRvById(long id) {
		return this.rvService.getRvById(id);
	}

	/*
	 * Getter and setter
	 */

	/**
	 * @return the medecins
	 */
	public List<Medecin> getMedecins() {
		return medecins;
	}

	/**
	 * @param medecins
	 *            the medecins to set
	 */
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
