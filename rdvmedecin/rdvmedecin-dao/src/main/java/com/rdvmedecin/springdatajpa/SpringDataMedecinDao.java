package com.rdvmedecin.springdatajpa;

import com.rdvmedecin.dao.MedecinDao;
import com.rdvmedecin.entity.Medecin;
import org.springframework.data.repository.Repository;
/**
 * 
 * @author SKAN
 *
 */
public abstract interface SpringDataMedecinDao extends MedecinDao, Repository<Medecin, Long> {
	
}
