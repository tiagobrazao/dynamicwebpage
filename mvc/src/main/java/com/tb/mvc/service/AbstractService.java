package com.tb.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tb.mvc.dao.IDAO;

/**
 * Abstract Service for <E> DAO implementation with <K> type of unique id
 * 
 * @author Tiago Brazão
 *
 * @param <E> Type of entity to use in service
 * @param <K> Type of entity unique id to be used in service
 */
@Service
public abstract class AbstractService<E, K> implements IService<E, K> {
 
    private IDAO <E, K> dao;
 
    public AbstractService(IDAO<E,K> dao) {
        this.dao=dao;
    }
 
    public AbstractService() {
    }
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> findAll() {
        return dao.findAll();
    }
 
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E findOne(K id) {
        return dao.findOne(id);
    }
 
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(E entity) {
    	dao.add(entity);
    }
 
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) {
    	dao.update(entity);
    }
 
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(E entity) {
    	dao.delete(entity);
    }
}