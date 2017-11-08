package com.tb.mvc.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of IDAO with abstract CRUD operations
 * 
 * @author Tiago Brazão
 *
 * @param <E>
 */
public abstract class AbstractHibernateDao<E, K extends Serializable> implements IDAO<E, K> {

	@Autowired
	//@Scope( BeanDefinition.SCOPE_PROTOTYPE )
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public final void setClazz(Class<E> clazzToSet) {
		this.daoType = clazzToSet;
	}

	public E findOne(K id) {
		return (E) getCurrentSession().get(daoType, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		return getCurrentSession().createQuery("from " + daoType.getName()).list();
	}

	public void add(E entity) {
		getCurrentSession().persist(entity);
	}

	public void update(E entity) {
		getCurrentSession().merge(entity);
	}

	public void delete(E entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(K entityId) {
		E entity = findOne(entityId);
		delete(entity);
	}


}