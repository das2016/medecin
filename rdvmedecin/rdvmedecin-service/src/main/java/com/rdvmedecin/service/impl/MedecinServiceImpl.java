package com.rdvmedecin.service.impl;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Medecin;
import com.rdvmedecin.entity.Rv;
import com.rdvmedecin.model.AgendaMedecinJour;
import com.rdvmedecin.model.CreneauMedecinJour;
import com.rdvmedecin.service.CreneauService;
import com.rdvmedecin.service.MedecinService;
import com.rdvmedecin.service.RvService;
import com.rdvmedecin.springdatajpa.SpringDataMedecinDao;

/**
 * 
 * @author SKAN
 * 
 */
@Service("medecinService")
@Transactional
public class MedecinServiceImpl implements MedecinService {
	
	@Autowired
	private SpringDataMedecinDao medecinDao;
	@Autowired
	private CreneauService creneauService;
	@Autowired
	private RvService rvService;

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.MedecinService#getAllMedecin()
	 */
	public List<Medecin> getAllMedecin() {
		return this.medecinDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.MedecinService#addMedecin(com.rdvmedecin.entity.Medecin)
	 */
	public Medecin addMedecin(Medecin medecin) {
		return (Medecin) this.medecinDao.save(medecin);
	}

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.MedecinService#deleteMedecin(com.rdvmedecin.entity.Medecin)
	 */
	public void deleteMedecin(Medecin medecin) {
		this.medecinDao.delete(medecin);
	}

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.MedecinService#getMedecinById(long)
	 */
	public Medecin getMedecinById(long id) {
		return this.medecinDao.findById(id);
	}


	/* 
	 * 
	 * 
	 * TODO A FACTORISER la complexite de la methode ne doit pas depasser 10
	 * 
	 * 
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.MedecinService#getAgendaMedecinJour(long, java.util.Date)
	 */
	public AgendaMedecinJour getAgendaMedecinJour(long idMedecin, Date jour) {
		
		List<Creneau> creneauxHoraires = this.creneauService.getAllCrenauByMedecin(idMedecin);
		List<Rv> reservations = this.rvService.getRvMedecinJour(idMedecin, jour);
		Map<Long, Rv> hReservations = new Hashtable();
		for (Rv resa : reservations) {
			hReservations.put(resa.getCreneau().getId(), resa);
		}
		AgendaMedecinJour agenda = new AgendaMedecinJour();
		agenda.setMedecin(getMedecinById(idMedecin));
		agenda.setJour(jour);
		CreneauMedecinJour[] creneauxMedecinJour = new CreneauMedecinJour[creneauxHoraires.size()];
		agenda.setCreneauxMedecinJours(creneauxMedecinJour);
		for (int i = 0; i < creneauxHoraires.size(); i++) {
			creneauxMedecinJour[i] = new CreneauMedecinJour();
			Creneau creneau = (Creneau) creneauxHoraires.get(i);
			long idCreneau = creneau.getId().longValue();
			creneauxMedecinJour[i].setCreneau(creneau);
			if (hReservations.containsKey(Long.valueOf(idCreneau))) {
				Rv resa = (Rv) hReservations.get(Long.valueOf(idCreneau));
				creneauxMedecinJour[i].setRv(resa);
			}
		}
		return agenda;
	}
}
