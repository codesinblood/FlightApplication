package com.flightapp.user.dto;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "routeId", "fromCity", "toCity", "price", "flight", "departureTime", "arrivalTime", "status" })
@Generated("jsonschema2pojo")
public class RouteDTO {

	@JsonProperty("routeId")
	public Integer routeId;
	@JsonProperty("fromCity")
	public String fromCity;
	@JsonProperty("toCity")
	public String toCity;
	@JsonProperty("price")
	public Double price;
	@JsonProperty("flight")
	public FlightDTO flight;
	@JsonProperty("departureTime")
	public String departureTime;
	@JsonProperty("arrivalTime")
	public String arrivalTime;
	@JsonProperty("status")
	public String status;

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}