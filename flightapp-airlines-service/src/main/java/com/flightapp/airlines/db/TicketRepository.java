package com.flightapp.airlines.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.airlines.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	Optional<Ticket> findByPnr(String pnr);

	Optional<Ticket> findByCustomerEmail(String email);

}