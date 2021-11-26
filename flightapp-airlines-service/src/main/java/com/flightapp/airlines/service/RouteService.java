package com.flightapp.airlines.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlines.constants.Status;
import com.flightapp.airlines.db.RouteRepository;
import com.flightapp.airlines.entity.Route;
import com.flightapp.airlines.payload.RouteSDO;

@Service
public class RouteService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	RouteRepository routeRepository;

	public List<RouteSDO> getAllRoutes(String fromCity, String toCity, LocalTime arrival, LocalTime departure,
			String isRoundTrip) {

		List<Route> routes = new ArrayList<>();
		List<RouteSDO> routeSDOs = new ArrayList<>();
		if (arrival != null && departure != null) {
			routes = routeRepository.getActiveFights(departure, arrival, fromCity, toCity);
		} else {
			routes = routeRepository.findAllByFromCityAndToCityAndStatus(fromCity, toCity, Status.A);
		}

		if (isRoundTrip.equalsIgnoreCase("yes")) {
			routes.addAll(routeRepository.findAllByFromCityAndToCityAndStatus(toCity, fromCity, Status.A));
		}

		routes.forEach(x -> routeSDOs.add(mapper.map(x, RouteSDO.class)));
		return routeSDOs;
	}

}
