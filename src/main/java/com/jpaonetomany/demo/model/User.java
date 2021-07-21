package com.jpaonetomany.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * User Entity to store the user specific info (One to Many)
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "pk_sequence",sequenceName = "sequence_User", allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private Long id;
	
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String emailAddress;
	@Column
	private String prefPhoneNumber;
	/*
	 * (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 */
	@OneToMany(targetEntity = Phone.class, cascade = CascadeType.ALL)
	private Set<Phone> phones;
	
	
	public User()
	{
		
	}
	/*
	 * public User(String userId, String userName, String password, String email,
	 * String prefPhoneNumber, Set<Phone> phones ) { super(); this.userId = userId;
	 * this.userName = userName; this.password = password; this.emailAddress =
	 * email; this.prefPhoneNumber = prefPhoneNumber; this.phones = phones; }
	 */
	
	
	public String getUserName() {
		return userName;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<Phone> getPhones() {
		return phones;
	}


	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPrefPhoneNumber() {
		return prefPhoneNumber;
	}
	public void setPrefPhoneNumber(String prefPhoneNumber) {
		this.prefPhoneNumber = prefPhoneNumber;
	}
	
}
