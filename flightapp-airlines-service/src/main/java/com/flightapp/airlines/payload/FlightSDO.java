package com.flightapp.airlines.payload;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.entity.Airline;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "API object for Flight entity")
public class FlightSDO {

	private int flightId;

	private String flightUuid;

	private String model;

	private String make;

	private Airline airline;

	private Status status;

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

	@Override
	public String toString() {
		return "FlightSDO [flightId=" + flightId + ", flightUuid=" + flightUuid + ", model=" + model + ", make=" + make
				+ ", airline=" + airline + ", status=" + status + "]";
	}

}
