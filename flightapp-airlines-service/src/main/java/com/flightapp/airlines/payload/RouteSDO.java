package com.flightapp.airlines.payload;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.entity.Flight;

public class RouteSDO {
	
	private int routeId;
	
	private String fromCity;
	
	private String toCity;

	private BigDecimal price;
	
	private Flight flight;
	
	private LocalTime departureTime;
	
	private LocalTime arrivalTime;
	
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
