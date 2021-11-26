package com.flightapp.airlines.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlines.db.AirlineRepository;
import com.flightapp.airlines.db.FlightRepository;
import com.flightapp.airlines.entity.Airline;
import com.flightapp.airlines.error.NotFoundException;
import com.flightapp.airlines.payload.AirlineSDO;

@Service
public class AirlineService {

	@Autowired
	AirlineRepository airlineRepository;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ModelMapper mapper;

	public AirlineSDO findAirlineByName(String name) throws NotFoundException {

		Optional<Airline> airline = airlineRepository.findByName(name);
		if (airline.isPresent())
			return mapper.map(airline.get(), AirlineSDO.class);
		else
			throw new NotFoundException("A_404", "Airline not found");
	}

	public int createAirline(AirlineSDO airlineSDO) {

		Airline entity = mapper.map(airlineSDO, Airline.class);
		entity = airlineRepository.save(entity);
		return entity.getAirlineId();
	}

	public void updateAirline(AirlineSDO airlineSDO) {

		Optional<Airline> airline = airlineRepository.findByAirlineId(airlineSDO.getAirlineId());
		if (airline.isPresent()) {
			airline.get().setStatus(airlineSDO.getStatus());
			airlineRepository.save(airline.get());
			//Blocking an airline will block all files associated with the airline. 
			flightRepository.updateAllFlights(airlineSDO.getStatus(), airlineSDO.getAirlineId());
		} else {
			throw new NotFoundException("A_404", "Airline not found");
		}
	}

}
