package com.jpaonetomany.demo.service;

import org.springframework.stereotype.Service;

/**
 * Phone service for the business logic for CRUD operation on Phone Entity
 */
@Service
public class PhoneService {

	
	/*
	 * @Transactional public ResponseEntity<Object> addPhone(Phone phone) { Phone
	 * newPhone = new Phone(); newPhone.setId(phone.getId());
	 * newPhone.setPhoneModel(phone.getPhoneModel());
	 * newPhone.setPhoneName(phone.getPhoneName());
	 * newPhone.setPhoneNumber(phone.getPhoneNumber());
	 * newPhone.setUser(phone.getUser()); Phone savePhone =
	 * phoneRepository.save(newPhone); if
	 * (phoneRepository.findById(savePhone.getId()).isPresent()) { return
	 * ResponseEntity.accepted().
	 * body("Successfully Created phone and mapped to user"); } else return
	 * ResponseEntity.unprocessableEntity().body("Failed to Create specified phone"
	 * ); }
	 */
	
	
}
