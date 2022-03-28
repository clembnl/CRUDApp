package com.crudapp.api.dto;

import java.time.LocalDateTime;

public class EmployeeDto {
	
	private String name;
	private String email;
	private String adress;
	private LocalDateTime arrival;
	
	public EmployeeDto() {
	}
	
	public EmployeeDto(String name, String email, String adress, LocalDateTime arrival) {
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.arrival = arrival;
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

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}	

}
