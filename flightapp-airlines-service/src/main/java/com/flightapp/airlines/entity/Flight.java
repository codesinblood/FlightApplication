package com.flightapp.airlines.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.flightapp.airlines.constants.Status;

@Entity(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "FLIGHTID")
	private int flightId;

	@Column(name = "FLIGHTUUID")
	private String flightUuid;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "MAKE")
	private String make;

	@ManyToOne
	@JoinColumn(name = "AIRLINEID")
	private Airline airline;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@OneToOne(mappedBy = "flight")
	private Route route;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightUuid() {
		return flightUuid;
	}

	public void setFlightUuid(String flightUuid) {
		this.flightUuid = flightUuid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
