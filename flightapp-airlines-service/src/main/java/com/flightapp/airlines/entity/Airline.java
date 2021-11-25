package com.flightapp.airlines.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.flightapp.airlines.constants.Status;

@Entity(name = "airline")
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "AIRLINEID")
	private Integer airlineId;

	@Column(name = "NAME")
	private String name;

	@Lob
	@Column(name = "LOGO")
	private byte[] logo;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;
	
	@OneToMany(mappedBy = "airline")
	private Set<Flight> flights;

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Airlines [airlineId=" + airlineId + ", name=" + name + ", status=" + status + "]";
	}

}
