package com.flightapp.airlines.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.entity.Airline;
import com.flightapp.airlines.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findAllByAirline(Airline airline);

	Optional<Flight> findByFlightId(int id);

	List<Flight> findAllByAirlineAndStatus(Airline airline, Status status);

}
