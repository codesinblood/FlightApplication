package com.flightapp.airlines.db;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightapp.airlines.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

	List<Route> findAllByFromCityAndToCity(String fromCity, String toCity);
	
    @Query(value = "SELECT * FROM ROUTE WHERE DEPARTURETIME >= :departure AND ARRIVALTIME <= :arrival AND FROMCITY = :from AND TOCITY = :to", nativeQuery = true)
	List<Route> getFights(@Param("departure") LocalTime arrival, @Param("arrival") LocalTime departure, @Param("from") String fromCity, @Param("to") String toCity);
    
	//findBetweenStartAndEndAndFromCityAndToCity
    @Query(value = "SELECT * FROM ROUTE WHERE DEPARTURETIME >= :departure AND ARRIVALTIME <= :arrival AND FROMCITY = :from AND TOCITY = :to AND FLIGHTID IN (SELECT FLIGHTID FROM FLIGHT WHERE STATUS = 'A') ", nativeQuery = true)
	List<Route> getActiveFights(@Param("departure") LocalTime arrival, @Param("arrival") LocalTime departure, @Param("from") String fromCity, @Param("to") String toCity);
	
}
