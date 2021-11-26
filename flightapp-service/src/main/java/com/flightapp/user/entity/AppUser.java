package com.flightapp.user.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "APPUSER")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "APPUSER_ID")
	private int appUserId;

	@Enumerated(EnumType.STRING)
	@Column(name = "USER_TYPE", length = 50, nullable = true)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "APPUSER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<UserRole> roles = new HashSet<>();

	@Column(name = "EMAIL", length = 200, unique = true, nullable = false)
	private String email;

	@Column(name = "USERNAME", length = 50, unique = true, nullable = true)
	private String userName;

	@Column(name = "PASSWORD", nullable = true)
	private String password;

	@Column(name = "FIRSTNAME", length = 200, nullable = false)
	private String firstName;

	@Column(name = "LASTNAME", length = 200)
	private String lastName;

	@Column(name = "DOB", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "GENDER", length = 1)
	private String gender;

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "AppUser [appUserId=" + appUserId + ", userType=" + roles + ", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + "]";
	}

}