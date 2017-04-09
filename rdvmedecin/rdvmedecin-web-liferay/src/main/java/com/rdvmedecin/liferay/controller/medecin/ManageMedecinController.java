package com.rdvmedecin.liferay.controller.medecin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.service.ClientService;
import com.rdvmedecin.service.MedecinService;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@ManagedBean(name = "manageMedecinController")
@ViewScoped
public class ManageMedecinController implements Serializable {

	/**
	 * static field
	 */
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = LoggerFactory.getLogger(ManageMedecinController.class);
	/**
	 * instance var
	 */
	private int medecin;
	private int client;
	private boolean nextPage;
	private String price;
	private List<Medecin> medecins;
	private List<Client> clients;
	private List<SelectItem> medecinItems;
	private List<SelectItem> clientItems;
	/**
	 * @autowiring
	 */
	@ManagedProperty("#{medecinService}")
	private MedecinService medecinService;

	@ManagedProperty("#{clientService}")
	private ClientService clientService;

	/**
	 * Constructor
	 */
	public ManageMedecinController() {
		super();
	}

	/**
	 * init method
	 */
	@PostConstruct
	public void init() {
		medecins = medecinService.getAllMedecin();
		clients = new ArrayList<>();
		medecinItems = new ArrayList<>();
		initMedecinItems();
		LOGGER.info("Size of Medecin List : " + medecins.size());
		nextPage = false;
	}

	public void medecinListener() {
		System.out.println("Medecin selected is : " + medecin);
		initClientItems();
	}

	public void next() {
		System.out.println("Next");
		price = new String();
		nextPage = true;
	}

	public void priceListener(AjaxBehaviorEvent event) {
		System.out.println(" price listener : "+price);
		if (price.equals("AA")) {
			System.out.println("Afficher message");
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		}
	}

	public void priceListener(ValueChangeEvent event) {
		System.out.println(" price listener : "+price);
		if ("AA".equals(price)) {
			System.out.println("Afficher message");
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		}
	}
	
	public void priceListener() {
		System.out.println(" price listener : "+price);
		if (price.equals("AA")) {
			System.out.println("Afficher message");
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		}
	}

	public void test(){
		System.out.println("Message zebi");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
//		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO," Ajout effectué avec succès ", " ");
//		FacesContext.getCurrentInstance().addMessage(null, msg);

	}
	/*
	 * private method
	 */
	private List<SelectItem> initMedecinItems() {
		for (Medecin medecin : medecins) {
			medecinItems.add(new SelectItem(medecin.getId(), medecin.getNom()));
		}
		return medecinItems;
	}

	private List<SelectItem> initClientItems() {
		clients = clientService.getAllClient();
		clientItems = new ArrayList<>();
		if (medecin == 1) {
			clientItems.add(new SelectItem(clients.get(0).getId(), clients.get(0).getNom()));
		} else if (medecin == 2) {
			clientItems.add(new SelectItem(clients.get(1).getId(), clients.get(1).getNom()));
		} else{
			clientItems.clear();
		}
		return clientItems;
	}

	// private List<SelectItem>
	/*
	 * Getter and Setter
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

	// public MedecinService getMedecinService() {
	// return medecinService;
	// }
	//
	// public void setMedecinService(MedecinService medecinService) {
	// this.medecinService = medecinService;
	// }

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public int getMedecin() {
		return medecin;
	}

	public void setMedecin(int medecin) {
		this.medecin = medecin;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public MedecinService getMedecinService() {
		return medecinService;
	}

	public void setMedecinService(MedecinService medecinService) {
		this.medecinService = medecinService;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public List<SelectItem> getMedecinItems() {
		return medecinItems;
	}

	public void setMedecinItems(List<SelectItem> medecinItems) {
		this.medecinItems = medecinItems;
	}

	public List<SelectItem> getClientItems() {
		return clientItems;
	}

	public void setClientItems(List<SelectItem> clientItems) {
		this.clientItems = clientItems;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	


	// public ClientService getClientService() {
	// return clientService;
	// }
	//
	// public void setClientService(ClientService clientService) {
	// this.clientService = clientService;
	// }

}
