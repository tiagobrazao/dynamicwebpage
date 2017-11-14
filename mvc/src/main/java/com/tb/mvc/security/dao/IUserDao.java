package com.tb.mvc.security.dao;

import com.tb.mvc.dao.IDAO;
import com.tb.mvc.security.model.User;
 

/**
 * Add methods to abstract DAO Interface
 * Find user by sso and delete user by sso
 * 
 * @author Tiago Brazão
 *
 */
public interface IUserDao extends IDAO<User, Integer> {
     
    User findBySSO(String sso);
     
    void deleteBySSO(String sso);
    
}