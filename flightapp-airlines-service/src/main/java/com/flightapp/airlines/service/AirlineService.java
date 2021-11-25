package com.flightapp.airlines.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlines.db.AirlineRepository;
import com.flightapp.airlines.entity.Airline;
import com.flightapp.airlines.error.NotFoundException;
import com.flightapp.airlines.payload.AirlineSDO;

@Service
public class AirlineService {

	@Autowired
	AirlineRepository airlineRepository;

	@Autowired
	ModelMapper mapper;

	public AirlineSDO findAirlineByName(String name) throws NotFoundException {

		Optional<Airline> findByName = airlineRepository.findByName(name);
		if (findByName.isPresent())
			return mapper.map(findByName.get(), AirlineSDO.class);
		else
			throw new NotFoundException("A_404", "Airline not found");
	}

	public int createAirline(AirlineSDO airlineSDO) {

		System.out.println(airlineSDO);
		Airline entity = mapper.map(airlineSDO, Airline.class);
		entity = airlineRepository.save(entity);
		return entity.getAirlineId();
	}

	public void updateAirline(AirlineSDO airlineSDO) {

		Optional<Airline> findByAirlineId = airlineRepository.findByAirlineId(airlineSDO.getAirlineId());
		if (findByAirlineId.isPresent()) {
			findByAirlineId.get().setStatus(airlineSDO.getStatus());
			airlineRepository.save(findByAirlineId.get());
		} else {
			throw new NotFoundException("A_404", "Airline not found");
		}
	}

}
