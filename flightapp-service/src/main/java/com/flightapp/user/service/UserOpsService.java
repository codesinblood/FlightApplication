package com.flightapp.user.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightapp.user.dto.BookTicketDTO;
import com.flightapp.user.dto.RouteDTO;
import com.flightapp.user.dto.TicketDTO;

@Service
public class UserOpsService {

	@Autowired
	RestTemplate customRestTemplate;

	@Value("${url.flightservice:http://localhost:9092/}")
	String baseFlightServiceUrl;

	ObjectMapper objectMapper = new ObjectMapper();

	public List<RouteDTO> searchRoutes(String from, String to, String start, String end, String roundtrip)
			throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseFlightServiceUrl + "/v1.0/route")
				.queryParam("from", "{from}").queryParam("to", "{to}").queryParam("start", "{start}")
				.queryParam("end", "{end}").queryParam("roundtrip", "{roundtrip}").encode().toUriString();

		Map<String, String> params = new HashMap<>();
		params.put("from", from);
		params.put("to", to);
		params.put("start", start);
		params.put("end", end);
		params.put("roundtrip", roundtrip);

		ResponseEntity<String> routeResponse = customRestTemplate.exchange(urlTemplate, HttpMethod.GET, entity,
				String.class, params);

		return Arrays.asList(objectMapper.readValue(routeResponse.getBody(), RouteDTO[].class));
	}

	public String bookTicket(BookTicketDTO ticketDTO) {

		ResponseEntity<String> response = customRestTemplate.postForEntity(baseFlightServiceUrl + "/v1.0/ticket/save",
				ticketDTO, String.class);
		return response.getBody();
	}

	public TicketDTO searchTicket(String email, String pnr) throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseFlightServiceUrl + "/v1.0/ticket")
				.queryParam("email", "{email}").queryParam("pnr", "{pnr}").encode().toUriString();

		Map<String, String> params = new HashMap<>();
		params.put("email", email);
		params.put("pnr", pnr);

		ResponseEntity<String> routeResponse = customRestTemplate.exchange(urlTemplate, HttpMethod.GET, entity,
				String.class, params);

		return objectMapper.readValue(routeResponse.getBody(), TicketDTO.class);
	}

	public String cancelTicket(String pnr) {

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		String urlTemplate = UriComponentsBuilder.fromHttpUrl(baseFlightServiceUrl + "/v1.0/ticket/cancel")
				.queryParam("pnr", "{pnr}").encode().toUriString();

		Map<String, String> params = new HashMap<>();
		params.put("pnr", pnr);

		ResponseEntity<String> routeResponse = customRestTemplate.exchange(urlTemplate, HttpMethod.PUT, entity,
				String.class, params);
		return routeResponse.getBody();
	}

}
