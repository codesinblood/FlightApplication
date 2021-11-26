package com.flightapp.airlines.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

	Optional<Airline> findByName(String airlineName);

	Optional<Airline> findByAirlineId(int i);

	List<Airline> findAllByStatus(Status status);

}
