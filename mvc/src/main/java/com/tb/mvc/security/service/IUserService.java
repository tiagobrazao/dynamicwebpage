package com.tb.mvc.security.service;

import com.tb.mvc.security.model.User;
import com.tb.mvc.service.IService;

public interface IUserService extends IService<User, Integer> {
	     
	    User findBySSO(String sso);
	     
	    void deleteUserBySSO(String sso);
	 
	    boolean isUserSSOUnique(Integer id, String sso);
	    
	    /**
	     * Overwrite of IService save in order to encrypt password
	     * @param user The user instance to be persisted
	     */
	    public void saveUser(User user);
	 
	    /**
	     * Overwrite of IService update in order to encrypt password
	     * @param user The user instance to be updated
	     */
	    public void updateUser(User user);
	 
	}