package com.flightapp.user.dto;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "flightId", "flightUuid", "model", "make", "airline", "status" })
@Generated("jsonschema2pojo")
public class FlightDTO {

	@JsonProperty("flightId")
	public Integer flightId;
	@JsonProperty("flightUuid")
	public String flightUuid;
	@JsonProperty("model")
	public String model;
	@JsonProperty("make")
	public Object make;
	@JsonProperty("airline")
	public AirlineDTO airline;
	@JsonProperty("status")
	public String status;

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
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

	public Object getMake() {
		return make;
	}

	public void setMake(Object make) {
		this.make = make;
	}

	public AirlineDTO getAirline() {
		return airline;
	}

	public void setAirline(AirlineDTO airline) {
		this.airline = airline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}