package com.tb.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.tb.mvc.dao.AbstractHibernateDao;
import com.tb.mvc.dao.IDAO;
import com.tb.mvc.model.DropView;

/**
 * Implementation of IDAO for POJO Project
 * 
 * @author Tiago Brazão
 *
 * @param <T> 
 */
@Repository
public class ServiceDao extends AbstractHibernateDao<DropView, Integer> implements IDAO<DropView, Integer> {
	
}
