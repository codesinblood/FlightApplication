package com.flightapp.airlines.payload;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.entity.Flight;
import com.flightapp.airlines.entity.Ticket;

public class RouteSDO {

	private Integer routeId;

	private String fromCity;

	private String toCity;

	private BigDecimal price;

	private Flight flight;

	private LocalTime departureTime;

	private LocalTime arrivalTime;

	private Status status;

	@JsonIgnore
	private Set<Ticket> ticket;

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

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

	@Override
	public String toString() {
		return "RouteSDO [routeId=" + routeId + ", fromCity=" + fromCity + ", toCity=" + toCity + ", price=" + price
				+ ", flight=" + flight + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", status=" + status + "]";
	}

}
