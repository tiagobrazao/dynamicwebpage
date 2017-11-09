package com.tb.mvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.tb.mvc.dao.AbstractHibernateDao;
import com.tb.mvc.model.UploadFile;

/**
 * Implementation of IDAO for POJO UploadFile
 * 
 * @author Tiago Brazão
 *
 * @param <T> 
 */
@Repository
public class UploadFileDao	extends AbstractHibernateDao<UploadFile, Integer> implements IUploadFileDao {
	
}
