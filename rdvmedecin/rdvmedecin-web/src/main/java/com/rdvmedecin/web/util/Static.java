package com.rdvmedecin.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rdvmedecin.entity.Creneau;
import com.rdvmedecin.entity.Rv;

/**
 * 
 * @author SKAN
 * 
 */
public class Static {

	/**
	 * Get error message from exception
	 * 
	 * @param exception
	 * @return
	 */
	public static List<String> getErreursForException(Exception exception) {
		Throwable cause = exception;
		List<String> erreur = new ArrayList<String>();
		while (cause != null) {
			erreur.add(cause.getMessage());
			cause = cause.getCause();
		}
		return erreur;
	}

	/**
	 * Get List of a map object For creneau
	 * 
	 * @param creneaux
	 * @return
	 */
	public static List<Map<String, Object>> getListMapForCreneaux(
			List<Creneau> creneaux) {
		List<Map<String, Object>> liste = new ArrayList<Map<String, Object>>();
		for (Creneau creneau : creneaux) {
			liste.add(getMapForCreneau(creneau));
		}
		return liste;
	}

	/**
	 * 
	 * @param rvs
	 * @return
	 */
	public static List<Map<String, Object>> getListMapForRvs(List<Rv> rvs) {
		List<Map<String, Object>> liste = new ArrayList<Map<String, Object>>();
		for (Rv rv : rvs) {
			liste.add(getMapForRv(rv));
		}
		return liste;
	}

	/**
	 * 
	 * @param rv
	 * @return
	 */
	public static Map<String, Object> getMapForRv(Rv rv) {
		if (rv == null) {
			return null;
		}
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", rv.getId());
		hash.put("client", rv.getClient());
		hash.put("creneau", getMapForCreneau(rv.getCreneau()));
		return hash;
	}

	/**
	 * 
	 * @param creneau
	 * @return
	 */
	public static Map<String, Object> getMapForCreneau(Creneau creneau) {
		if (creneau == null) {
			return null;
		}
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", creneau.getId());
		hash.put("hDebut", Integer.valueOf(creneau.gethDebut()));
		hash.put("mDebut", Integer.valueOf(creneau.getmDebut()));
		hash.put("hFin", Integer.valueOf(creneau.gethFin()));
		hash.put("mFin", Integer.valueOf(creneau.getmFin()));

		return hash;
	}

	/**
	 * 
	 * @param rv
	 * @return
	 */
	public static Map<String, Object> getMapForRv2(Rv rv) {
		if (rv == null) {
			return null;
		}
		Map<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", rv.getId());
		hash.put("idClient", Long.valueOf(rv.getIdClient()));
		hash.put("idCreneau", Long.valueOf(rv.getIdCreneau()));
		return hash;
	}
}
