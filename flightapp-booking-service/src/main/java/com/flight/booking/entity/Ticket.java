package com.flight.booking.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.flightapp.airlines.entity.Route;
import com.flightapp.booking.constant.BookingStatus;
import com.flightapp.booking.constant.TicketStatus;


@Entity(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	private LocalTime bookingTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BOOKINGSTATUS")
	private BookingStatus bookingStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TICKETSTATUS")
	private TicketStatus ticketStatus;
	
	@OneToOne
	@JoinColumn(name="ROUTEID")
	private Route route;

}
