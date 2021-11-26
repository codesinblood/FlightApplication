package com.flightapp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapp.user.dto.AirlineDTO;
import com.flightapp.user.dto.FlightDTO;
import com.flightapp.user.dto.RouteDTO;

@Service
public class AdminOpsService {

	@Autowired
	RestTemplate customRestTemplate;

	@Value("${url.flightservice:http://localhost:9092/}")
	String baseFlightServiceUrl;

	public String createAirline(AirlineDTO airlineDTO) {

		ResponseEntity<String> response = customRestTemplate
				.postForEntity(baseFlightServiceUrl + "/v1.0/airline/create", airlineDTO, String.class);
		return response.getBody();
	}

	public String updateAirline(AirlineDTO airlineDto) {

		ResponseEntity<String> response = customRestTemplate
				.postForEntity(baseFlightServiceUrl + "/v1.0/airline/create", airlineDto, String.class);
		return response.getBody();
	}

	public String createFlight(FlightDTO flightDTO) {

		ResponseEntity<String> response = customRestTemplate.postForEntity(baseFlightServiceUrl + "/v1.0/flight/create",
				flightDTO, String.class);
		return response.getBody();
	}

	public String createRoute(RouteDTO routeDto) {
		ResponseEntity<String> response = customRestTemplate.postForEntity(baseFlightServiceUrl + "/v1.0/route/create",
				routeDto, String.class);
		return response.getBody();
	}

}
