package com.rdvmedecin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdvmedecin.entity.Client;
import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Rv;
import com.rdvmedecin.service.RvService;
import com.rdvmedecin.springdatajpa.SpringDataCreneauDao;
import com.rdvmedecin.springdatajpa.SpringDataRvDao;

/**
 * 
 * @author SKAN
 *
 */
@Service("rvService")
@Transactional
public class RvServiceImpl implements RvService {

	@Autowired
	private SpringDataRvDao rvDao;
	@Autowired
	private SpringDataCreneauDao creneauDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#getAllRv()
	 */
	public List<Rv> getAllRv() {
		return this.rvDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.RvService#addRendezVous(com.rdvmedecin.entity.Rv)
	 */
	public Rv addRendezVous(Rv rv) {
		return (Rv) this.rvDao.save(rv);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.rdvmedecin.service.RvService#deleteRendezVous(com.rdvmedecin.entity
	 * .Rv)
	 */
	public void deleteRendezVous(Rv rv) {
		this.rvDao.delete(rv);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#getRvMedecinJour(long,
	 * java.util.Date)
	 */
	public List<Rv> getRvMedecinJour(long idMedecin, Date jour) {
		return this.rvDao.getRvMedecinJour(idMedecin, jour);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#addRendezVous(java.util.Date,
	 * com.rdvmedecin.entity.Creneau, com.rdvmedecin.entity.Client)
	 */
	public Rv addRendezVous(Date jour, Creneau creneau, Client client) {
		if (creneau != null && client != null) {
			creneauDao.save(creneau);
			return (Rv) this.rvDao.save(new Rv(jour, client, creneau));
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rdvmedecin.service.RvService#getRvById(long)
	 */
	public Rv getRvById(long id) {
		return this.rvDao.findById(id);
	}
}
