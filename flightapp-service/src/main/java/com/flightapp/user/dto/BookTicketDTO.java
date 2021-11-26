package com.flightapp.user.dto;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "isRoundTrip", "isMealRequired", "customerEmail", "passenger", "travelDate", "route" })
@Generated("jsonschema2pojo")
public class BookTicketDTO {

	@JsonProperty("isRoundTrip")
	public String isRoundTrip;
	@JsonProperty("isMealRequired")
	public String isMealRequired;
	@JsonProperty("customerEmail")
	public String customerEmail;
	@JsonProperty("passenger")
	public List<PassengerDTO> passenger = null;
	@JsonProperty("travelDate")
	public String travelDate;
	@JsonProperty("route")
	public RouteDTO route;

	public String getIsRoundTrip() {
		return isRoundTrip;
	}

	public void setIsRoundTrip(String isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}

	public String getIsMealRequired() {
		return isMealRequired;
	}

	public void setIsMealRequired(String isMealRequired) {
		this.isMealRequired = isMealRequired;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<PassengerDTO> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<PassengerDTO> passenger) {
		this.passenger = passenger;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public RouteDTO getRoute() {
		return route;
	}

	public void setRoute(RouteDTO route) {
		this.route = route;
	}

}