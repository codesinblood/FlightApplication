package com.flightapp.airlines.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.flightapp.airlines.constants.Status;

@Entity(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ROUTEID")
	private Integer routeId;

	@Column(name = "FROMCITY")
	private String fromCity;

	@Column(name = "TOCITY")
	private String toCity;

	@Column(name = "PRICE")
	private BigDecimal price;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FLIGHTID")
	private Flight flight;

	@OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
	private Set<Ticket> ticket;

	@Column(name = "DEPARTURETIME")
	private LocalTime departureTime;

	@Column(name = "ARRIVALTIME")
	private LocalTime arrivalTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
