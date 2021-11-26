package com.flightapp.user.dto;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ticketId", "pnr", "isRoundTrip", "isMealRequired", "customerEmail", "bookingTime",
		"bookingStatus", "ticketStatus", "passenger" })
@Generated("jsonschema2pojo")
public class TicketDTO {

	@JsonProperty("ticketId")
	public Integer ticketId;
	@JsonProperty("pnr")
	public String pnr;
	@JsonProperty("isRoundTrip")
	public String isRoundTrip;
	@JsonProperty("isMealRequired")
	public String isMealRequired;
	@JsonProperty("customerEmail")
	public String customerEmail;
	@JsonProperty("bookingTime")
	public Object bookingTime;
	@JsonProperty("bookingStatus")
	public String bookingStatus;
	@JsonProperty("ticketStatus")
	public String ticketStatus;
	@JsonProperty("passenger")
	public List<PassengerDTO> passenger = null;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

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

	public Object getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Object bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<PassengerDTO> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<PassengerDTO> passenger) {
		this.passenger = passenger;
	}

}