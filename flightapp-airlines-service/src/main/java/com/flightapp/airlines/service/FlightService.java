package com.flightapp.airlines.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.db.AirlineRepository;
import com.flightapp.airlines.db.FlightRepository;
import com.flightapp.airlines.entity.Airline;
import com.flightapp.airlines.entity.Flight;
import com.flightapp.airlines.error.NotFoundException;
import com.flightapp.airlines.payload.FlightSDO;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	AirlineRepository airlineRepository;

	@Autowired
	ModelMapper mapper;

	public List<FlightSDO> getFlightsByAirlines(int airlineId, Status status) {

		Optional<Airline> airline = airlineRepository.findByAirlineId(airlineId);
		List<Flight> flights = new ArrayList<Flight>();
		List<FlightSDO> flightSDOs = new ArrayList<FlightSDO>();

		if (airline.isPresent()) {
			if (status != null) {
				flights = flightRepository.findAllByAirlineAndStatus(airline.get(), status);
			} else {
				flights = flightRepository.findAllByAirline(airline.get());
			}
		} else {
			throw new NotFoundException("A_404", "Airline not found");
		}
		flights.forEach(x -> {
			flightSDOs.add(mapper.map(x, FlightSDO.class));
		});
		return flightSDOs;
	}

	public FlightSDO getFlightById(int flightId) {

		Optional<Flight> findByFlightId = flightRepository.findByFlightId(flightId);
		if (findByFlightId.isPresent()) {
			return mapper.map(findByFlightId.get(), FlightSDO.class);
		} else {
			throw new NotFoundException("F_404", "Flight not found");
		}
	}

	public int createFlight(FlightSDO flightSDO) {
		System.out.println(flightSDO);
		Flight flightEntity = mapper.map(flightSDO, Flight.class);
		Optional<Airline> findByAirlineId = airlineRepository.findByAirlineId(flightSDO.getAirline().getAirlineId());
		if (findByAirlineId.isPresent()) {
			flightEntity.setAirline(findByAirlineId.get());
			flightEntity = flightRepository.save(flightEntity);
		} else {
			throw new NotFoundException("A_404", "Airline not found");
		}
		return flightEntity.getFlightId();
	}

}
