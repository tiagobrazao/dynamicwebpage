package com.tb.mvc.security.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.tb.mvc.dao.AbstractHibernateDao;
import com.tb.mvc.security.model.User;

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User, Integer> implements IUserDao {

	public User findBySSO(String sso) {
		Session session = getCurrentSession();
		
		TypedQuery<User> query = session.createQuery(
				"from User where ssoId = :sso", User.class);

		query.setParameter("sso", sso);
		
		
		return query.getSingleResult();
	}
 
	public void deleteBySSO(String sso) {
		User user = findBySSO(sso);
		delete(user);
		
	}

}
