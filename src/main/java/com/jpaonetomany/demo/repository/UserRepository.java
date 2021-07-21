package com.jpaonetomany.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaonetomany.demo.model.User;

/**
 * User Repository class for CRUD operation on User Entity
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
public User findByUserName(final String name);

 Optional<User> findById(Long id);

public void deleteById(Long id);
}