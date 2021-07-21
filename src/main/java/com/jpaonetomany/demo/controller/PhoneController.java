package com.jpaonetomany.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpaonetomany.demo.model.Phone;
import com.jpaonetomany.demo.repository.PhoneRepository;
import com.jpaonetomany.demo.repository.UserRepository;
import com.jpaonetomany.demo.service.PhoneService;

import java.util.List;
import java.util.Set;

/**
 * Phone controller class to expose phone operation end points
 */
@RestController
public class PhoneController {
	

private static final Logger LOGGER=LoggerFactory.getLogger(PhoneController.class);

	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PhoneService phoneService;
    
	/**
	 * Getting the phone details from phone entity via phone id
	 */
    @GetMapping("/phone/details/{id}")
    public Phone getPhoneDetails(@PathVariable Long id) {
    	LOGGER.info("Fetching the phone details via phone id"+id);
        if(phoneRepository.findById(id).isPresent())
            return phoneRepository.findById(id).get();
        else return  null;
        
    }
    
    /**
     * Getting a user's phones from phone entity via user id
     */
    @GetMapping("/user/phone/details/{id}")
    public Set<Phone> getUserPhoneDetails(@PathVariable Long id) {
    	LOGGER.info("Fetching the user's phone details via user id"+id);
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get().getPhones();
        else return  null;
    }
    
    /**
     * Getting the list of phones from phone entity
     */
    @GetMapping("/phone/all")
    public List<Phone> getPhones() {
    	LOGGER.info("Fetching the list of all the phone");
        return phoneRepository.findAll();
}
    
}
