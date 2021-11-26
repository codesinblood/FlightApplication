package com.flightapp.airlines.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.airlines.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
