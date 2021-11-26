package com.flightapp.airlines.payload;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightapp.airlines.constants.BookingStatus;
import com.flightapp.airlines.constants.TicketStatus;
import com.flightapp.airlines.entity.Passenger;
import com.flightapp.airlines.entity.Route;

public class TicketSDO {

	private Integer ticketId;

	private String pnr;

	private String isRoundTrip;

	private String isMealRequired;

	private String customerEmail;

	private LocalTime bookingTime;

	private BookingStatus bookingStatus;

	private TicketStatus ticketStatus;

	private List<Passenger> passenger;

	@JsonIgnore
	private Route route;

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

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

	public LocalTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "TicketSDO [ticketId=" + ticketId + ", pnr=" + pnr + ", isRoundTrip=" + isRoundTrip + ", isMealRequired="
				+ isMealRequired + ", customerEmail=" + customerEmail + ", bookingTime=" + bookingTime
				+ ", bookingStatus=" + bookingStatus + ", ticketStatus=" + ticketStatus + ", route=" + route + "]";
	}

}
