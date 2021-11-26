package com.flightapp.user.dto;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "age" })
@Generated("jsonschema2pojo")
public class PassengerDTO {

	@JsonProperty("passengerID")
	public String passengerID;
	@JsonProperty("name")
	public String name;
	@JsonProperty("age")
	public Integer age;

	public String getPassengerId() {
		return passengerID;
	}

	public void setPassengerId(String passengerId) {
		this.passengerID = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}