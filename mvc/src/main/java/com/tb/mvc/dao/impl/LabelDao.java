package com.tb.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.tb.mvc.dao.AbstractHibernateDao;
import com.tb.mvc.dao.IDAO;
import com.tb.mvc.model.DropLabel;
import com.tb.mvc.model.DropView;

/**
 * Implementation of IDAO for POJO Project Label
 * 
 * @author Tiago Brazão
 *
 * @param <T> 
 */
@Repository
public class LabelDao extends AbstractHibernateDao<DropLabel, Integer> implements IDAO<DropLabel, Integer> {
	
}
