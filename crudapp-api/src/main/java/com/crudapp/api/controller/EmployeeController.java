package com.crudapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.api.dto.EmployeeDto;
import com.crudapp.api.dto.ResponseDto;
import com.crudapp.api.exception.CustomException;
import com.crudapp.api.model.Employee;
import com.crudapp.api.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public List<Employee> fetchAllEmployees() throws CustomException {
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/new")
	public ResponseDto addNewEmployee(@RequestBody EmployeeDto employeeDto) throws CustomException {
		return employeeService.addNewEmployee(employeeDto);
	}
	
	@PutMapping("/update/{employeeID}")
	public ResponseDto update(@PathVariable("employeeID") String id,
							  @RequestBody EmployeeDto employeeDto) throws CustomException {
		return employeeService.update(employeeDto);
	}
	
	@DeleteMapping("/delete/{employeeID}")
	public ResponseDto delete(@PathVariable("employeeID") String id) throws CustomException {
		return employeeService.delete(id);
	}
}
