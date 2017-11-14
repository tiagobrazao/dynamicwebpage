package com.tb.mvc.security.dao;

import com.tb.mvc.dao.IDAO;
import com.tb.mvc.security.model.UserProfile;
 
 
public interface IUserProfileDao extends IDAO<UserProfile, Integer>{
     
    UserProfile findByType(String type);
}
