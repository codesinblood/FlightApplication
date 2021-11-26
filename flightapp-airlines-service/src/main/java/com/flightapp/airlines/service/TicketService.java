package com.flightapp.airlines.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlines.constants.BookingStatus;
import com.flightapp.airlines.constants.TicketStatus;
import com.flightapp.airlines.db.PassengerRepository;
import com.flightapp.airlines.db.RouteRepository;
import com.flightapp.airlines.db.TicketRepository;
import com.flightapp.airlines.entity.Passenger;
import com.flightapp.airlines.entity.Route;
import com.flightapp.airlines.entity.Ticket;
import com.flightapp.airlines.error.NotFoundException;
import com.flightapp.airlines.error.OperationNotAllowedException;
import com.flightapp.airlines.payload.CreateTicketSDO;
import com.flightapp.airlines.payload.TicketSDO;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	ModelMapper mapper;

	@Autowired
	RouteRepository routeRepository;

	@Autowired
	PassengerRepository passengerRepository;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

	public TicketSDO getTicket(String pnr, String emailId) {
		System.out.println(emailId + "------" + pnr);
		Optional<Ticket> ticket = null;
		if (pnr != null && !pnr.isEmpty()) {
			ticket = ticketRepository.findByPnr(pnr);
		} else {
			ticket = ticketRepository.findByCustomerEmail(emailId);
		}

		if (ticket.isPresent()) {
			return mapper.map(ticket.get(), TicketSDO.class);
		} else {
			throw new NotFoundException("T_404", "Ticket not found");
		}

	}

	@SuppressWarnings("deprecation")
	public String bookTicket(CreateTicketSDO ticketSDO) {
		Ticket ticket = mapper.map(ticketSDO, Ticket.class);
		Optional<Route> route = routeRepository.findByRouteId(ticketSDO.getRoute().getRouteId());
		LocalTime flightDepartureTime = route.get().getDepartureTime();
		LocalDateTime departureDateTime = LocalDateTime.of(ticketSDO.getTravelDate().getYear(),
				ticketSDO.getTravelDate().getMonth(), ticketSDO.getTravelDate().getDate(),
				flightDepartureTime.getHour(), flightDepartureTime.getMinute(), flightDepartureTime.getSecond());
		Timestamp departureTime = Timestamp.valueOf(departureDateTime);
		ticket.setBookingTime(Timestamp.from(Instant.now()));
		ticket.setBookingStatus(BookingStatus.INITIATED);
		ticket.setTicketStatus(TicketStatus.WAITLIST);
		ticket.setPnr(generatePnr(ticketSDO.getRoute().getRouteId()));
		ticket.setTravelDate(departureTime);
		ticket = ticketRepository.save(ticket);
		createPassenger(ticketSDO.getPassenger(), ticket);
		return ticket.getPnr();
	}

	public void cancelTicket(String pnr) {

		Optional<Ticket> ticketByPnr = ticketRepository.findByPnr(pnr);
		if (ticketByPnr.isPresent()) {
			Ticket ticket = ticketByPnr.get();
			ZonedDateTime departureTime = ZonedDateTime.ofInstant(ticket.getTravelDate().toInstant(),
					ZoneId.systemDefault());
			
			// Restricting cancelation of tickets with departure time less than 24 hours
			if (ZonedDateTime.now().isBefore(departureTime.plusHours(24))) {
				ticket.setTicketStatus(TicketStatus.CANCELED);
				ticket.setBookingStatus(BookingStatus.REFUNDED);
				ticketRepository.save(ticket);
			} else {
				throw new OperationNotAllowedException("T_400", "Ticket cancelation window exceeded.");
			}
		}
	}

	private String generatePnr(Integer routeId) {
		Optional<Route> routeEntity = routeRepository.findByRouteId(routeId);
		StringBuilder buildPnr = new StringBuilder();
		if (routeEntity.isPresent()) {
			Route route = routeEntity.get();
			return buildPnr.append(route.getFlight().getAirline().getName().substring(0, 3).toUpperCase())
					.append(route.getFromCity().substring(0, 3).toUpperCase())
					.append(route.getToCity().substring(0, 3).toUpperCase()).append(new Date().getTime()).toString();
		} else {
			return buildPnr.append("IND" + new Date().getTime()).toString();
		}
	}

	public void createPassenger(List<Passenger> passenger, Ticket ticket) {
		passenger.forEach(x -> {
			x.setTicket(ticket);
			passengerRepository.save(x);
		});
	}

}
