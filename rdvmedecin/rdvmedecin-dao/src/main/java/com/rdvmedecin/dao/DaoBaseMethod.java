package com.rdvmedecin.dao;

import java.util.List;

/**
 * 
 * @author SKAN
 * 
 * @param <T>
 */
public interface DaoBaseMethod<T> {
	/**
	 * Save entity
	 * 
	 * @param paramT
	 * @return
	 */
	T save(T paramT);

	/**
	 * find all entity
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * delete entity
	 * 
	 * @param paramT
	 */
	void delete(T paramT);

	/**
	 * Delete all entities
	 */
	void deleteAll();
}