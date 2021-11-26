package com.flightapp.airlines.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.flightapp.airlines.constants.BookingStatus;
import com.flightapp.airlines.constants.TicketStatus;

@Entity(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TICKETID")
	private Integer ticketId;

	@Column(name = "PNR")
	private String pnr;

	@Column(name = "ISROUNDTRIP")
	private String isRoundTrip;

	@Column(name = "ISMEALREQUIRED")
	private String isMealRequired;

	@Column(name = "CUSTOMEREMAIL")
	private String customerEmail;

	@Column(name = "BOOKINGDATE")
	private Timestamp bookingTime;

	@Column(name = "TRAVELDATE")
	private Timestamp travelDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "BOOKINGSTATUS")
	private BookingStatus bookingStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = "TICKETSTATUS")
	private TicketStatus ticketStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROUTEID")
	private Route route;

	@OneToMany(mappedBy = "ticket")
	private List<Passenger> passenger;

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

	public Timestamp getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Timestamp travelDate) {
		this.travelDate = travelDate;
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

	public Timestamp getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Timestamp bookingTime) {
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

}
