package com.jpaonetomany.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaonetomany.demo.model.Phone;

/**
 * Phone repository to perform the CRUD operation on phone entity
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	Optional<Phone> findById(Long id);
	
	public void deleteById(Long id);

}
