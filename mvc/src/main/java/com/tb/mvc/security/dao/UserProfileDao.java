package com.tb.mvc.security.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tb.mvc.dao.AbstractHibernateDao;
import com.tb.mvc.security.model.UserProfile;
 
 
 
@Repository("userProfileDao")
public class UserProfileDao extends AbstractHibernateDao<UserProfile, Integer> implements IUserProfileDao{
 
    public UserProfile findByType(String type) {
    	
		Session session = getCurrentSession();
		
		TypedQuery<UserProfile> query = session.createQuery(
				"from USER_PROFILE where type = :type", UserProfile.class);

		query.setParameter("type", type);
		return query.getSingleResult();
    }
     
}