package com.jpaonetomany.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpaonetomany.demo.model.Phone;
import com.jpaonetomany.demo.model.User;
import com.jpaonetomany.demo.repository.UserRepository;


/**
 * Test class to test the Data JPA for various operations
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {

        User user = new User();
        user.setEmailAddress("tanuj.arora@gmail.com");
        user.setId((long) 100);
        user.setPassword("Secret");
        user.setPrefPhoneNumber("+353881234567");
        user.setUserName("Tanuj");
        
        Phone phone = new Phone();
		phone.setId((long) 111);
		phone.setPhoneModel("John's Pixel");
		phone.setPhoneNumber("+353881234567");
		phone.setPhoneName("IPHONE");
		//phone.setUser(user);
		Set<Phone> phoneSet= new HashSet<Phone>();
		phoneSet.add(phone);
        user.setPhones(phoneSet);
        userRepository.save(user);
        Optional<User> userActual = userRepository.findById((long) 100);
        assertNotNull(userActual);
        
    }

    @Test
    public void testGetUser() {

    	User user = new User();
        user.setEmailAddress("tanuj.arora@gmail.com");
        user.setId((long) 100);
        user.setPassword("Secret");
        user.setPrefPhoneNumber("+353881234567");
        user.setUserName("Tanuj");
        
        Phone phone = new Phone();
		phone.setId((long) 111);
		phone.setPhoneModel("John's Pixel");
		phone.setPhoneNumber("+353881234567");
		phone.setPhoneName("IPHONE");
		//phone.setUser(user);
		Set<Phone> phoneSet= new HashSet<Phone>();
		phoneSet.add(phone);
        user.setPhones(phoneSet);
        userRepository.save(user);
        Optional<User> userActual = userRepository.findById((long) 100);
        assertNotNull(userActual);
        assertEquals(userActual.get().getUserName(), user.getUserName());
        assertEquals(userActual.get().getPassword(), user.getPassword());
    }

    @Test
    public void testDeleteEmployee() {
    	User user = new User();
        user.setEmailAddress("tanuj.arora@gmail.com");
        user.setId((long) 100);
        user.setPassword("Secret");
        user.setPrefPhoneNumber("+353881234567");
        user.setUserName("Tanuj");
        
        Phone phone = new Phone();
		phone.setId((long) 111);
		phone.setPhoneModel("John's Pixel");
		phone.setPhoneNumber("+353881234567");
		phone.setPhoneName("IPHONE");
		//phone.setUser(user);
		Set<Phone> phoneSet= new HashSet<Phone>();
		phoneSet.add(phone);
        user.setPhones(phoneSet);
        userRepository.save(user);
        userRepository.delete(user);
        assertNull(userRepository.findById((long) 100));
    }

    @Test
    public void findAllEmployees() {
    	User user = new User();
        user.setEmailAddress("tanuj.arora@gmail.com");
        user.setId((long) 100);
        user.setPassword("Secret");
        user.setPrefPhoneNumber("+353881234567");
        user.setUserName("Tanuj");
        
        Phone phone = new Phone();
		phone.setId((long) 111);
		phone.setPhoneModel("John's Pixel");
		phone.setPhoneNumber("+353881234567");
		phone.setPhoneName("IPHONE");
		//phone.setUser(user);
		Set<Phone> phoneSet= new HashSet<Phone>();
		phoneSet.add(phone);
        user.setPhones(phoneSet);
        userRepository.save(user);
        assertNotNull(userRepository.findAll());
    }

    @Test
    public void deletByIdTest() {
    	User user = new User();
        user.setEmailAddress("tanuj.arora@gmail.com");
        user.setId((long) 100);
        user.setPassword("Secret");
        user.setPrefPhoneNumber("+353881234567");
        user.setUserName("Tanuj");
        
        Phone phone = new Phone();
		phone.setId((long) 111);
		phone.setPhoneModel("John's Pixel");
		phone.setPhoneNumber("+353881234567");
		phone.setPhoneName("IPHONE");
		//phone.setUser(user);
		Set<Phone> phoneSet= new HashSet<Phone>();
		phoneSet.add(phone);
        user.setPhones(phoneSet);
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        assertFalse(userRepository.findById((long) 100).isPresent());
        
    }
}