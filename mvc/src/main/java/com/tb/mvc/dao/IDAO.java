package com.tb.mvc.dao;

import java.util.List;

/**
 * Interface for basic CRUD operations by DAO implementations based on IPojo objects.
 * 
 * @author Tiago Brazão
 *
 * @param <E> type of DAO implementation
 */
public interface IDAO<E,K> {
    
	/**
	 * Find E instance with @param id unique value in db   
	 *    
	 * @param id db id unique value
	 * @return pojo instance from db with with @param
	 */
	E findOne(K id);
	   
	/**
	 * Get all <E> instances from db
	 *    
	 * @return all <E> instances from db
	 */
	List<E> findAll();
	
	/**
	 * Add transient entity <E> instance in db
	 * 
	 * @param entity <E> instance 
	 */
	void add(final E entity);
	 
	/**
	 * Update values from detached <E> instance in db
	 * 
	 * @param entity <E> instance
	 */
	void update(final E entity);
	 
	/**
	 * Delete managed or detached <E> instance in db
	 * 
	 * @param entity <E> instance
	 */
	void delete(final E entity);
	 
	/**
	 * Delete managed or detached <E> instance with id unique value
	 *  
	 * @param id unique db table column id
	 */
	 void deleteById(K id);
	 
	 public void setClazz(Class<E> clazzToSet);

}