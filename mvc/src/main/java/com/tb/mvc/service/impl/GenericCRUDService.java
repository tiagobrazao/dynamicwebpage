package com.tb.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tb.mvc.dao.IDAO;
import com.tb.mvc.dao.impl.ServiceDao;
import com.tb.mvc.model.DropView;
import com.tb.mvc.service.AbstractService;

@Service
public class GenericCRUDService extends AbstractService<DropView, Integer>
        implements IDropViewService {
 
	private ServiceDao dv_dao; 
    
    public GenericCRUDService() {}
    
    @Autowired
    public GenericCRUDService(@Qualifier("serviceDao") IDAO<DropView, Integer> dv_dao) {
        super(dv_dao);
        this.dv_dao = (ServiceDao) dv_dao;
        this.dv_dao.setClazz(DropView.class);
    }
    
}