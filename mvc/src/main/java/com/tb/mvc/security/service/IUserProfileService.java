package com.tb.mvc.security.service;

import com.tb.mvc.security.model.UserProfile;
import com.tb.mvc.service.IService;

public interface IUserProfileService extends IService <UserProfile, Integer> {
	
	public UserProfile findByType(String type);
	
}
