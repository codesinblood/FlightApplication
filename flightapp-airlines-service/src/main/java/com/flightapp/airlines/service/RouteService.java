package com.flightapp.airlines.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.airlines.db.RouteRepository;
import com.flightapp.airlines.entity.Route;
import com.flightapp.airlines.payload.RouteSDO;

@Service
public class RouteService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	RouteRepository routeRepository;

	public List<RouteSDO> getAllRoutes(String fromCity, String toCity, LocalTime arrival, LocalTime departure, String isRoundTrip) {

		System.out.println("RouteService :: arrival - " + arrival + "departure - " + departure);
		List<Route> routes = new ArrayList<>();
		List<RouteSDO> routeSDOs = new ArrayList<>();
		if (arrival != null && departure != null) {
			routes = routeRepository.getActiveFights(departure, arrival, fromCity, toCity);
		} else {
			routes = routeRepository.findAllByFromCityAndToCity(fromCity, toCity);
		}
		
		if(isRoundTrip.equalsIgnoreCase("yes")) {
			routes.addAll(routeRepository.findAllByFromCityAndToCity(toCity, fromCity));
		}
		
		System.out.println("RouteService :: routes - " + routes.size());
		routes.forEach(x -> {
			routeSDOs.add(mapper.map(x, RouteSDO.class));
		});
		return routeSDOs;
	}

}
