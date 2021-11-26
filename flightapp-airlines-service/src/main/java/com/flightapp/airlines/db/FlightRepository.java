package com.flightapp.airlines.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.entity.Airline;
import com.flightapp.airlines.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findAllByAirline(Airline airline);

	Optional<Flight> findByFlightId(int flightId);

	List<Flight> findAllByAirlineAndStatus(Airline airline, Status status);

	@Query(value = "UPDATE Flight SET STATUS = :status WHERE AIRLINEID = :airlineId", nativeQuery = true)
	void updateAllFlights(@Param("status") Status status, @Param("airlineId") int airlineId);

}
