package com.tb.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tb.mvc.dao.IDAO;
import com.tb.mvc.dao.impl.IProjectDao;
import com.tb.mvc.model.Project;
import com.tb.mvc.service.AbstractService;

@Service
public class ProjectService extends AbstractService<Project, Integer>
        implements IProjectService {
 
	private IProjectDao project_dao; 
    
    public ProjectService() {}
    
    @Autowired
    public ProjectService(@Qualifier("projectDao") IDAO<Project, Integer> project_dao) {
        super(project_dao);
        this.project_dao = (IProjectDao) project_dao;
        this.project_dao.setClazz(Project.class);
    }
    
    //methods
 
}