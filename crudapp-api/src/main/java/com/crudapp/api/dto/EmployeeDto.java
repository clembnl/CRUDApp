package com.crudapp.api.dto;

import java.time.LocalDate;

public class EmployeeDto {
	
	private String id;
	private String name;
	private String email;
	private String adress;
	private LocalDate arrival;
	
	public EmployeeDto() {
	}
	
	public EmployeeDto(String name, String email, String adress, LocalDate arrival) {
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.arrival = arrival;
	}
	
	public EmployeeDto(String id, String name, String email, String adress, LocalDate arrival) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.arrival = arrival;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}	

}
