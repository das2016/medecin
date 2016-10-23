package com.rdvmedecin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.entity.Rv;
import com.rdvmedecin.model.Response;
import com.rdvmedecin.web.model.ApplicationModel;
import com.rdvmedecin.web.model.PostAjouterRv;
import com.rdvmedecin.web.model.PostSupprimerRv;
import com.rdvmedecin.web.util.Static;

/**
 * 
 * @author SKAN
 * 
 */
@RestController
public class RdvMedecinController {

	@Autowired
	ApplicationModel applicationModel;
	List<String> messages;

	/**
	 * init method
	 */
	@PostConstruct
	public void init() {
		this.messages = this.applicationModel.getMessages();
	}

	/**
	 * Get all medecin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/getAllMedecins" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getAllMedecin() {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		try {
			return new Response(0, this.applicationModel.getAllMedecin());
		} catch (Exception e) {
			return new Response(1, Static.getErreursForException(e));
		}
	}

	/**
	 * Get all client
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/getAllClients" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getAllClient() {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		try {
			return new Response(0, this.applicationModel.getAllClient());
		} catch (Exception exception) {
			return new Response(1, Static.getErreursForException(exception));
		}
	}

	/**
	 * Get Client BY ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/getClientById/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getClientById(@PathVariable("id") long id) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		return getClient(id);
	}

	/**
	 * Get Creneau By Id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/getCreneauById/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getCreneauById(@PathVariable("id") long id) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		Response reponse = getCreneau(id);
		if (reponse.getStatus() == 0) {
			reponse.setData(Static.getMapForCreneau((Creneau) reponse.getData()));
		}
		return reponse;
	}

	/**
	 * Get Rv By Id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/getRvById/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getRvById(@PathVariable("id") long id) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		Response reponse = getRv(id);
		if (reponse.getStatus() == 0) {
			reponse.setData(Static.getMapForRv2((Rv) reponse.getData()));
		}
		return reponse;
	}

	/**
	 * Get All Creneaux
	 * 
	 * @param idMedecin
	 * @return
	 */
	@RequestMapping(value = { "/getAllCreneaux/{idMedecin}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getAllCreneaux(@PathVariable("idMedecin") long idMedecin) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		Response response = getMedecin(idMedecin);
		if (response.getStatus() != 0) {
			return response;
		}
		Medecin medecin = (Medecin) response.getData();

		List<Creneau> crenaux = null;
		try {
			crenaux = this.applicationModel.getAllCrenauByMedecin(medecin
					.getId().longValue());
		} catch (Exception e1) {
			return new Response(3, Static.getErreursForException(e1));
		}
		return new Response(0, Static.getListMapForCreneaux(crenaux));
	}

	/**
	 * Get Rendez Vous by Medecin Id and date
	 * 
	 * @param idMedecin
	 * @param jour
	 * @return
	 */
	@RequestMapping(value = { "/getRvMedecinJour/{idMedecin}/{jour}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Response getRvMedecinJour(@PathVariable("idMedecin") long idMedecin,
			@PathVariable("jour") String jour) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		Date jourAgenda = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			jourAgenda = sdf.parse(jour);
		} catch (ParseException e) {
			return new Response(3, null);
		}
		Response reponse = getMedecin(idMedecin);
		if (reponse.getStatus() != 0) {
			return reponse;
		}
		Medecin medecin = (Medecin) reponse.getData();

		List<Rv> rvs = null;
		try {
			rvs = this.applicationModel.getRvMedecinJour(medecin.getId()
					.longValue(), jourAgenda);
		} catch (Exception e1) {
			return new Response(4, Static.getErreursForException(e1));
		}
		return new Response(0, Static.getListMapForRvs(rvs));
	}

	/**
	 * Add Rv
	 * 
	 * @param post
	 * @return
	 */
	@RequestMapping(value = { "/ajouterRv" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST }, consumes = { "application/json;charset=UTF-8" })
	public Response ajouterRv(@RequestBody PostAjouterRv post) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		String jour = post.getJour();
		long idCreneau = post.getIdCreneau();
		long idClient = post.getIdClient();

		Date jourAgenda = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			jourAgenda = sdf.parse(jour);
		} catch (ParseException e) {
			return new Response(6, null);
		}
		Response reponse = getCreneau(idCreneau);
		if (reponse.getStatus() != 0) {
			return reponse;
		}
		Creneau créneau = (Creneau) reponse.getData();

		reponse = getClient(idClient);
		if (reponse.getStatus() != 0) {
			reponse.incrStatusBy(2);
			return reponse;
		}
		Client client = (Client) reponse.getData();

		Rv rv = null;
		try {
			rv = this.applicationModel.addRendezVous(jourAgenda, créneau,
					client);
		} catch (Exception e1) {
			return new Response(5, Static.getErreursForException(e1));
		}
		return new Response(0, Static.getMapForRv(rv));
	}

	/**
	 * Delete Rv
	 * 
	 * @param post
	 * @return
	 */
	@RequestMapping(value = { "/supprimerRv" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST }, consumes = { "application/json;charset=UTF-8" })
	public Response supprimerRv(@RequestBody PostSupprimerRv post) {
		if (this.messages != null) {
			return new Response(-1, this.messages);
		}
		long idRv = post.getIdRv();

		Response reponse = getRv(idRv);
		if (reponse.getStatus() != 0) {
			return reponse;
		}
		try {
			this.applicationModel.deleteRendezVous((Rv) reponse.getData());
		} catch (Exception e1) {
			return new Response(3, Static.getErreursForException(e1));
		}
		return new Response(0, null);
	}

	/*
	 * Private method
	 */
	/**
	 * Get medecin By Id
	 * 
	 * @param id
	 * @return
	 */
	private Response getMedecin(long id) {
		Medecin medecin = null;
		try {
			medecin = this.applicationModel.getMedecinById(id);
		} catch (Exception e1) {
			return new Response(1, Static.getErreursForException(e1));
		}
		if (medecin == null) {
			return new Response(2, null);
		}
		return new Response(0, medecin);
	}

	/**
	 * Get Client by id
	 * 
	 * @param id
	 * @return
	 */
	private Response getClient(long id) {
		Client client = null;
		try {
			client = this.applicationModel.findById(id);
		} catch (Exception e1) {
			return new Response(1, Static.getErreursForException(e1));
		}
		if (client == null) {
			return new Response(2, null);
		}
		return new Response(0, client);
	}

	/**
	 * Get Creneau By Id
	 * 
	 * @param id
	 * @return
	 */
	private Response getCreneau(long id) {
		Creneau creneau = null;
		try {
			creneau = this.applicationModel.findCrenauById(id);
		} catch (Exception e1) {
			return new Response(1, Static.getErreursForException(e1));
		}
		if (creneau == null) {
			return new Response(2, null);
		}
		return new Response(0, creneau);
	}

	/**
	 * Get Rv By Id
	 * 
	 * @param id
	 * @return
	 */
	private Response getRv(long id) {
		Rv rv = null;
		try {
			rv = this.applicationModel.getRvById(id);
		} catch (Exception e1) {
			return new Response(1, Static.getErreursForException(e1));
		}
		if (rv == null) {
			return new Response(2, null);
		}
		return new Response(0, rv);
	}

	/*
	 * Getter and setter
	 */

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
