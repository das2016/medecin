package com.rdvmedecin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.service.CreneauService;
import com.rdvmedecin.springdatajpa.SpringDataCreneauDao;

/**
 * 
 * @author SKAN
 * 
 */
@Service("creneauService")
@Transactional
public class CreneauServiceImpl implements CreneauService {
	
	@Autowired
	SpringDataCreneauDao creneauDao;

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.CreneauService#getAllCrenauByMedecin(long)
	 */
	public List<Creneau> getAllCrenauByMedecin(long idMedecin) {
		return this.creneauDao.getAllCreneaux(idMedecin);
	}

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.CreneauService#findCrenauById(long)
	 */
	public Creneau findCrenauById(long id) {
		return this.creneauDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.rdvmedecin.service.CreneauService#addCReneau(com.rdvmedecin.entity.Creneau)
	 */
	public Creneau addCReneau(Creneau creneau) {
		return (Creneau) this.creneauDao.save(creneau);
	}
}
