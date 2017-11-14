package com.tb.mvc.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tb.mvc.security.dao.IUserDao;
import com.tb.mvc.security.model.User;
import com.tb.mvc.service.AbstractService;
 
 
@Service("userService")
@Transactional
public class UserService extends AbstractService<User,Integer> implements IUserService {
 
    @Autowired 
    private IUserDao dao;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
     
    public User findBySSO(String sso) {
        return dao.findBySSO(sso);
    }
 
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.add(user);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     */
    public void updateUser(User user) {
        User entity = dao.findOne(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }
 
 
    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }

	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}
     
}