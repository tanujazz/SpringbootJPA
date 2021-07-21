package com.jpaonetomany.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpaonetomany.demo.model.Phone;
import com.jpaonetomany.demo.model.User;
import com.jpaonetomany.demo.repository.PhoneRepository;
import com.jpaonetomany.demo.repository.UserRepository;
import com.jpaonetomany.demo.service.UserService;


/**
 * User Controller class for exposing CRUD end points
 */
@RestController
public class UserController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	
		/**
	     * Create/Add a User with the phone/phones
	     */
	    @PostMapping("/user/create")
	    public ResponseEntity<Object> createUser(@RequestBody User user) {
	        return  userService.addUser(user);
	    }
	    
	    /**
	     * Delete a User
	     */
	    @DeleteMapping("/user/delete/{id}")
	    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
	    	LOGGER.info("Deleting the details of a user"+ id);
	        return userService.deleteUser(id);
	    }
	    
	    /**
	     * Fetch details of a User 
	     */
	    @GetMapping("/user/details/{id}")
	        public User getUser1(@PathVariable Long id) {
	            if(userRepository.findById(id).isPresent())
	                return userRepository.findById(id).get();
	            else return null;
	        }
	    
	    /**
	     * Fetching all the Users
	     */
	        @GetMapping("/users/all")
	        public List<User> getUsers() {
	        	LOGGER.info("Getting the List of all users ");
	            return userRepository.findAll();
	        }
	        
	        /**
	         * Updating a User with the phone/phones
	         */    
	        @PostMapping("/user/update/{id}")
		    public ResponseEntity<Object> updateUser(@PathVariable Long id,@RequestBody Phone phone) {
	        	LOGGER.info("Updating a User with a new phone"+id);
		        return  userService.updateUser(id,phone);
		    }
	        
	        /**
	         * Deleting a phone from the user
	         */
	        @DeleteMapping("/user/phone/delete/{id}")
	        public ResponseEntity<Object> deleteUserPhone(@PathVariable Long id,@RequestBody Phone phone) {
	        	LOGGER.info("Deleting a phone for the user"+id);
	            return userService.deleteUserPhones(id, phone);
	    }
	        
	        /**
	         * Updating a User with the preferred phone number
	         */    
	        @PostMapping("/user/update/prefPhoneNumber/{id}/{phoneNumber}")
		    public ResponseEntity<Object> updateUserPrefPhone(@PathVariable Long id, @PathVariable String phoneNumber) {
	        	LOGGER.info("Updating a User with a preferred phone number"+id +""+phoneNumber);
		        return  userService.updateUserPreferredPhoneNum(id, phoneNumber);
		    }
	}

