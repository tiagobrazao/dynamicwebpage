package com.tb.mvc.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tb.mvc.security.dao.IUserProfileDao;
import com.tb.mvc.security.model.UserProfile;
import com.tb.mvc.service.AbstractService;

@Service("userProfileService")
@Transactional
public class UserProfileService extends AbstractService<UserProfile, Integer> implements IUserProfileService {
	
	    @Autowired
	    IUserProfileDao dao;
	 
	    public UserProfile findByType(String type) {
	        return dao.findByType(type);
	    }
	    
	}
