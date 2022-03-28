package com.crudapp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.api.config.MessageStrings;
import com.crudapp.api.config.ResponseStatus;
import com.crudapp.api.dto.EmployeeDto;
import com.crudapp.api.dto.ResponseDto;
import com.crudapp.api.exception.CustomException;
import com.crudapp.api.model.Employee;
import com.crudapp.api.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public ResponseDto addNewEmployee(EmployeeDto employeeDto) throws CustomException {
		if (employeeRepository.findByEmail(employeeDto.getEmail()).isPresent()) {
			throw  new CustomException("employee already exists");
		}
		
		Employee newEmployee = new Employee(employeeDto.getName(), employeeDto.getEmail(), employeeDto.getAdress(), employeeDto.getArrival());
		
		try {
			employeeRepository.save(newEmployee);
			return new ResponseDto(ResponseStatus.success.toString(), MessageStrings.EMPLOYEE_CREATED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	public ResponseDto update(EmployeeDto employeeDto) throws CustomException {
		if (!employeeRepository.findByEmail(employeeDto.getEmail()).isPresent()) {
			throw  new CustomException("employee not present");
		}
		
		Employee uptEmployee = new Employee(employeeDto.getName(), employeeDto.getEmail(), employeeDto.getAdress(), employeeDto.getArrival());
		try {
			employeeRepository.save(uptEmployee);
			return new ResponseDto(ResponseStatus.success.toString(), MessageStrings.EMPLOYEE_UPDATED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}		
	}
	
	public ResponseDto delete(String id) throws CustomException {
		if (!employeeRepository.findById(id).isPresent()) {
			throw  new CustomException("employee not present");
		}
		
		Employee employee = employeeRepository.findById(id).get();
		try {
			employeeRepository.delete(employee);
			return new ResponseDto(ResponseStatus.success.toString(), MessageStrings.EMPLOYEE_DELETED);
		} catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
}
