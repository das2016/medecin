package com.rdvmedecin.dao;

import java.util.Date;

import com.rdvmedecin.entity.Rv;

/**
 * 
 * @author SKAN
 * 
 */
public abstract interface RvDao extends DaoBaseMethod<Rv> {
	
	public abstract Iterable<Rv> getRvMedecinJour(long paramLong, Date paramDate);

	public abstract Rv findById(long paramLong);
}