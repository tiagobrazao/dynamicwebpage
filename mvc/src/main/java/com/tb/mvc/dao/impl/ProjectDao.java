package com.tb.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.tb.mvc.dao.AbstractHibernateDao;
import com.tb.mvc.model.Project;

/**
 * Implementation of IDAO for POJO Project
 * 
 * @author Tiago Brazão
 *
 * @param <T> 
 */
@Repository
public class ProjectDao	extends AbstractHibernateDao<Project, Integer> implements IProjectDao {
	
}
