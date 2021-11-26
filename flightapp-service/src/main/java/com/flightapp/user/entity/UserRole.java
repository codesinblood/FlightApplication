package com.flightapp.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.flightapp.user.constants.UserType;

@Entity(name = "ROLE")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "NAME")
	private UserType name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserType getName() {
		return name;
	}

	public void setName(UserType name) {
		this.name = name;
	}

}
