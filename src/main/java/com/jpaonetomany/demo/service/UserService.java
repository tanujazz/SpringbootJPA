package com.jpaonetomany.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpaonetomany.demo.controller.PhoneController;
import com.jpaonetomany.demo.model.Phone;
import com.jpaonetomany.demo.model.User;
import com.jpaonetomany.demo.repository.PhoneRepository;
import com.jpaonetomany.demo.repository.UserRepository;


/**
 * User service for the business logic for CRUD operation on User Entity
 */
@Service
public class UserService {

	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private UserRepository userRepository;
	
	/**
     * Persist a User with the phone/phones
     */
	  @Transactional
	      public ResponseEntity<Object> addUser(User user) {
	          User newUser = new User();
	          newUser.setUserName(user.getUserName());
	          newUser.setId(user.getId());
	          newUser.setPrefPhoneNumber(user.getPrefPhoneNumber());
	          newUser.setEmailAddress(user.getEmailAddress());
	          newUser.setPassword(user.getPassword());
	          newUser.setPhones(user.getPhones());
	          User savedUser = userRepository.save(newUser);
	          if (userRepository.findById(savedUser.getId()).isPresent()) {
	        	  LOGGER.info("Persisting a user with the phones");
	              return ResponseEntity.accepted().body("Successfully Created User and Phones");
	          } else
	              return ResponseEntity.unprocessableEntity().body("Failed to Create specified User");
	      }
	  
	  
	  	/**
	       * Delete a specified user given the id
	       */
	  @Transactional
	      public ResponseEntity<Object> deleteUser(Long id) {
	          if (userRepository.findById(id).isPresent()) {
	        	  userRepository.deleteById(id);
	              if (userRepository.findById(id).isPresent()) {
	            	  LOGGER.info("Deleting a User with a specificed user id"+id);
	                  return ResponseEntity.unprocessableEntity().body("Failed to delete the specified user record");
	              } else return ResponseEntity.ok().body("Successfully deleted specified user record");
	          } else
	              return ResponseEntity.unprocessableEntity().body("No Records Found");
	      }

	  /**
       * Update a specified user with the new phone
       */
	  @Transactional
		public ResponseEntity<Object> updateUser(Long id, Phone phone) {
		  if (userRepository.findById(id).isPresent()) {
		  userRepository.findById(id).get().getPhones().add(phone);
		  if (userRepository.findById(id).isPresent()) {
			  LOGGER.info("Updating a User with a new phone/phones"+id);
              return ResponseEntity.accepted().body("Successfully updated User and Phones");
          } else
              return ResponseEntity.unprocessableEntity().body("Failed to update specified User");
		  }
		  else 
			return ResponseEntity.unprocessableEntity().body("No Records Found");
	  }
	  
	  
	  /**
       * Delete a specified user's phone
       */
	  @Transactional
	    public ResponseEntity<Object> deleteUserPhones(Long id,Phone phone) {
	        if (userRepository.findById(id).isPresent()) {
	        	userRepository.findById(id).get().getPhones().remove(phone);
	            if (!userRepository.findById(id).isPresent()) {
	            	LOGGER.info("Deleting a User's phone using user id"+id);
	                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified user phones");
	            } else return ResponseEntity.ok().body("Successfully deleted specified user phones");
	        } else
	            return ResponseEntity.unprocessableEntity().body("No Records Found");
	    }

	  
	  /**
       * Update a specified user's preferred phone number
       */
	@Transactional
	public ResponseEntity<Object> updateUserPreferredPhoneNum(Long id, String prefPhoneNumber) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.findById(id).get().setPrefPhoneNumber(prefPhoneNumber);
			if (userRepository.findById(id).isPresent()) {
				LOGGER.info("Updating a User with a user's preferred phone number"+id +" "+prefPhoneNumber);
	              return ResponseEntity.accepted().body("Successfully updated User's preferred phone number");
	          } else
	              return ResponseEntity.unprocessableEntity().body("Failed to update User's preferred phone number");
			  }
			  else 
				return ResponseEntity.unprocessableEntity().body("No Records Found");
		}
		
}
