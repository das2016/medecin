package com.rdvmedecin.liferay.controller.medecin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.service.ClientService;
import com.rdvmedecin.service.MedecinService;

@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {

	private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
	private String country;
	private String city;
	private Map<String, String> countries;
	private Map<String, String> cities;

	/**
	 * instance var
	 */
	private Medecin medecin;
	private Client client;
	private List<Medecin> medecins;
	private List<Client> clients;
	/**
	 * @autowiring
	 */
	@ManagedProperty("#{medecinService}")
	private MedecinService medecinService;

	@ManagedProperty("#{clientService}")
	private ClientService clientService;

	@PostConstruct
	public void init() {
		countries = new HashMap<String, String>();
		countries.put("USA", "USA");
		countries.put("Germany", "Germany");
		countries.put("Brazil", "Brazil");

		Map<String, String> map = new HashMap<String, String>();
		map.put("New York", "New York");
		map.put("San Francisco", "San Francisco");
		map.put("Denver", "Denver");
		data.put("USA", map);

		map = new HashMap<String, String>();
		map.put("Berlin", "Berlin");
		map.put("Munich", "Munich");
		map.put("Frankfurt", "Frankfurt");
		data.put("Germany", map);

		map = new HashMap<String, String>();
		map.put("Sao Paolo", "Sao Paolo");
		map.put("Rio de Janerio", "Rio de Janerio");
		map.put("Salvador", "Salvador");
		data.put("Brazil", map);

		client = new Client();
		medecin = new Medecin();
		medecins = medecinService.getAllMedecin();
		System.out.println("Size of Medecin List : " + medecins.size());
	}

	public Map<String, Map<String, String>> getData() {
		return data;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void onCountryChange() {
		if (country != null && !country.equals(""))
			cities = data.get(country);
		else
			cities = new HashMap<String, String>();
	}

	public void displayLocation() {
		FacesMessage msg;
		if (city != null && country != null)
			msg = new FacesMessage("Selected", city + " of " + country);
		else
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Medecin> getMedecins() {
		return medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
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

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

	public void medecinListener() {
		System.out.println("Medecin selected is : " + medecin.getNom());
		initOthers();
	}


	public void initOthers() {
		List<Client> listClient = clientService.getAllClient();
		if (medecin.getId() == 1) {
			clients.add(listClient.get(0));
		} else {
			clients.add(listClient.get(1));
		}
	}

}