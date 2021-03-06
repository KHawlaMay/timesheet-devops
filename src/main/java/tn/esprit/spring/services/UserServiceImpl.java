package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
 	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			
			l.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (User user : users) {
				l.debug("user :" + user.getLastName()); 
			} 
			l.info("Out of Method retrieveAllUsers with Success" + users.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e); 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		
		User u_saved = null; 
		
		try {
			l.info("In Method addUser :");
			u_saved = userRepository.save(u); 
			l.debug("user cree :"); 
			
		} catch (Exception e) {
			l.error("Out of Method addUser with Errors : " + e); 
		}
		
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) {
		
		User userUpdated = null; 
		
		try {
			l.info("In Method updateUser :");
			userUpdated = userRepository.save(u); 
			l.debug("user updated :"); 
			
		} catch (Exception e) {
			l.error("Out of Method UpdateUser with Errors : " + e); 
		}
		
		return userUpdated; 
	}

	@Override
	public void deleteUser(String id) {
		
		try {
			l.info("In Method deleteUser :");
			userRepository.deleteById(Long.parseLong(id)); 
			l.debug("user deleted :"); 
			
		} catch (Exception e) {
			l.error("Out of Method deleteUser with Errors : " + e); 
		}
		
	}

	@Override
	public User retrieveUser(String id) {
		User u = null; 
		try {
			l.info("In Method retreiveUser :");
			u =  userRepository.findById(Long.parseLong(id)).get(); 
			l.debug("user retreived:"); 
			
		} catch (Exception e) {
			l.error("Out of Method retreiveUser with Errors : " + e); 
		}

		return u; 
	}

}
