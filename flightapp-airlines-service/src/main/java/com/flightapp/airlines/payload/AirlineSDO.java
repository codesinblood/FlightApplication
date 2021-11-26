package com.flightapp.airlines.payload;

import com.flightapp.airlines.constants.Status;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "API object for Airline entity")
public class AirlineSDO {

	private int airlineId;

	private String name;

	private byte[] logo;

	private Status status;

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
		return "AirlineSDO [airlineId=" + airlineId + ", name=" + name + ", status=" + status + "]";
	}

}
