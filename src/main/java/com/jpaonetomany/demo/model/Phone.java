package com.jpaonetomany.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Phone entity class for storing the phone specific info
 */
@Entity
@Table(name = "Phone")
public class Phone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "pk_sequence",sequenceName = "sequence_Phone", allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	private Long id;
	@Column
	private String phoneName;
	@Column
	private String phoneNumber;
	@Column
	private String phoneModel;
	
	/*
	 * (fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	 * 
	 * @JoinColumn(name = "user_id", nullable = false)
	 */

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToOne private User user;
	 */
	
	public Phone()
	{
		
	}
	
	/*
	 * public Phone(String phoneId, String phoneName, String phoneNumber, String
	 * phoneModel) { super(); this.phoneId = phoneId; this.phoneName = phoneName;
	 * this.phoneNumber = phoneNumber; this.phoneModel = phoneModel; }
	 */
	
	
	/*
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; }
	 */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneModel() {
		return phoneModel;
	}
	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}
	
}
