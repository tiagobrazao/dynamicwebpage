package com.tb.mvc.service;

import java.util.List;

/**
 * Services package for Controller usage
 * 
 * @author Tiago Brazão
 *
 * @param <E> Type of entity to use in service
 * @param <K> Type of entity unique id to be used in service
 */
public interface IService <E,K> {
    
	   E findOne(K entityId);
	   
	   List<E> findAll();
	 
	   void create(final E entity);
	 
	   void update(final E entity);
	 
	   void delete(final E entity);
	 
}
