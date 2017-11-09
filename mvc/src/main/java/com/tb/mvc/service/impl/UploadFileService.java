package com.tb.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tb.mvc.dao.IDAO;
import com.tb.mvc.dao.impl.IUploadFileDao;
import com.tb.mvc.model.UploadFile;
import com.tb.mvc.service.AbstractService;

@Service
public class UploadFileService extends AbstractService<UploadFile, Integer>
        implements IUploadFileService {
 
	private IUploadFileDao file_dao; 
    
    public UploadFileService() {}
    
    @Autowired
    public UploadFileService(@Qualifier("uploadFileDao") IDAO<UploadFile, Integer> file_dao) {
        super(file_dao);
        this.file_dao = (IUploadFileDao) file_dao;
        this.file_dao.setClazz(UploadFile.class);
    }
    
    //methods
 
}